package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.ScheduleBean;
import db.PhybeeDb;

public class ReservationService
{
	public ReservationService()
	{

	}

	public ArrayList<String> getFilmList()
	{
		ArrayList<String> filmList = new ArrayList<String>();

		try
		{
			String sql = "select title from movie";
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				filmList.add(resultSet.getString("title"));
			}

			db.closeConnection();

		}  catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return filmList;
	}

	private ArrayList<ScheduleBean> getScheduleInfoSql(String sql)
	{
		ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();

		sql = "select s.*, m.title from schedule as s, movie as m where m.id = s.id_movie"
				+ sql;
		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				scheduleList.add(new ScheduleBean(resultSet.getInt("s.id"),
						resultSet.getInt("s.id_movie"), resultSet
								.getInt("s.id_room"), resultSet
								.getString("m.title"), resultSet
								.getTime("s.start"),
						resultSet.getTime("s.end"),
						resultSet.getDate("s.date"), resultSet
								.getInt("s.seat_remain"), resultSet
								.getInt("s.priority_seat_remain")));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (scheduleList);
	}

	public ArrayList<ScheduleBean> getScheduleInfo(Integer id_schedule)
	{
		String sql = " and s.id = '" + id_schedule + "'";

		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<ScheduleBean> getScheduleInfo(String film, Date date)
	{
		String sql = " and m.title LIKE '%" + film + "%' and s.date = " + date;
		return (this.getScheduleInfoSql(sql));
	}
	
	public ArrayList<ScheduleBean> getScheduleInfo(String film)
	{
		String sql = " and m.title LIKE '%" + film + "%'";
		return (this.getScheduleInfoSql(sql));
	}
	
	public ArrayList<ScheduleBean> getScheduleInfo(Date date)
	{
		String sql = " and s.date = " + date;
		return (this.getScheduleInfoSql(sql));
	}
}
