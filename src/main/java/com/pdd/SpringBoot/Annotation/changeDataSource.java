package com.pdd.SpringBoot.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pdd.SpringBoot.Enum.DataSourceKey;

/**
 * 切换数据源注解
 * 此注解只能标识在方法上
 * @author Admin
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface changeDataSource {
	//值为Enum
	DataSourceKey value() default DataSourceKey.rDaraSource; //默认为读取数据源
}
