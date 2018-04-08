package com.pdd.SpringBoot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
/**
 * 自定义数据源必须移除自动数据源配置
 * 否则自定义数据源不起效果
 * 
 * 报异常 -------->The Dependencies of some of the beans in the application from of cycle
 * 
 * @author Admin
 *
 */
@SpringBootApplication(exclude={
	DataSourceAutoConfiguration.class
})
public class StartApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(ApplicationContext.class).child(StartApplication.class).run(args);
	}
}
