package com.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.ssm.bean.Color;
import com.ssm.bean.Person;
import com.ssm.bean.Red;
import com.ssm.condition.BillGatesCondition;
import com.ssm.condition.LinusCondition;
import com.ssm.condition.MyImportBeanDefinitionRegistrar;
import com.ssm.condition.MyImportSelector;
//满足当前条件,这个类中配置的所有bean注册才会生效
import com.ssm.factoryBean.ColorFactoryBean;
@Conditional({BillGatesCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//导入组件,id默认是组件的全类名 com.ssm.bean.Color
public class MainConfig2 {
	/***
	 * prototype:获取对象时,容器才开始创建对象
	 * singleton:容器启动时,创建对象
	 * request:同一次请求创建一个实例
	 * session:同一个session创建一个实例
	 * 
	 * 懒加载:
	 * 	singleton:获取对象时,容器才开始创建对象,并初始化
	 * 
	 * 
	 * @return
	 */
	@Bean
	@Scope("singleton")
	@Lazy //懒加载
	public Person person(){
		System.out.println("开始创建person对象");
		return new Person("王五", 13);
	}
	
	/**
	 * Conditional: 按照一定的条件进行判断,满足条件给容器中注册Bean
	 * @return
	 */
	@Bean
	@Conditional(value={LinusCondition.class})
	public Person Linus(){
		return new Person("Linus", 50);
	}
	
	@Bean
	@Conditional(value={BillGatesCondition.class})
	public Person BillGates(){
		return new Person("Bill Gates",60);
	}
	/**
	 * 给容器中注册组件
	 * (1):包扫描+组件注解(@Controller/@Service/@Repository/@Component)
	 * (2):@Bean
	 * (3):@Import:
	 * 		@Import(导入组件):容器中会自动注册这个组件,id默认是组件的全类名
	 * 		@ImportSelector:返回需要导入的组件的全类名数组
	 * 		ImportBeanDefinitionRegistrar:手动注册Bean到容器中
	 * (4):使用Spring提供的FactoryBean:
	 * 		默认获取到的是工厂Bean调用getObject创建的对象
	 * 		要获取工厂Bean本身,我们需要给id前面加一个&
	 */		
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
}
