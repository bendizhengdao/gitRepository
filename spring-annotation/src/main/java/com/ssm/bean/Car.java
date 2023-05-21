package com.ssm.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {
	
	public Car() {
		System.out.println("Car Constructor.....");
	}
	
	public void init(){
		System.out.println("Car init.....");
	}
	
	public void destory(){
		System.out.println("Car destory.....");
	}
}
