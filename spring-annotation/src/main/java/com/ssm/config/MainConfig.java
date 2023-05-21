package com.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.ssm.bean.Person;
import com.ssm.service.MainService;

@Configuration
//不包含@Controller和@Service
//@ComponentScan(value="com.ssm",excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}))
//只包含@Controller
@ComponentScan(value="com.ssm",includeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}), //指定的注解
	@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MainService.class}),//指定的类型
	@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class}),//使用自定义的TypeFilter类型
	},useDefaultFilters=false)

@ComponentScans(value={
		@ComponentScan(value="com.ssm",includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),useDefaultFilters=false)
})
public class MainConfig {
	
	@Bean
	public Person person01(){
		return new Person("李四", 32);
	}
}
