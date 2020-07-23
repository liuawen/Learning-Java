package com.atguigu.test07;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.test06.BasicDAOImpl;

public abstract class BasicDAOImpl2<T> {
	//type代表T的实际类型
	private Class<T> type;
	private QueryRunner qr = new QueryRunner();
	
	//在创建子类对象时，一定会调用父类的构造，默认调用父类的无参构造
	public BasicDAOImpl2(){
		//这个this是你正在new的对象
		//那么这个clazz就是正在new对象的那个子类的类型的Class对象
		Class<? extends BasicDAOImpl2> clazz = this.getClass();
		Type t = clazz.getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;//为什要强制，因为为了调用getActualTypeArguments
		Type[] types = pt.getActualTypeArguments();
		type = (Class) types[0];
	}
	
	public int update(String sql,Object... args)throws SQLException{
		return qr.update(JDBCToolsV4.getConnection(), sql, args);
	}
	
	public T getBean(String sql,Object... args)throws SQLException{
		return qr.query(JDBCToolsV4.getConnection(), sql, new BeanHandler<>(type), args);
	}
	
	public List<T> getBeanList(String sql,Object... args)throws SQLException{
		return qr.query(JDBCToolsV4.getConnection(), sql, new BeanListHandler<>(type), args);
	}
	
	public Object getObject(String sql,Object... args)throws SQLException{
		return qr.query(JDBCToolsV4.getConnection(), sql, new ScalarHandler(), args);
	}
	
	public Map getMap(String sql,Object... args)throws SQLException{
		return qr.query(JDBCToolsV4.getConnection(), sql, new MapHandler(), args);
	}
	
	public List<Map<String,Object>> getMapList(String sql,Object... args)throws SQLException{
		return qr.query(JDBCToolsV4.getConnection(), sql, new MapListHandler(), args);
	}
}
