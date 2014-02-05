package ioc.locator;

import ioc.Movie;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 *
 * @author Walter
 * @editor 
 * @since 2014/1/15
 * 
 */
public class ServiceLocator {
	private static ServiceLocator soleInstance;
	private LocatorHotLineMovieFinder movieFinder;
	
	public ServiceLocator(LocatorHotLineMovieFinder movieFinder) {
	       this.movieFinder = movieFinder;
	}
	 
	public static LocatorHotLineMovieFinder movieFinder() {
        return soleInstance.movieFinder;
    }
	
	public static void load(ServiceLocator arg) {
        soleInstance = arg;
    }
    
	
	public static void main(String[] args) {
		//register ServiceLocator
		ServiceLocator.load(new ServiceLocator(new LocatorHotLineMovieFinder("movies1.txt")));
		
		LocatorMovieLister movieLister = new LocatorMovieLister();
	    
	    Movie[] movies = movieLister.moviesDirectedBy("班史提勒");
		
		if(movies!=null){
			for(Movie movie: movies){
				System.out.println(ToStringBuilder.reflectionToString(movie, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}
	}
}
