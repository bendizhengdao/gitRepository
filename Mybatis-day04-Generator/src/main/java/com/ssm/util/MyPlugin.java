package com.ssm.util;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
@Intercepts(value={
		@Signature(type=StatementHandler.class,method="query",args=java.sql.Statement.class)
})
public class MyPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();
		//拿到target中的元数据
		MetaObject metaObject = SystemMetaObject.forObject(target);
		
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		
		System.out.println("sql语句的参数是: "+value);
		metaObject.setValue("parameterHandler.parameterObject", "11");
		Object proceed = invocation.proceed();
		return proceed;
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
}
