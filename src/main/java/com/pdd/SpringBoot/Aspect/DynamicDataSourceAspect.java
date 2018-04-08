package com.pdd.SpringBoot.Aspect;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.pdd.SpringBoot.Annotation.changeDataSource;
import com.pdd.SpringBoot.DataSourceConf.DynamicDataSourceContextHolder;

@Aspect
@Component
/**
 * 动态代理
 * AOP切面
 * 
 * @author Admin
 *
 */
public class DynamicDataSourceAspect {
	
	private final Logger log=Logger.getLogger(DynamicDataSourceAspect.class);
	
	//切入点为标识了@changeDataSource注解的地方
	@Pointcut(value="@annotation(com.pdd.SpringBoot.Annotation.changeDataSource)")
	public void pointcut(){}
	
	@Before("pointcut()")
	public void befor(JoinPoint jp){
		//拿到被代理对象
		 Signature sig=jp.getSignature();
		 //转换为方法级别代理对象
		 MethodSignature methodSignature = (MethodSignature)sig;
		 //拿到被代理的方法
		 Method targetMethod = methodSignature.getMethod();
		 //判断其是否被注上@changeDataSource注解 如果没注上此注解则不进入替换数据源
		 if(targetMethod.isAnnotationPresent(changeDataSource.class)){
			 //拿到方法上面注解
			 changeDataSource dataSource=targetMethod.getAnnotation(changeDataSource.class);
			 //拿到注解内的值
			 String key=dataSource.value().getKey();
			 log.info("################>> 使用的数据源:"+key+" <<################");
			 DynamicDataSourceContextHolder.setDataSourceType(key);//设置数据源Key
		 }
	}
	
	@After("pointcut()")
    public void after(JoinPoint point) {
		//代理对象立马移除修改后数据源
		//使用默认数据源操作其他资源
		DynamicDataSourceContextHolder.clearDataSourceType();
    }  
}
