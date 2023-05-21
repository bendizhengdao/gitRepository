package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.ssm.bean.Blue;
import com.ssm.bean.Person;
import com.ssm.config.MainConfig;
import com.ssm.config.MainConfig2;

public class JunitAnnotationTest {
	
	
	
	@Test
	public void testFactoryBean(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
		//工厂Bean获取的是调用getObject创建的对象
		Object bean = applicationContext.getBean("colorFactoryBean");
		System.out.println("获取factoryBean的Class:"+bean.getClass());
		
		bean = applicationContext.getBean("&colorFactoryBean");
		System.out.println("&获取factoryBean的Class:"+bean.getClass());
	}
	
	@Test
	public void testImportBeanDefinitionRegistrar(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);
	}
	
	@Test
	public void testImportSelector(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);
	}
	
	@Test
	public void testImport(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
	}
	
	public void printBeans(ApplicationContext applicationContext){
		String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
		for (String beanName:beanNamesForType) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void testConditional(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Environment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("输出环境为："+property);
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String beanName:beanNamesForType) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void testScope(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		System.out.println("开始获取person对象");
		Person person1 = (Person) applicationContext.getBean(Person.class);
		Person person2 = (Person) applicationContext.getBean(Person.class);
		System.out.println(person1==person2);
	}
	
	@Test
	public void testConfiguration(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = (Person) applicationContext.getBean(Person.class);
		System.out.println(person);
	}
	
	@Test
	public void testComponentScan(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
}
