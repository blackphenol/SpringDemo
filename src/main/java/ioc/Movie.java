package ioc;

/**
 *
 * @editor 
 * @since 2014/1/15
 * 
 */
public class Movie {
	private String name;
	private String director;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String name, String director) {
		super();
		this.name = name;
		this.director = director;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
