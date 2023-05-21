package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.config.MainConfigOfLifeCycle;

public class JunitLifeCycleTest {
	
	public void printBeans(ApplicationContext applicationContext){
		String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
		for (String beanName:beanNamesForType) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void testInitDestoryMethod(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建成功");
		//关闭容器
		applicationContext.close();
	}
	
	@Test
	public void testInitializingBeanAndDisposableBeanMethod(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建成功");
		//关闭容器
		applicationContext.close();
	}
	
	@Test
	public void testPostConstructAndPreDestroyMethod(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建成功");
		//关闭容器
		applicationContext.close();
	}
	
	@Test
	public void testBeanPostProcessorMethod(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建成功");
		//关闭容器
		applicationContext.close();
	}
	
}
