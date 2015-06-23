package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.MovieBean;
import dao.MovieDao;
import entity.Movie;
@Transactional
@Service
public class MovieService
{
	@Autowired
	private MovieDao movieDao;
	
	public MovieService()
	{

	}

	public List<Movie> getMovieLike(String title)
	{
		return this.movieDao.findMoviesLike(title);
	}
	
	public List<Movie> getFuturMovies()
	{
		return this.movieDao.findFuturMovies();
	}

	public List<MovieBean> getNewMovies()
	{
		List<Movie> movies = this.movieDao.findNewMovies();
		ArrayList<MovieBean> movieList = new ArrayList<MovieBean>();
		
		for (Movie movie : movies)
		{
			movieList.add(new MovieBean(movie));
		}
		return movieList;
	}

	public List<Movie> getCurrentMoviesAndSchedule()
	{
		return this.movieDao.findCurrentMoviesAndSchedule();
	}

	public List<Movie> getCurrentMovies()
	{
		return this.movieDao.findCurrentMovies();
	}
	
	public MovieBean getMovieInfo(Integer movie_id)
	{
		return new MovieBean(this.movieDao.findMovieById(movie_id));
	}
}
