package com.itheima.utils;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 工具类
 */
public class MybatisUtils {	
    public static SqlSessionFactory sqlSessionFactory = null;
    // 初始化SqlSessionFactory对象
    static{
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取SqlSession对象的静态方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
