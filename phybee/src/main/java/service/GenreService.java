package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.GenreBean;
import db.PhybeeDb;

public class GenreService
{
	public static ArrayList<GenreBean> getAllGenre()
	{
		ArrayList<GenreBean> genreList = new ArrayList<GenreBean>();

		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery("select * from genre");

			while (resultSet.next())
			{
				genreList.add(new GenreBean(resultSet.getInt("id"), resultSet.getString("name")));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return genreList;
	}
	
	public static ArrayList<GenreBean> getGenreOfMovie(Integer movieId)
	{
		ArrayList<GenreBean> genreList = new ArrayList<GenreBean>();

		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery("select g.* from genre as g, moviegenre as m where g.id=m.id_genres and m.id_moviex=?");
			preparedStatement.setInt(1, movieId);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				genreList.add(new GenreBean(resultSet.getInt("g.id"), resultSet.getString("g.name")));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return genreList;
	}
}
