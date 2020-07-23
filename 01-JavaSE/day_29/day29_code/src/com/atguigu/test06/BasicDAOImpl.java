package com.atguigu.test06;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicDAOImpl<T> {
	//type代表T的实际类型
	private Class<T> type;
	
	//在创建子类对象时，一定会调用父类的构造，默认调用父类的无参构造
	public BasicDAOImpl(){
		//这个this是你正在new的对象
		//那么这个clazz就是正在new对象的那个子类的类型的Class对象
		Class<? extends BasicDAOImpl> clazz = this.getClass();
		Type t = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;//为什要强制，因为为了调用getActualTypeArguments
		Type[] types = pt.getActualTypeArguments();
		type = (Class) types[0];
	}
	
	//通用的增、删、改方法
	public int update(String sql,Object... args)throws SQLException{
		Connection conn = JDBCToolsV3.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		if(args != null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		int len = pst.executeUpdate();
		pst.close();
		///JDBCToolsV3.free(conn);//故意不关，考虑到线程在多个位置可能共享同一个连接对象
		return len;
	}
	
	//通用的查询，一个T对象
	public T getBean(String sql,Object... args)throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Connection conn = JDBCToolsV3.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		if(args != null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		//第一步，创建T的对象
		T t = type.newInstance();
		
		ResultSet rs = pst.executeQuery();
		
		/*
		 * 结果集的元数据对象，(元数据：描述数据的数据，描述结果集中的数据的数据）
		 * 例如：结果集记录的列数
		 *     结果集的字段列表的名称
		 * 相当于SQLyog查询结果的标题行
		 */
		ResultSetMetaData metaData = rs.getMetaData();
		int counts = metaData.getColumnCount();//列数
		
		//这里用if,因为就查询一个对象，就一行
		if(rs.next()){
			//为t对象的属性赋值
			/*
			 * 反射如何为任意对象的任意属性赋值
			 * （1）获取属性对象
			 * Field field = clazz.getDeclaredField("属性名");
			 * （2）设置属性可访问
			 * field.setAccessible(true);
			 * （3）设置属性值
			 * field.set(t,属性值);
			 */
			//有几列，说明有几个属性
			//为counts个属性赋值
			for (int i = 0; i < counts; i++) {
//				Field field = type.getDeclaredField(metaData.getColumnName(i+1));//这个是数据库中的列的字段名
				Field field = type.getDeclaredField(metaData.getColumnLabel(i+1));//要获取Javabean中属性名，在sql语句中，用别名来代表类的属性名
				field.setAccessible(true);
				field.set(t, rs.getObject(i+1));
			}
		}
		
		rs.close();
		pst.close();
		return t;
	}
	
	//通用的查询，多个T对象
	public List<T> getBeanList(String sql,Object... args)throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Connection conn = JDBCToolsV3.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		if(args != null && args.length>0){
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
		}
		
		ArrayList<T> list = new ArrayList<T>();
		ResultSet rs = pst.executeQuery();
		
		/*
		 * 结果集的元数据对象，(元数据：描述数据的数据，描述结果集中的数据的数据）
		 * 例如：结果集记录的列数
		 *     结果集的字段列表的名称
		 * 相当于SQLyog查询结果的标题行
		 */
		ResultSetMetaData metaData = rs.getMetaData();
		int counts = metaData.getColumnCount();//列数
		
		//while循环一次，代表一行
		while(rs.next()){
			//第一步，创建T的对象
			T t = type.newInstance();
			//为t对象的属性赋值
			/*
			 * 反射如何为任意对象的任意属性赋值
			 * （1）获取属性对象
			 * Field field = clazz.getDeclaredField("属性名");
			 * （2）设置属性可访问
			 * field.setAccessible(true);
			 * （3）设置属性值
			 * field.set(t,属性值);
			 */
			//有几列，说明有几个属性
			//为counts个属性赋值
			for (int i = 0; i < counts; i++) {
				Field field = type.getDeclaredField(metaData.getColumnName(i+1));
				field.setAccessible(true);
				field.set(t, rs.getObject(i+1));
			}
			
			list.add(t);
		}
		
		rs.close();
		pst.close();
		return list;
	}
}
