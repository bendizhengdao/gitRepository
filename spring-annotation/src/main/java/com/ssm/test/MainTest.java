package com.ssm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
		/*
		    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
			Person person = (Person) applicationContext.getBean("person");
			System.out.println(person);
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = (Person) applicationContext.getBean("person01");
		System.out.println(person);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String type : beanNamesForType) {
			System.out.println(type);
		}
		*/
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
}
