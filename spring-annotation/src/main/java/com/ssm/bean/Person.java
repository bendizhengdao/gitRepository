package com.ssm.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 使用 @Value赋值 
 * 	基本数值:@Value("张三")
 *  SpEL: @Value("#{30-12}")
 *  ${}:取出配置文件中内容
 * 
 * @author interface
 *
 */
public class Person {
	@Value("张三")
	private String userName;
	@Value("#{40-12}")
	private Integer age;
	@Value("${person.nickName}")
	private String nickName;

	public Person(String userName, Integer age, String nickName) {
		super();
		this.userName = userName;
		this.age = age;
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String userName, Integer age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", age=" + age + ", nickName=" + nickName + "]";
	}

}
