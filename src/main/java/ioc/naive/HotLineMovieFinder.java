package ioc.naive;

import ioc.Movie;
import ioc.MovieFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @editor 
 * @since 2014/1/15
 * 
 */
public class HotLineMovieFinder implements MovieFinder {
	private List<Movie> movielist;
	
	public HotLineMovieFinder(){
		
	}
	
	public HotLineMovieFinder(String listpath) {
		movielist = new ArrayList<Movie>();
		URL url = this.getClass().getResource("/"+listpath);
		File f = null;
		try {
			f = new File(url.toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(f!=null && f.exists()){
			try {
				Scanner scan = new Scanner(f);
				while(scan.hasNextLine()){
					String line = scan.nextLine();
					if(!"".equals(line)){
						String [] split = line.split(";");
						String name = split[0];
						String director = split[1];
						Movie movie = new Movie(name, director);
						movielist.add(movie);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List findAll(){
		System.out.println("***call findAll***");
		return movielist;
	}
}
