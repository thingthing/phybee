package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.Movie;
import service.MovieService;
import service.ReservationService;
import bean.MovieBean;
import bean.UserBean;

/**
 * Created by Elyo on 01/05/2015.
 */

@Controller
public class MovieController {

	@Autowired
	private UserBean user;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private MovieService movieService;
	
    private List<Movie> listMovie = new ArrayList<>();

    @RequestMapping("/movie")
    public ModelAndView nowPlayingMovie (
    		@RequestParam(value = "search", required = false, defaultValue = "") String search) {

    	if (search.isEmpty() == false) {
    		this.listMovie = movieService.getMovieLike(search);
    	}
    	else {
    		this.listMovie = movieService.getCurrentMovies();
    	}
        ModelAndView mv = new ModelAndView("nowPlayingMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/incoming")
    public ModelAndView incomingMovie() {

        this.listMovie = movieService.getFuturMovies();
        
        ModelAndView mv = new ModelAndView("nowPlayingMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("user", user);
        return mv;
    }

    private boolean hasMovieId(ArrayList<MovieBean> listMovie, Movie m)
    {
    	for (MovieBean movie : listMovie)
    	{
    		if (movie.getmId() == m.getId())
    			return true;
    	}
    	return false;
    }
    @RequestMapping("/schedule")
    public ModelAndView scheduleMovie() {
    	ArrayList<MovieBean> listMovieWithSchedule = new ArrayList<MovieBean>();
        List<Movie> currentMovies = movieService.getCurrentMoviesAndSchedule();
        
        for (Movie m : currentMovies)
        {
        	if (this.hasMovieId(listMovieWithSchedule, m) == false)
        		listMovieWithSchedule.add(new MovieBean(m));
        }
        ModelAndView mv = new ModelAndView("scheduleMovie");
        mv.addObject("listmovie", listMovieWithSchedule);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/moviedetails")
    public ModelAndView profilMovie(
            @RequestParam(value = "movie", required = true) Integer movie_id
    ) {
        ModelAndView mv = new ModelAndView("profilMovie");
        MovieBean movie = movieService.getMovieInfo(movie_id);
        mv.addObject("list", movie);
        mv.addObject("schedule", movie.getmDateSchedule());
        mv.addObject("user", user);
        return mv;
    }
}