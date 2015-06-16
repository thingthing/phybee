package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MovieService;
import service.ReservationService;
import bean.DateScheduleBean;
import bean.MovieBean;
import bean.UserBean;

/**
 * Created by Elyo on 01/05/2015.
 */

@Controller
public class MovieController {

	@Autowired
	private UserBean user;
	
    private List<MovieBean> listMovie = new ArrayList<>();

    @RequestMapping("/movie")
    public ModelAndView nowPlayingMovie (
    		@RequestParam(value = "search", required = false, defaultValue = "") String search) {

    	if (search != null) {
    		this.listMovie = MovieService.getMovieLike(search);
    	}
    	else {
    		this.listMovie = MovieService.getCurrentMovies();
    	}
        ModelAndView mv = new ModelAndView("nowPlayingMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/incoming")
    public ModelAndView incomingMovie() {

    	ReservationService res = new ReservationService();

        this.listMovie = MovieService.getFuturMovies();
        
        for (MovieBean m : listMovie) {
        	m.setmDateSchedule(res.getScheduleInfoWithFilmId(m.getmId()));
        }
        ModelAndView mv = new ModelAndView("incomingMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/schedule")
    public ModelAndView scheduleMovie() {

    	ReservationService res = new ReservationService();

        this.listMovie = MovieService.getCurrentMovies();
        
        for (MovieBean m : listMovie) {
        	m.setmDateSchedule(res.getScheduleInfoWithFilmId(m.getmId()));
        }
        
        ModelAndView mv = new ModelAndView("scheduleMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/moviedetails")
    public ModelAndView profilMovie(
            @RequestParam(value = "movie", required = true) Integer movie_id
    ) {

    	ReservationService res = new ReservationService();
    	ArrayList<DateScheduleBean> schedule = null;

    	schedule = res.getScheduleInfoWithFilmId(movie_id);
        ModelAndView mv = new ModelAndView("profilMovie");
        MovieBean movie = MovieService.getMovieInfo(movie_id);
        mv.addObject("list", movie);
        mv.addObject("schedule", schedule);
        mv.addObject("user", user);
        /*mv.addObject("listmovie", title);*/
        return mv;
    }
}