package ioc.naive;

import ioc.Movie;
import ioc.MovieFinder;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @editor 
 * @since 2014/1/15
 * 
 */
public class MovieLister {
	private MovieFinder finder;
	public MovieLister() {
		 finder = new HotLineMovieFinder("movies1.txt");
	}
	
	public Movie[] moviesDirectedBy(String arg) {
        List<Movie> allMovies = finder.findAll();
        for (Iterator<Movie> it = allMovies.iterator(); it.hasNext();) {
            Movie movie = it.next();
            if (!movie.getDirector().equals(arg)) it.remove();
        }
        return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
    }

	public static void main(String[] args) {
		MovieLister movieLister= new MovieLister();
		
		Movie[] movies = movieLister.moviesDirectedBy("班史提勒");
		
		if(movies!=null){
			for(Movie movie: movies){
				System.out.println(ToStringBuilder.reflectionToString(movie, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}
		
	}
}
