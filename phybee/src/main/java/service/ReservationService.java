package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.DateScheduleBean;
import bean.ScheduleBean;
import bean.TicketBean;
import db.PhybeeDb;

public class ReservationService
{
	public ReservationService()
	{

	}

	public void removeAvailableSeat(Integer id_schedule, Integer seats_taken,
			Boolean is_priority)
	{
		try
		{
			PhybeeDb db = new PhybeeDb();
			String column_name = (is_priority ? "priority_" : "")
					+ "seat_remain";
			PreparedStatement preparedStatement = db
					.prepareQuery("update schedule set " + column_name + " = ("
							+ column_name + " - ?) where id=?");

			preparedStatement.setInt(1, seats_taken);
			preparedStatement.setInt(2, id_schedule);

			preparedStatement.executeUpdate();

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
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

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return filmList;
	}

	public ArrayList<TicketBean> getTicketInfo()
	{

		ArrayList<TicketBean> ticketList = new ArrayList<TicketBean>();

		try
		{
			String sql = "select * from ticket";
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				ticketList.add(new TicketBean(resultSet.getInt("id"), resultSet
						.getString("type"), resultSet.getDouble("price")));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return ticketList;
	}

	private ArrayList<DateScheduleBean> getScheduleInfoSql(String sql)
	{
		ArrayList<DateScheduleBean> datescheduleList = new ArrayList<DateScheduleBean>();
		sql = "select s.*, m.title from schedule as s, movie as m where m.id = s.id_movie"
				+ sql + " order by s.date";
		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);
			DateScheduleBean dateschedule = null;
			while (resultSet.next())
			{
				Date date = resultSet.getDate("s.date");
				if (dateschedule == null
						|| date.equals(dateschedule.getDate()) == false)
				{
					if (dateschedule != null)
						datescheduleList.add(dateschedule);
					dateschedule = new DateScheduleBean(date,
							new ArrayList<ScheduleBean>());
				}
				dateschedule.addSchedule(new ScheduleBean(resultSet
						.getInt("s.id"), resultSet.getInt("s.id_movie"),
						resultSet.getInt("s.id_room"), resultSet
								.getString("m.title"), resultSet
								.getTime("s.start"),
						resultSet.getTime("s.end"),
						resultSet.getDate("s.date"), resultSet
								.getInt("s.seat_remain"), resultSet
								.getInt("s.priority_seat_remain")));
			}
			if (dateschedule != null)
				datescheduleList.add(dateschedule);
			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (datescheduleList);
	}

	public ArrayList<DateScheduleBean> getScheduleInfo(Integer id_schedule)
	{
		String sql = " and s.id = '" + id_schedule + "'";

		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<DateScheduleBean> getScheduleInfo(String film, Date date)
	{
		String sql = " and m.title LIKE '%" + film + "%' and s.date = '" + date
				+ "'";
		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<DateScheduleBean> getScheduleInfo(String film)
	{
		String sql = " and m.title LIKE '%" + film + "%'";
		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<DateScheduleBean> getScheduleInfo(Integer filmId, Date date)
	{
		String sql = " and m.id = " + filmId + " and s.date = '" + date + "'";
		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<DateScheduleBean> getScheduleInfoWithFilmId(Integer filmId)
	{
		String sql = " and m.id = " + filmId;
		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<DateScheduleBean> getScheduleInfo(Date date)
	{
		String sql = " and s.date = '" + date + "'";
		return (this.getScheduleInfoSql(sql));
	}

	public void setReservationInfo(Integer adult, Integer child,
			Integer disabled, Integer schedule_id, Integer user_id)
	{
		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db
					.prepareQuery("insert into reservation (id_user, id_schedule, adult, child, disabled) values (?,?,?,?,?)");

			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, schedule_id);
			preparedStatement.setInt(3, adult);
			preparedStatement.setInt(4, child);
			preparedStatement.setInt(5, disabled);

			preparedStatement.executeUpdate();

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
	}
}
