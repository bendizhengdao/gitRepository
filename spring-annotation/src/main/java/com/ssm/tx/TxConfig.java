package com.ssm.tx;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 声明式事务
 * @author interface
 * 	1:导入连接池和数据库驱动
 *	2:配置数据源和JdbcTemplate操作数据
 *	3:给方法上标注@Transactional，表示当前方法是一个事务方法 
 *	4:配置类@EnableTransactionManagement 开启基于注解的事务管理功能 
 *	5:配置事务管理器来控制事务
 *
 *	原理:
 *		1:@EnableTransactionManagement
 *			利用TransactionManagementConfigurationSelector给容器中导入组件
 *			导入两个组件
 *				AutoProxyRegistrar
 *				ProxyTransactionManagementConfiguration
 *		
 *		2:AutoProxyRegistrar:
 *			AutoProxyRegistrar.registerBeanDefinitions()
 *				AopConfigUtils.registerAutoProxyCreatorIfNecessary()
 *					给容器中注册InfrastructureAdvisorAutoProxyCreator组件:
 *						InfrastructureAdvisorAutoProxyCreator:
 *							利用后置处理器机制在对象创建以后,包装对象。返回一个代理对象(包含增强器),
 *							代理对象利用拦截器链进行调用
 *
 *		3:ProxyTransactionManagementConfiguration:
 *			1:给容器中注册事务增强器:transactionAdvisor
 *				1:事务增强器要用事务注解的信息.AnnotationTransactionAttributeSource用来解析 事务注解信息
 *				2:事务拦截器:
 *					TransactionInterceptor:它是一个MethodInterceptor
 *							保存事务属性信息(transactionAttributeSource)
 *							事务管理器(txManager)
 *						在目标方法执行的时候:TransactionInterceptor.invoke()
 *							执行拦截器链:
 *							事务拦截器:
 *								1:获取事务相关的属性(TransactionAttribute)
 *								2:获取事务管理器(PlatformTransactionManager)
 *								3:执行目标方法
 *									出现异常,利用事务管理器进行回滚操作
 *									操作正常,利用事务管理器进行提交操作
 *			
 */
@Configuration
@ComponentScan("com.ssm.tx")
@EnableTransactionManagement//开启基于注解的事务管理
public class TxConfig {

	@Bean
	public DataSource dataSource() throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception{
		//Spring对@Configuration类特殊处理,给容器中添加组件的方法,多次调用只是从容器中找组件
		return new JdbcTemplate(dataSource());
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager(DataSource dataSource){ 
		DataSourceTransactionManager ds = new DataSourceTransactionManager(); 
		ds.setDataSource(dataSource); 
		return ds; 
	} 
}
