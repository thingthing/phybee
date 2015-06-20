package dao;

import java.util.ArrayList;
import java.util.List;

import bean.UserMovies;
import entity.Movie;

public interface MovieDao
{
	List<Movie> findAllMovie();

	ArrayList<UserMovies> getUserMovies(Integer user_id);
	
	void create(Movie entity);

	void remove(Movie entity);

	void update(Movie entity);
}
