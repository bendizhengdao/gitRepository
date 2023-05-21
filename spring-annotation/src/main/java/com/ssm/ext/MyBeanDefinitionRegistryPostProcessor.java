package com.ssm.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.........postProcessBeanFactory.....start..........");
//		int count = beanFactory.getBeanDefinitionCount();
//		String[] beanNames = beanFactory.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println("beanName  ==== "+beanName);
//		}

	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.........postProcessBeanDefinitionRegistry.....start..........");
		//RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
		//BeanDefinitionBuilder rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class);
		//registry.registerBeanDefinition("hello", beanDefinition);
	}

}
