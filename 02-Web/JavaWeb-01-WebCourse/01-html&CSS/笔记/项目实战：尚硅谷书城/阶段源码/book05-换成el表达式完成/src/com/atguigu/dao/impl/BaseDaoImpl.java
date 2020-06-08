package com.atguigu.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atguigu.util.JDBCUtils;

/**
 * 我们使用的是DBUtil操作数据库
 * 
 * @author wzg
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> {

	/**
	 * DBUtils操作数据库需要使用的类
	 */
	protected QueryRunner queryRunner;
	/**
	 * 保存BaseDaoImpl类的泛型对象class类型
	 */
	protected Class<T> type;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 创建一个QueryRunner对象实例
		queryRunner = new QueryRunner();
		// 获取父类中带有泛型的父类的class类型
		ParameterizedType supperClass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		// 获取泛型中的具体的类型的class
		type = (Class<T>) supperClass.getActualTypeArguments()[0];
	}

	/**
	 * 执行update，delete,insert语句
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param params
	 *            执行的sql语句的参数
	 * @return 如果语句执行成功返回true<br/>
	 *         如果执行失败返回false
	 */
	public int update(String sql, Object... params) {
		Connection connection = null;
		int updateCount = 0;
		try {
			connection = JDBCUtils.getConnection();
			updateCount = queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(connection);
		}
		return updateCount;
	}

	/**
	 * 执行查询语句，只返回第一个记录
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param params
	 *            执行的sql语句的参数
	 * @return 返回查询对象的具体实例 <br/>
	 *         如果查询的数据不存在，则返回null<br/>
	 *         查询失败也返回null
	 */
	public T queryOne(String sql, Object... params) {
		Connection connection = null;

		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.query(connection, sql, new BeanHandler<T>(type),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(connection);
		}

		return null;
	}

	/**
	 * 执行查询语句，返回查询后的对象实例集合
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param params
	 *            sql语句的参数
	 * @return 返回的是查找到的对象集合<br/>
	 *         查询失败返回null
	 */
	public List<T> queryList(String sql, Object... params) {
		Connection connection = null;

		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.query(connection, sql, new BeanListHandler<T>(
					type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(connection);
		}

		return null;
	}

}
