package com.pdd.SpringBoot.Aspect;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class ControllerAspect {
	
	private final Logger log=Logger.getLogger(ControllerAspect.class);
	
	@Pointcut("execution(* com.pdd.SpringBoot.Controller..*.*(..))")
	public void pointcut(){};
	@Before("pointcut()")
	public void befor(JoinPoint jp){
		MethodSignature  st=(MethodSignature)jp.getSignature();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		log.info("################>> 请求IP:"+request.getRemoteAddr()+" <<################");
		log.info("################>> 请求路径:"+request.getRequestURL()+" <<################");
		log.info("################>> 执行的方法名称:"+st.getName()+" <<################");
		log.info("################>> 方法所在的包名:"+st.getMethod().getDeclaringClass()+" <<################");
		log.info("################>> 请求参数:"+request.getQueryString()+" <<################");
		log.info("################>> 请求返回结果:"+st.getReturnType()+" <<################");
	}
}
