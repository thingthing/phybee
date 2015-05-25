package controller;

import bean.MovieBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MovieService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elyo on 01/05/2015.
 */

@Controller
public class MovieController {

    private List<MovieBean> listMovie = new ArrayList<>();

    @RequestMapping("/movie")
    public ModelAndView nowPlayingMovie () {

    	this.listMovie = MovieService.getCurrentMovies();
        ModelAndView mv = new ModelAndView("nowPlayingMovie");
        mv.addObject("listmovie", listMovie);
        mv.addObject("timem", listMovie.get(0).getmTime().getTime());
        return mv;
    }

    @RequestMapping("/incoming")
    public ModelAndView incomingMovie() {

        this.listMovie = MovieService.getFuturMovies();
        ModelAndView mv = new ModelAndView("scheduleMovie");
        mv.addObject("listmovie", listMovie);
        return mv;
    }

    @RequestMapping("/schedule")
    public ModelAndView scheduleMovie() {

        this.listMovie = MovieService.getCurrentMovies();
        ModelAndView mv = new ModelAndView("scheduleMovie");
        mv.addObject("listmovie", listMovie);
        return mv;
    }

    @RequestMapping("/moviedetails")
    public ModelAndView profilMovie(
            @RequestParam(value = "movie", required = true) Integer movie_id
    ) {

        ModelAndView mv = new ModelAndView("profilMovie");
        MovieBean movie = MovieService.getMovieInfo(movie_id);
        mv.addObject("list", movie);
        /*mv.addObject("listmovie", title);*/
        return mv;
    }
}