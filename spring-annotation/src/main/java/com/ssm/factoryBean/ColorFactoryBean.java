package com.ssm.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import com.ssm.bean.Color;
/**
 * 创建一个Spring定义的FactoryBean
 * @author interface
 *
 */
public class ColorFactoryBean implements FactoryBean<Color> {
	/**
	 * 返回一个Color对象,这个对象会添加到容器中
	 */
	@Override
	public Color getObject() throws Exception {
		System.out.println("创建Color");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
