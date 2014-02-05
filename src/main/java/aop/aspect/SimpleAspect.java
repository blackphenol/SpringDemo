package aop.aspect;

import java.io.IOException;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @editor 
 * @since 2014/1/16
 * 
 */
@Aspect
public class SimpleAspect {
	
	//execution(modifiers-pattern? 
	//	ret-type-pattern declaring-type-pattern? name-pattern(parampattern)
	
	@Before("execution(* ioc.MovieFinder.*(..))")
	public void adviceBefore(JoinPoint joinPoint) {// expression 
		System.out.println("-adviceBefore MovieFinder method:" + joinPoint.getSignature().toShortString());// signature
	}
	
	@Before("execution(* ioc.di.DIMovieLister.moviesDirectedBy(String))")
	public void adviceBefore2(JoinPoint joinPoint) {
		System.out.print("adviceBefore2 method:" + joinPoint.getSignature().toString());
		System.out.println(" record arg="+joinPoint.getArgs()[0]);
	}
	
	@After("execution(* ioc.MovieFinder.*(..))")
	public void adviceAfter(JoinPoint joinPoint) {
		System.out.println("-adviceAfter MovieFinder method:" + joinPoint.getSignature().toShortString());
	}

	@AfterReturning(pointcut="execution(* ioc.MovieFinder.*(..))", returning="retVal")
	public void adviceAfterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println("-adviceAfterReturning MovieFinder method:" + joinPoint.getSignature().toShortString()
				+ ", size=" + ((List) retVal).size());
	}
	
	@AfterThrowing(pointcut="execution(public * *(..))",throwing="e")
	public void adviceAfterThrowing(JoinPoint joinPoint, IOException e) {
		System.out.println("-adviceAfterReturning method:" + joinPoint.getSignature().toShortString());
	}
	
	@Around("execution(* ioc.MovieFinder.*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("---start arount method" + pjp.getSignature().toShortString());
		Object retVal = pjp.proceed();
		System.out.println("---end arount method" + pjp.getSignature().toShortString());
		return retVal;
	}

}
