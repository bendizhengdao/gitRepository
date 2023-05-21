package com.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 自动装配:
 * 	Spring 利用DI,完成对IOC容器中各个组件的依赖关系赋值
 * 
 * 	@Autowired:自动注入
 * 		默认方式:byType,再将属性的名称作为组件的id去容器中查找
 * 
 * 			@Autowired
			private BookDao bookDao1;
			
			
 * 			@Autowired
			private BookDao bookDao2;
 * 
 * 		@Service
		public class BookService {
			@Autowired
			@Qualifier("bookDao2")
			private BookDao bookDao;
		}
	@Primary:让Spring进行自动装配时候,默认使用首选的Bean	
	
		@Primary
		@Bean("bookDao2")
		public BookDao bookDao(){
			return new BookDao();
		}
		
	Spring支持 @Resource和@Inject
		@Resouce:
			默认方式:byName
			@Service
			public class BookService {
				@Resource
				private BookDao bookDao;
			}
			
		@Inject:
			需要导入 javax.inject的包,功能和@Autowired一样
	
	AutowiredAnnotationBeanPostProcessor:解析完成自动装配的功能
		
	@Autowired:构造器,参数,方法,属性:都是从容器中获取参数组件的值
		
		@Component
		public class Boss {
			
			@Autowired
			private Car car;
		
			public Car getCar() {
				return car;
			}
			
			@Autowired
			public Boss(Car car) {
				this.car = car;
			}
			
			public Boss(@Autowired Car car) {
				this.car = car;
			}
			
			@Autowired
			public void setCar(Car car) {
				this.car = car;
			}
		}
		
		/**
		 * @Bean标注的方法创建对象的时候,方法参数的值从容器中获取
		 * @param car
		 * @return
		 *
		@Bean
		public Color color(Car car){
			return new Color();
		}
		
 * @author interface
 *
 */
import org.springframework.context.annotation.Primary;

import com.ssm.bean.Car;
import com.ssm.bean.Color;
import com.ssm.dao.BookDao;
@Configuration
@ComponentScan(value={"com.ssm.controller","com.ssm.service","com.ssm.dao","com.ssm.bean"})
public class MainConfigOfAutowired {
	
	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		return new BookDao();
	}
	
	/**
	 * @Bean标注的方法创建对象的时候,方法参数的值从容器中获取
	 * @param car
	 * @return
	 */
	@Bean
	public Color color(Car car){
		return new Color();
	}
}
