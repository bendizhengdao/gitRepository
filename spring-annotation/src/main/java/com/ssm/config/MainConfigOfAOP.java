package com.ssm.config;

/**
 * AOP:动态代理
 * 	在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 * 		(1):导入jar
 * 			spring-aspects
 * 		(2):定义一个日志切面类(LogAspects)
 * 				@Aspect
				@Component
 * 			通知方法:
 * 				前置通知@Before:
 * 					在目标方法运行之前执行
 * 				后置通知@After:
 * 					在目标方法运行之后执行
 * 				返回通知@AfterReturning:
 * 					在目标方法正常返回之后运行
 * 				异常通知@AfterThrowing:
 * 					在目标方法出现异常之后运行
 * 				环绕通知@Around:
 * 					joinPoint.proceed()
 * 				切入点@Pointcut:
 * 						@Pointcut("@annotation(com.ssm.annotation.LogAnnotation)")
						@Pointcut("execution(public * com.only.mate.springboot.controller.*.*(..))")

 * 		(3)开启基于注解的AOP模式：
 * 				@EnableAspectJAutoProxy
 * 
 * 		AOP原理【注册什么组件,这个组件有什么样的功能】:
 * 			@EnableAspectJAutoProxy
 * 		
 * 		@EnableAspectJAutoProxy
 * 				@Import(AspectJAutoProxyRegistrar.class)导入AspectJAutoProxyRegistrar对象
 * 					利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 * 					internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator(BeanDefinetion)
 * 				给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 * 			
 * 		AutowiredAnnotationBeanPostProcessor:处理自动注入
 * 
 * 		AnnotationAwareAspectJAutoProxyCreator:
 * 			AspectJAwareAdvisorAutoProxyCreator:
 * 				AbstractAdvisorAutoProxyCreator:
 * 					AbstractAutoProxyCreator:
 * 						实现了
 * 							BeanFactoryAware:自动装配BeanFactory,在bean初始化完成前后做事情(后置处理器)
 * 							SmartInstantiationAwareBeanPostProcessor:
 * 								InstantiationAwareBeanPostProcessor:实例化BeanPostProcessor
 * 									postProcessBeforeInstantiation()
									postProcessAfterInstantiation()
 * 								BeanPostProcessor:初始化BeanPostProcessor
 * 									postProcessBeforeInitialization()
									postProcessAfterInitialization()
 * 
 * 	注册AnnotationAwareAspectJAutoProxyCreator:
 * 		流程:
 * 
 * 			1. 传入配置类，创建ioc容器
 * 
			2. 注册配置类，调用refresh()刷新容器。以下为refresh()方法内部的执行逻辑：
			
			3. AbstractApplicationContext.registerBeanPostProcessor(beanFactory);注册bean的后置处理器,拦截Bean的创建
			
				  1. 先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
				  
				  2. 给容器中加别的BeanPostProcessor
				  
				  3. 优先注册实现了PriorityOrdered接口的BeanProcessor
				  
				  4. 再给容器中注册实现了Ordered接口的BeanPostProcessor
				  
				  5. 注册没实现优先级接口的BeanPostProcessor
				  
				  6. 注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中(实现Ordered接口)
						例如：创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectAutoProxyCreator】
							AbstractBeanFactory::getBean()
							AbstractBeanFactory::doGetBean()
							DefaultSingletonBeanRegistry::getSingleton()获取BeanPostProcessor
							AbstractAutowireCapableBeanFactory::createBean()
							AbstractAutowireCapableBeanFactory::doCreateBean()创建BeanPostProcessor
								    ⅰ. 创建bean的实例
								    ⅱ. populateBean()给bean的各种属性赋值
								    ⅲ. initializeBean()初始化bean
									      1. invokeAwareMethods()：处理Aware接口的方法回调
									      2. applyBeanPostProcessorsBeforeInitialization()：应用后置处理器的beforeInitialization方法
									      3. invokeInitMethods()：执行@Bean注解等自定义的Bean初始化方法
									      4. applyBeanPostProcessorsAfterInitialization()：执行后置处理器的afterInitialization方法
								    ⅳ. BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功；----> aspectJAdvisorsBuilder
					    
			  	  7. 把BeanPostProcessor存储到BeanFactory中
						beanFactoy.addBeanPostProcessor(postProcessor)
						
						
=============================以上是创建	和注册AnnotationAwareAspectJAutoProxyCreator的过程====================	

	AnnotationAwareAspectJAutoProxyCreator会在所有bean创建之前进行一次拦截，调用实现的InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation()方法。


			4. AbstractApplicationContext.finishBeanFactoryInitialization(beanFactory)完成bean初始化工作，创建剩下的单实例bean
					此时创建的bean，是那些不属于后置处理器的普通单实例bean。后置处理器本身也是bean，后置处理器的bean在第3.6步进行创建
					
					  a. 遍历获取容器中所有的bean，依次创建对象：getBean(beanName)
					  
								AbstractBeanFactory.getBean() 
								-> AbstractBeanFactory.doGetBean()
								 -> DefaultSingletonBeanRegistry.getSingleton()
								 	->AbstractAutowireCapableBeanFactory.createBean()
								
					  b. 创建bean:
					  
					  		1):先从缓存中获取当前bean，如果能获取到,说明bean是之前被创建过的,直接使用,否则再创建
					  			只要创建好的bean都会被缓存起来
					  		
					  		2):createBean()创建bean: [	即AnnotationAwareAspectJAutoProxyCreator实现的InstantiationAwareBeanPostProcessor的方法，会在任何bean创建之前先尝试返回bean的实例。]
					    		
					    			[ InstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation和postProcessAfterInstantiation是在创建Bean实例之前先尝试用后置处理器返回对象。]
					    			
									[ BeanPostProcessor的postProcessBeforeInitialization和postProcessAfterInitialization是在Bean对象创建完成初始化前后调用的； ]

						      		1. AbstractAutowireCapableBeanFactory.resolveBeforeInstantiation(beanName, mdbToUse)解析beforeInstantiation。
						      		
											希望后置处理器能在此返回一个代理对象，如果能返回代理对象就使用，如果不能就继续第2步。
											
						        		1. 后置处理器先尝试返回对象
						        		
					        				// 拿到所有BeanPostProcessor后置处理器，如果该后置处理器属于InstantiationAwareBeanPostProcessor，则执行该后置处理器的postProcessBeforeInstantiation方法。
											// （注意postProcessBeforeInstantiation方法 不同于 postProcessBeforeInitialization方法）
											bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
											
											if (bean != null) {
											    bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
											}
											
								   2. AbstractAutowireCapableBeanFactory.doCreateBean(beanName, mbdToUse, args) ，真正的去创建一个bean实例 ，和第3.6环节中的操作流程一样
						
=================================以下为 AnnotationAwareAspectJAutoProxyCreator 做的事情=======================

	AnnotationAwareAspectJAutoProxyCreator的父类AbstractAutoProxyCreator，实现了InstantiationAwareBeanPostProcessor接口，它的作用是：
			
			1. 每一个bean创建之前，调用AbstractAutoProxyCreator.postProcessBeforeInstantiation()；
			
				  a. 判断当前bean是否在advisedBeans中（advisedBeans保存了所有需要增强的bean）
				  
				  b. 调用isInfrastructureClass()判断当前Bean是否是基础类型。
				  
				   			aop相关基础设施类型的bean不应该被动态代理。
				   				boolean retVal = Advice.class.isAssignableFrom(beanClass) ||
								Pointcut.class.isAssignableFrom(beanClass) ||
								Advisor.class.isAssignableFrom(beanClass) ||
								AopInfrastructureBean.class.isAssignableFrom(beanClass);
								
				        	切面的bean不应该被动态代理：带有@Aspect注解的bean。
				        	
				    c. 调用shouldSkip()判断当前bean是否需要跳过
				    
						 1. 调用findCandidateAdvisors()获取候选的增强器List<Advisor> candidateAdvisors (切面里面的通知方法)
						    
							每一个封装的通知方法增强器类型为：InstantiationModelAwarePointcutAdvisorImpl
						
						 2. 判断增强器是否为AspectJPointcutAdvisor类型的，如果是，则判断该增强器的aspectName是否和beanName相同
						    
									
			2. 创建好bean对象后，调用AbstractAutoProxyCreator.postProcessAfterInitialization()
			
						调用AbstractAutoProxyCreator.wrapIfNecessary()方法，如果需要的话对bean进行包装。
						
						  1. 同AbstractAutoProxyCreator.postProcessBeforeInstantiation()一样进行一些校验：
						  
						    	   当前bean是否在advisedBeans中
						    	   当前bean是否是基础类型
						    	   当前bean是否需要跳过
						    	
						  2. 调用AbstractAdvisorAutoProxyCreator.getAdvicesAndAdvisorsForBean()
						  		获取当前bean的所有增强器（通知方法）：Object[] specificInterceptors
						  		
								    ⅰ. 找到候选的所有增强器
								    ⅱ. 找到能在当前bean中使用的增强器
								    ⅲ. 给增强器排序
								    
						  3. 将bean保存到advisedBeans中，表示当前bean已经被增强处理了
						  
						  4. 如果当前Bean需要增强，创建当前bean的代理对象；AbstractAdvisorAutoProxyCreator.createProxy()
								    ⅰ. 获取所有增强器（通知方法）
								    ⅱ. 保存到proxyFactory中
								    ⅲ. 创建代理对象
								    
								Spring在DefaultAopProxyFactory::createAopProxy()中自动决定使用哪种方式创建代理对象：
								      ● JdkDynamicAopProxy
								      ● ObjenesisCglibAopProxy
								      
						5. 给容器中返回cglib增强了的代理对象
						
						6. 以后容器中获取到的就是这个组件的代理对象，执行目标方法时，代理对象就会执行通知方法的流程。
				
				        	
		   3. AbstractAutoProxyCreator.postProcessAfterInstantiation()
						 		直接返回true
			
		   4. AbstractAutoProxyCreator.postProcessBeforeInitialization()
		 		直接返回传入的bean对象
		        	
	MethodInterceptor方法拦截器链	
			        	
		5:目标方法执行：CglibAopProxy.DynamicAdvisedInterceptor.intercept()

			容器中保存了组件的代理对象（Cglib增强后的对象），这个对象里面保存了详细信息（增强器、目标对象等）。
			
			1. 进入CglibAopProxy.intercept()方法，拦截目标方法的执行
			
			2. 根据ProxyFactory类型的advised对象，获取到将要执行的目标方法的拦截器链
			  
				拦截器链：每一个通知方法被包装成MethodInterceptor方法拦截器，后续利用MethodInterceptor机制执行
					  
			   List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
			   
			   List<Object> interceptorList保存所有拦截器
			   		
			   		List<Object> interceptorList的长度:
						一个默认的ExposeInvocationInterceptor + 自定义的增强通知方法
					
					遍历所有的增强器，将其转换为Interceptor：
						registry.getInterceptors(advisor);
					
					将Advisor转换为MethodInterceptor（MethodInterceptor继承于Interceptor）：
					
						判断如果Advisor属于MethodInterceptor类型，则直接加入interceptors数组；
					
						通过遍历AdvisorAdapter适配器（前置通知适配器、返回结果通知适配器、异常通知适配器），
						尝试将Advisor转换为MethodInterceptor,加入interceptors数组

						@AfterThrowing注解的增强器转换为AspectJAfterThrowingAdvice
						@AfterReturning注解的增强器转换为AfterReturningAdviceInterceptor
						@After注解的增强器转换为AspectJAfterAdvice
						@Before注解的增强器转换为MethodBeforeAdviceInterceptor
				
			3.如果没有拦截器链，直接执行目标方法
					
			4.如果有拦截器链，把需要执行的目标对象、目标方法、拦截器链等信息传入: CglibAopProxy.DynamicAdvisedInterceptor.intercept()
				创建一个CglibMethodInvocation对象，并调用该对象的proceed()方法。
					
				Object retVal = new CglibMethodInvocation(proxy, target, method, args, targetClass, chain, methodProxy).proceed();
				
				拦截器链的调用过程：proceed()的执行过程。
				   CglibMethodInvocation继承于ReflectiveMethodInvocation，实际执行的是ReflectiveMethodInvocation::proceed()

					1. 如果没有拦截器执行目标方法，或者拦截器的索引和（拦截器数组-1）大小一样（即到了最后一个拦截器），执行目标方法。
						因为拦截器的链式执行是类似入栈操作，是后入先出，所以拦截器链数组中的拦截器顺序与执行顺序相反
					
					2. 否则获取到拦截器链中（当前索引 += 1）的拦截器，执行其invoke()方法
					
					3. 拦截器的invoke()方法，会在进行一定操作后，递归链式调用ReflectiveMethodInvocation.proceed()方法。
						例如@Before增强器对应的MethodBeforeAdviceInterceptor拦截器，其invoke()方法为：
						@AfterReturning增强器对应的AfterReturningAdviceInterceptor拦截器，其invoke()方法为：
				   
					   		@Override
							public Object invoke(MethodInvocation mi) throws Throwable {
							    this.advice.before(mi.getMethod(), mi.getArguments(), mi.getThis() );
							    return mi.proceed();  // 链式调用，继续进行后面的链的执行
							}
				   
					   		@Override
							public Object invoke(MethodInvocation mi) throws Throwable {
							    Object retVal = mi.proceed(); // 链式调用，继续进行后面的链的执行
							    this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
							    return retVal;
							}
				   			        		
 * 
 * 总结:
 * 		1:@EnableAspectJAutoProxy开启AOP切面功能
 * 			注册AnnotationAwareAspectJAutoProxyCreator
 * 			容器的创建流程:
 * 				1:AbstractApplicationContext.registerBeanPostProcessor()注册后置处理器,创建AnnotationAwareAspectJAutoProxyCreator
 * 				2:AbstractApplicationContext.finishBeanFactoryInitialization()初始化剩下的单实例bean
 * 					1:创建业务逻辑组件和切面组件
 * 					2:AnnotationAwareAspectJAutoProxyCreator拦截组件的创建过程
 * 					3:组件创建完成后,判断是否需要进行增强
 * 						是,切面的通知方法,包装成增强器(Advisor);给业务逻辑组件创建一个代理对象
 * 			执行目标方法:
 * 				1:代理对象执行目标方法
 * 				2:CglibAopProxy.DynamicAdvisedInterceptor.intercept()进行拦截
 * 					1：得到目标方法的拦截器链(增强器包装成拦截器MethodInterceptor)
 * 					2:利用拦截器的链式机制,依次进入每一个拦截器进行执行
 * 
 * @author interface
 *
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ssm.aop.MathCalculator;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ssm.aop")//扫描annotation
public class MainConfigOfAOP {
	
	@Bean
	public MathCalculator mathCalculator(){
		return new MathCalculator();
	}
}
