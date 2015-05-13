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
	
	private static ArrayList<MovieBean> searchMovieDb(String sql)
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
						resultSet.getInt("id_genre"),
						resultSet.getInt("id_producer"),
						resultSet.getString("title"),
						resultSet.getString("synopsis"),
						resultSet.getTimestamp("time"),
						resultSet.getString("poster"),
						resultSet.getDate("release"),
						resultSet.getDate("end_release")
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
	
	public static ArrayList<MovieBean> getNewMovies()
	{
		String sql = "select * from movie where `release` <= CURDATE() &&"
				+ " end_release > CURDATE() &&"
				+ " CURDATE() <= DATE_ADD(release,INTERVAL 7 DAY)";
		return MovieService.searchMovieDb(sql);
	}
	
	public static ArrayList<MovieBean> getCurrentMovies()
	{
		String sql = "select * from movie where `release` <= CURDATE() &&"
				+ " end_release > CURDATE()";
		return MovieService.searchMovieDb(sql);
	}
	
	public static MovieBean getMovieInfo(Integer movie_id)
	{
		String sql = "select * from movie where id = " + movie_id;
		return MovieService.searchMovieDb(sql).get(0);
	}
}
