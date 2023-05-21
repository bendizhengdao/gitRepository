package com.ssm.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 默认加载容器中的组件,容器启动会调用无参构造器创建对象，再进行初始化赋值操作
 * @author interface
 *
 */
@Component
public class Boss {
	
	@Autowired
	private Car car;

	public Car getCar() {
		return car;
	}
	
	@Autowired
	public Boss(Car car) {
		this.car = car;
	}
	
	@Autowired
	public void setCar(Car car) {
		this.car = car;
	}
}
