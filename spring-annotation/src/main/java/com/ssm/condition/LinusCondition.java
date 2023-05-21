package com.ssm.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * 
 * @author interface
 *
 */
public class LinusCondition implements Condition {
	/***
	 * ConditionContext:判断条件能使用的上下文环境
	 * AnnotatedTypeMetadata:注释信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取到IOC使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取当前环境信息
		Environment environment = context.getEnvironment();
		//获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//判断容器中是否存在person Bean
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		String property = environment.getProperty("os.name");
		if (property.contains("Linux")) {
			return true;
		}
		return false;
	}
}
