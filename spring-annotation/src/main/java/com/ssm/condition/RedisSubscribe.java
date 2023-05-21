package com.ssm.condition;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

@Slf4j
public class RedisSubscribe extends JedisPubSub {

	private Object target;
	
	private Method method;
	
	public RedisSubscribe(Object target,Method method){
		this.target = target;
		this.method = method;
	}
	
	public void onMessage(String channel,String message){
		
		try {
			method.invoke(target, channel);
		} catch (IllegalAccessException |InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
