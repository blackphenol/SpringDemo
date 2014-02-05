package aop.simpleproxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @editor 
 * @since 2014/1/16
 * 
 */
public class InterceptorMovieFinderAllAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("invocation Before: invocation=[" + invocation + "]");
		Object rval = invocation.proceed();
		System.out.println("invocation Invocation returned");		
		return rval;
	}

	
}
