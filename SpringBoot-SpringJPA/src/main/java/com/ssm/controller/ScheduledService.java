package com.ssm.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
	@Scheduled(cron="0/1 * * * * ?")
	public void sayHello(){
		
	}
	
	@Scheduled(cron="0/1 * * * * ?")
	public void sayNo(){
		
	}
}
