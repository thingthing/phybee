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

    @RequestMapping("/schedule")
    public ModelAndView scheduleMovie() {
        this.listMovie.clear();
        for (int i = 0; i < 10; i++) {
            MovieBean movie = new MovieBean("Title " + Integer.toString(i), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean semper, urna a sollicitudin semper, eros dolor elementum leo, et fringilla nisi enim non velit. Donec a iaculis orci. In vestibulum massa sit amet ante efficitur hendrerit. In consectetur, lacus in condimentum imperdiet, tortor nunc interdum nisi, vel luctus urna orci at mauris. Vestibulum scelerisque quis ipsum quis cursus. Aliquam auctor lacus urna, nec efficitur justo mattis nec. Etiam vestibulum velit erat, sed cursus mi aliquam viverra. Maecenas nisi lacus, tristique sed lectus non, imperdiet bibendum felis. ", null, "http://static.cotecine.fr/tb/Affiches/155x210/FAST+AND+FURIOUS+7.JPG", null);
            this.listMovie.add(movie);
        }

        ModelAndView mv = new ModelAndView("scheduleMovie");
        mv.addObject("listmovie", listMovie);
        return mv;
    }

    @RequestMapping("/movie/movie")
    public ModelAndView profilMovie(
            @RequestParam(value = "slot", required = true) Integer movie_id
    ) {

        ModelAndView mv = new ModelAndView("profilMovie");
        MovieBean movie = MovieService.getMovieInfo(movie_id);
        mv.addObject("list", movie);
        /*mv.addObject("listmovie", title);*/
        return mv;
    }
}