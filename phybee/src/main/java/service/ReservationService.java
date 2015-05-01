package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.PhybeeDb;

public class ReservationService
{
	public ReservationService()
	{

	}

	public ArrayList<String> getFilmList()
	{
		String sql = "select title from movie";
		ArrayList<String> filmList = new ArrayList<String>();

		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				filmList.add(resultSet.getString("title"));
			}

			db.closeConnection();

		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
		return filmList;
	}
}
