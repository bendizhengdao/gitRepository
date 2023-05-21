package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.ext.ExtConfig;

public class JunitExtTest {
	
	@Test
	public void testBeanFactoryPostProcessor(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
		applicationContext.close();
	}
}
