package com.ssm.aop;

import com.ssm.annotation.LogAnnotation;

public class MathCalculator {
	
	@LogAnnotation
	public int div(int i,int j){
		System.out.println("MathCalculator....div");
		return i/j;
	}
	
}
