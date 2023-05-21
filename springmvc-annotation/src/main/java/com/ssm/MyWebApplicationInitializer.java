package com.ssm;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ssm.config.AppConfig;
import com.ssm.config.RootConfig;
/**
 * web容器启动时候创建对象,调用方法来初始化容器
 * @author interface
 *
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	/**
	 * 获取Spring的配置文件
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}
	
	/**
	 * 获取SpringMVC的配置文件
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{AppConfig.class};
	}
	/**
	 * 获取DispatcherServlet的映射信息
	 * 
	 *\/:拦截所有请求,包括静态资源,不包括jsp
	 *\/*:拦截所有请求,包括静态资源,包括jsp
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
