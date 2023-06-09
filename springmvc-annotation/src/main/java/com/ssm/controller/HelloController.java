package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return helloService.sayHello("tom");
	}
}
