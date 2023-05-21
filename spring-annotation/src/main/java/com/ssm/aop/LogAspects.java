package com.ssm.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {
	
	@Pointcut("@annotation(com.ssm.annotation.LogAnnotation)")
	public void pointcut(){
		
	}
	
	@Before("pointcut()")
	public void logStart(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println("Method Name: "+jp.getSignature().getName()+"	@Before	除法运行开始....参数列表是,{"+Arrays.asList(args)+"}");
	}
	
	@After("pointcut()")
	public void logEnd(JoinPoint jp){
		Object[] args = jp.getArgs();
		System.out.println("Method Name: "+jp.getSignature().getName()+"	@After	除法运行结束....参数列表是,{"+Arrays.asList(args)+"}");
	}
	
	@AfterReturning(value="pointcut()",returning="result")
	public void logReturn(JoinPoint jp,Object result){
		System.out.println("Method Name: "+jp.getSignature().getName()+"	@AfterReturning	除法正常返回....运行结果是,{"+result+"}");
	}
	
	@AfterThrowing(value="pointcut()",throwing="ex")
	public void logException(JoinPoint jp,Exception ex){
		System.out.println("Method Name: "+jp.getSignature().getName()+"	@AfterThrowing	除法异常....异常信息是,{"+ex+"}");
	}
	
}
