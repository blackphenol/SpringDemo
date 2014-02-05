package ioc.di;

import ioc.Movie;
import ioc.MovieFinder;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @editor 
 * @since 2014/1/15
 * 
 */
public class DIMovieLister {
	private MovieFinder finder;
	
	public DIMovieLister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DIMovieLister(MovieFinder finder) {
		this.finder = finder;
	}
	
	public Movie[] moviesDirectedBy(String arg) {
        List<Movie> allMovies = finder.findAll();
        for (Iterator<Movie> it = allMovies.iterator(); it.hasNext();) {
            Movie movie = it.next();
            if (!movie.getDirector().equals(arg)) it.remove();
        }
        return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
    }
	
	public void listerThrowException() throws IOException {
		System.out.println("listerThrowException() is running ");
		throw new IOException("Generic Error");
	}

	public MovieFinder getFinder() {
		return finder;
	}

	public void setFinder(MovieFinder finder) {
		this.finder = finder;
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("ioc/appContext.xml");
		//diMovieListerType2, diMovieListerType3,
		DIMovieLister movieLister = container.getBean("diMovieListerType2", DIMovieLister.class);
		
		Movie[] movies = movieLister.moviesDirectedBy("班史提勒");
		
		if(movies!=null){
			for(Movie movie: movies){
				System.out.println("retrieval:" + ToStringBuilder.reflectionToString(movie, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}
		
		try{
			movieLister.listerThrowException();
		}catch(Exception e){
			
		}
	}
}
