package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RedisController {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@RequestMapping("add")
	public String addRedis(){
		redisTemplate.opsForValue().set("name", "谭宗卯");
		return "addSuccess";
	}
	@RequestMapping("get")
	public String getRedis(){
		String object = (String) redisTemplate.opsForValue().get("name");
		return object;
	}
}
