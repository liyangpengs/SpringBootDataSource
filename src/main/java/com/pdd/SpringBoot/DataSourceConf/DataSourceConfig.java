package com.pdd.SpringBoot.DataSourceConf;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.pdd.SpringBoot.dao")
public class DataSourceConfig {
	
	@Bean
    @ConfigurationProperties(prefix="spring.datasource.one")
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
    @ConfigurationProperties(prefix="spring.datasource.two")
	public DataSource secondaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public DataSource dataSource(){
		DynamicDataSource dds=new DynamicDataSource();
		dds.setDefaultTargetDataSource(primaryDataSource());
		Map<Object, Object> map=new HashMap<>();
		map.put("read", primaryDataSource());
		map.put("write", secondaryDataSource());
		dds.setTargetDataSources(map);
		return dds;
	}
	
}
