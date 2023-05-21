package com.ssm.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.ssm.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	
	/**
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类
	 * 		把所有需要添加到容器中的bean,调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition()注册
	 * 
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean redDefinition = registry.containsBeanDefinition("com.ssm.bean.Red");
		boolean blueDefinition = registry.containsBeanDefinition("com.ssm.bean.Blue");
		if (redDefinition&&blueDefinition) {
			//指定Bean定义信息
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个Bean,指定bean名
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	}

}
