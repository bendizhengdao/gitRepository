package com.ssm.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 扩展原理:
 * 
 * BeanDefinitionRegistry:
 * 		bean定义信息的保存中心,BeanFactory按照BeanDefinitionRegistry来创建对象
 * 
 * 		
 * BeanPostProcessor:
 * 		bean后置处理器,bean创建对象进行初始化前后进行拦截工作的
 * 	
 * BeanFactoryPostProcessor:beanFactory后置处理器
 * 		在BeanFactory标准初始化之后调用,
 * 		所有bean定义已经保存加载到beanFactory,但是实例没有被创建
 * 		AbstractApplicationContext.invokeBeanFactoryPostProcessors()
 * 			执行BeanFactoryPostProcessor
 * 			1:直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor,并且执行他们的方法
 * 			2:在初始化创建其他组件前面执行
 * 
 * BeanDefinitionRegistryPostProcessor:
 * 		postProcessBeanDefinitionRegistry()
 * 		所有bean定义信息将要被加载到beanFactory,但是实例没有被创建(在BeanFactoryPostProcessor之前执行)
 * 
 * ApplicationListener:监听容器中发布的事件,事件驱动模型开发
 * 		监听 ApplicationEvent
 * 
 * 自定义事件监听:
 * 		1:自定义事件 (extends ApplicationEvent)
 * 		2:自定义监听器(implements ApplicationListener)
 * 		3:发布事件:
 * 				ApplicationContext applicationContext = new ApplicationContext();
 * 				applicationContext.publishEvent(new ApplicationEvent(new String("")) {
				});
 * 
 * 		AbstractApplicationContext.finishRefresh()
 * 
 * @EventListener:
 * 		监听事件
 * 		EventListenerMethodProcessor:
 * 			SmartInitializingSingleton:
 * 				AbstractApplicationContext.finishBeanFactoryInitialization()所有的单实例Bean创建完成后,
 * 				执行SmartInitializingSingleton.afterSingletonsInstantiated()
 * 
 * @author interface
 *
 */

import com.ssm.bean.Blue;
@Configuration
@ComponentScan("com.ssm.ext")
public class ExtConfig {
	
	@Bean
	public Blue blue(){
		return new Blue();
	}
}
