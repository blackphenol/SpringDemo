package aop.simpleproxy;

import java.lang.reflect.Method;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @editor 
 * @since 2014/1/16
 * 
 */
public class AfterMovieFinderAllAdvice implements AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method m, Object[] args,
			Object target) throws Throwable {
		
		System.out.println("afterReturning return val=" + ToStringBuilder.reflectionToString(returnValue));
				
	}
	
}
