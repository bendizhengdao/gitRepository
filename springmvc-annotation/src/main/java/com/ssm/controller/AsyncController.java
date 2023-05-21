package com.ssm.controller;

import java.util.UUID;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.ssm.config.DeferredResultQueue;

@Controller
public class AsyncController {
	
	@RequestMapping("/async01")
	@ResponseBody
	public Callable<String> async01(){
		new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Callable<String> async01()";
			}
		};
		return null;
	}
	
	@RequestMapping("/createOrder")
	@ResponseBody
	public DeferredResult<Object> async02(){
		DeferredResult<Object> deferredResult = new DeferredResult<>((long)3000,"create fail");
		DeferredResultQueue.save(deferredResult);
		return deferredResult;
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public String create(){
		String orderId = UUID.randomUUID().toString();
		DeferredResult<Object> deferredResult = DeferredResultQueue.get();
		deferredResult.setResult(orderId);
		return "success";
	}
}
