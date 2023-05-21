package com.ssm.config;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * bean的生命周期
 * 	bean创建---初始化---销毁
 * 	现在容器管理bean的生命周期
 * 	可以自定义初始化和销毁方法
 * 	
 * 		构造对象(bean创建)	
 * 			单实例:在容器启动时创建对象
 * 			多实例:在每次获取的时候创建对象
 * 		
 * 		初始化:
 *			对象创建完成,并赋值后,调用初始化方法
 *
 * 		销毁:
 * 			单实例:容器关闭的时候
 * 			多实例:容器不会管理这个Bean,容器不会调用销毁方法
 * 
 * 
 * 	(1):指定初始化和销毁方法
 * 		通过@Bean注解指定init-method="" destroy-method=""
 * 	
 * 	(2):通过让Bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
 * 
 * 	(3):JSR250
 * 		@PostConstruct:在bean创建完成并且属性赋值完成,来执行初始化
 * 		@PreDestory:在容器销毁bean之前通知我们进行清理工作
 * 
 * 	(4)BeanPostProcessor:bean的后置处理器
 * 		在bean初始化前后进行一些处理工作
 * 			postProcessBeforeInitialization:在初始化之前做后置处理工作
 * 			postProcessAfterInitialization:在初始化之后做后置处理工作
 * 
 * 	(5):Spring对BeanPostProcessor的使用
 * 		ApplicationContextAware:获取ApplicationContext
 * 		EmbeddedValueResolverAware:解析配置文件内容
 * 			@Override
			public void setEmbeddedValueResolver(StringValueResolver resolver) {
				this.resolver = resolver;
				resolver.resolveStringValue("${String.value}"); //解析配置文件内容
			}
 * 		@Autowired/@Async
 * @author interface
 *
 */
import org.springframework.util.StringValueResolver;

import com.ssm.bean.Car;
@Configuration
@ComponentScan({"com.ssm.bean","com.ssm.condition"})
public class MainConfigOfLifeCycle implements EmbeddedValueResolverAware{
	
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car(){
		return new Car();
	}
	
	private StringValueResolver resolver;

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
		resolver.resolveStringValue("${String.value}"); //解析配置文件内容
	}
	
}
