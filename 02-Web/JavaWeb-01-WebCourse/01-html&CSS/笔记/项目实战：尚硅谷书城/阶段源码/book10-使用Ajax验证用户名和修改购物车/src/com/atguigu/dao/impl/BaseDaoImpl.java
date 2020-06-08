package com.atguigu.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executors;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
		ParameterizedType supperClass = (ParameterizedType) getClass().getGenericSuperclass();
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
	 * @throws SQLException 
	 */
	public int update(String sql, Object... params) throws SQLException {
		Connection connection = null;
		int updateCount = 0;
		try {
			connection = JDBCUtils.getConnection();
			updateCount = queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
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
	 * @throws SQLException 
	 */
	public T queryOne(String sql, Object... params) throws SQLException {
		Connection connection = null;
		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.query(connection, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
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
	 * @throws Exception 
	 */
	public List<T> queryList(String sql, Object... params) throws Exception {
		Connection connection = null;

		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.query(connection, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 执行批量操作
	 * 
	 * @param sql
	 *            要执行的sql语句
	 * @param params
	 *            参数
	 * @return 返回每个语句修改的数量
	 * @throws Exception 
	 */
	public int[] batch(String sql, Object[][] params) throws Exception {
		Connection connection = null;

		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.batch(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 查询只有一个返回值的语句
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public Object querySingleValue(String sql, Object... params) throws Exception {
		Connection connection = null;

		try {
			// 获取数据库连接
			connection = JDBCUtils.getConnection();
			// 执行查询语句
			return queryRunner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
