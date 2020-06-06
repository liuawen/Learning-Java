package cn.itcast.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0工具类
 * 
 * @author Never Say Never
 * @date 2016年11月26日
 * @version V1.0
 */
public class C3P0Utils {
    // 1.使用无参的方法，它会默认加载c3p0-config.xml里面的<default-config>配置项
    // 如果指定了参数，那么他会加载c3p0-config.xml里面的<named-config>配置项
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 使用ThreadLocal来解决线程安全(不用传递connection完成事务处理)
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /**
     * 提供数据源方法
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获得连接的方法（使用线程本地变量） 一定要保证是从threadLocal里面获取的conn对象
     */
    public static Connection getConnnection() {
        Connection conn = threadLocal.get();
        if(conn==null){
            try {
                //使用数据源获得一个新的conn对象
                conn = dataSource.getConnection();
                //将这个conn对象放到threadLocal中去，方便以后获取的数据一致的
                threadLocal.set(conn);
                return threadLocal.get();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 释放资源方法
     */

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if (pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
