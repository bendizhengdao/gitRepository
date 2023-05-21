package com.ssm.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor.........postProcessBeanFactory.....start..........");
//		int count = beanFactory.getBeanDefinitionCount();
//		String[] beanNames = beanFactory.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println("beanName  ==== "+beanName);
//		}
	}
}
