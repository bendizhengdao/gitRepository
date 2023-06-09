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
public class BillGatesCondition implements Condition {

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
		String property = environment.getProperty("os.name");
		if (property.contains("Windows")) {
			return true;
		}
		return false;
	}

}
