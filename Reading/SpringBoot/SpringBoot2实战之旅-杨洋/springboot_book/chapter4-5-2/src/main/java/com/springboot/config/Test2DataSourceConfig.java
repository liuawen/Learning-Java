package com.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.springboot.mapper.datasource2",
        sqlSessionTemplateRef = "sqlSessionTemplateSecondary")
public class Test2DataSourceConfig {

    @Bean(name = "sqlSessionFactorySecondary")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
       // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/datasource2/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManagerSecondary")
    public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateSecondary")
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("sqlSessionFactorySecondary") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}