package aop.simpleproxy;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @editor 
 * @since 2014/1/16
 * 
 */
public class MovieCounterAdvice implements MethodBeforeAdvice{
	private int count = 0;
	public void before(Method method, Object[] arg, Object target)
			throws Throwable {
		count++;
		System.out.print("MovieCounterAdvice is executed before "+ method.getName());
		System.out.println(", count: "+count);
	}
	
	public int getCount(){
		return count;
	}

}
