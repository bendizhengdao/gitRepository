package com.ssm.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	public Dog() {
		System.out.println("Dog Constructor.....");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Dog init.....@PostConstruct");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Dog destory.....@PreDestroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
