package ioc.locator;

import ioc.Movie;
import ioc.MovieFinder;
import ioc.naive.HotLineMovieFinder;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @editor 
 * @since 2014/1/15
 * 
 */
public class LocatorMovieLister{
	private LocatorHotLineMovieFinder finder;
	
	public LocatorMovieLister() {
		 finder = ServiceLocator.movieFinder();
	}
	
	public Movie[] moviesDirectedBy(String arg) {
        List<Movie> allMovies = finder.findAll();
        for (Iterator<Movie> it = allMovies.iterator(); it.hasNext();) {
            Movie movie = it.next();
            if (!movie.getDirector().equals(arg)) it.remove();
        }
        return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
    }
}
