package com.adventureisland.demo.util;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@PropertySource({ "classpath:database.properties" })
@MapperScan(basePackages = { "${primary.datasource.base-packages}" }, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class DatabaseConfig {
	
	@Value("${primary.datasource.mapper-locations}")
	private String primaryMapperLocations;
	
	@Value("${primary.datasource.type-aliases-package}")
	private String primaryTypeAliasesPackage;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "primary.database")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource)
			throws Exception {
		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(primaryDataSource);
		sqlSessionFactory.setTypeAliasesPackage(primaryTypeAliasesPackage);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(primaryMapperLocations));
		return sqlSessionFactory.getObject();
	}
}
