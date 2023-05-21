package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.bean.Person;
import com.ssm.config.MainConfigOfPropertyValues;

public class JunitPropertyValuesTest {

	public void printBeans(ApplicationContext applicationContext){
		String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
		for (String beanName:beanNamesForType) {
			System.out.println(beanName);
		}
	}
	
	
	@Test
	public void testPropertyValues(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
		Person person = applicationContext.getBean("person",Person.class);
		System.out.println("person============="+person);
		printBeans(applicationContext);
		applicationContext.close();
	}
}
