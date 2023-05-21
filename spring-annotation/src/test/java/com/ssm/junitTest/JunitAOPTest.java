package com.ssm.junitTest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssm.aop.MathCalculator;
import com.ssm.config.MainConfigOfAOP;

public class JunitAOPTest {
	
	@Test
	public void testAOPAnnotation(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		mathCalculator.div(1, 1);
		applicationContext.close();
	}
	
}
