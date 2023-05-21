package com.ssm.condition;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.inter.Publisher;
import com.ssm.inter.RedisUtil;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisPublisher implements Publisher {

	@Autowired
	RedisUtil redisUtil;
	
	public void publish(String channel,String message){
		Jedis jedis = redisUtil.getJedis();
		try {
			log.info("发布一个消息" + channel + "---->" + message);
			jedis.publish(channel, message);
		} finally {
			jedis.close();
		}
	}
}
