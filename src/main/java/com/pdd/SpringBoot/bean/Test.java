package com.pdd.SpringBoot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//引入其他配置文件
@PropertySource("classpath:pdd.properties")
//指定使用的字段前缀
@ConfigurationProperties(prefix="test")
//注入IOC
@Component
public class Test {
	private String name;
	private String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
