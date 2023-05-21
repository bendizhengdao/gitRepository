package com.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ssm.bean.Person;
/**
 * 使用@PropertySource读取外部配置文件中的k/v保存到运行环境中,通过@Value获取容器中的k/v
 * 
 * @author interface
 *
 */
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person(){
		return new Person();
	}
}
