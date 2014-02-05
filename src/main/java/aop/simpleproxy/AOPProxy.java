package aop.simpleproxy;

import ioc.MovieFinder;
import ioc.naive.HotLineMovieFinder;
import ioc.naive.MovieLister;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @editor 
 * @since 2014/1/16
 * 
 */
public class AOPProxy {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(new HotLineMovieFinder("movies1.txt"));
		factory.addInterface(MovieFinder.class);
		factory.addAdvice(new MovieCounterAdvice());
		factory.addAdvice(new AfterMovieFinderAllAdvice());
		factory.addAdvice(new InterceptorMovieFinderAllAdvice());
		MovieFinder finder = (MovieFinder) factory.getProxy();
		
		finder.findAll();

	}
}
