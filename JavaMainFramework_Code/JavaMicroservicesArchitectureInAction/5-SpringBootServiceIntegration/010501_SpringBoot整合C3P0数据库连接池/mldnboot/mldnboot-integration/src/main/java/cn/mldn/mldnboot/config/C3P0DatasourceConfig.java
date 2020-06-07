package cn.mldn.mldnboot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class C3P0DatasourceConfig {
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "c3p0")	// 定义资源导入前导标记
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(
				com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	}
}
