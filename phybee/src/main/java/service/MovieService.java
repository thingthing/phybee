package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import db.PhybeeDb;
import bean.MovieBean;

public class MovieService
{

	public MovieService()
	{
		
	}
	
	private ArrayList<MovieBean> searchMovieDb(String sql)
	{
		ArrayList<MovieBean> movieList = new ArrayList<MovieBean>();
		
		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				movieList.add(new MovieBean(
						resultSet.getInt("id"),
						resultSet.getInt("id_producer"),
						resultSet.getString("title"),
						resultSet.getString("synopsis"),
						resultSet.getTimestamp("time"),
						resultSet.getString("poster"),
						resultSet.getDate("release")
						));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return movieList;
	}
	
	public ArrayList<MovieBean> getCurrentMovies()
	{
		//@TODO: Add date when movie is not in theater
		String sql = "select * from schedule movie where release >= CURDATE()";
		
		return this.searchMovieDb(sql);
	}
	
	public ArrayList<MovieBean> getMovieInfo(Integer movie_id)
	{
		String sql = "select * from schedule movie where id = " + movie_id;
		return this.searchMovieDb(sql);
	}
}
