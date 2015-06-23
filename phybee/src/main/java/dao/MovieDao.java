package dao;

import java.util.List;

import javax.persistence.NoResultException;

import entity.Movie;

public interface MovieDao
{
	List<Movie> findAllMovie();
	
	Movie findMovieById(Integer id) throws NoResultException;
	
	List<Movie> findCurrentMoviesAndSchedule();
	
	List<Movie> findCurrentMovies();
	
	List<Movie> findNewMovies();
	
	List<Movie> findFuturMovies();
	
	List<Movie> findMoviesLike(String title);
	
	void create(Movie entity);

	void remove(Movie entity);

	void update(Movie entity);
}
