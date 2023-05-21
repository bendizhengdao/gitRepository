package com.ssm.condition;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.ssm.annotation.RedisListener;
import com.ssm.inter.RedisUtil;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
@Slf4j
public class RedisBeanPostProcessor implements BeanPostProcessor {
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class<? extends Object> aClass = bean.getClass();
		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			RedisListener annotation = method.getAnnotation(RedisListener.class);
			if(annotation !=null){
				Jedis jedis = redisUtil.getJedis();
				//String channel = StringUtils.isBlank(annotation.channel())?"*":annotation.channel(); 
				log.info("添加一个订阅"+aClass.getSimpleName()+"#"+method.getName());
				//exceutorService.execute(()->jedis.subscribe(new RedisSubscribe(bean,method),channel));
			}
		}
		return bean;
	}

}
