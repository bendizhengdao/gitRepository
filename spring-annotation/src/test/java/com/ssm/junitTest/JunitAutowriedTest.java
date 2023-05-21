package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.config.MainConfigOfAutowired;
import com.ssm.config.MainConfigOfProfile;
import com.ssm.dao.BookDao;
import com.ssm.service.BookService;

public class JunitAutowriedTest {
	
	public void printBeans(ApplicationContext applicationContext){
		String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
		for (String beanName:beanNamesForType) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void testProfile(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test"); 
		//注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//启动刷新容器
		applicationContext.refresh();
		applicationContext.close();
	}
	
	@Test
	public void testAutowired(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		BookDao bookDao = applicationContext.getBean(BookDao.class);
		System.out.println(bookDao);
		applicationContext.close();
	}
}
