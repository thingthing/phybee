package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.ScheduleBean;
import bean.TicketBean;
import db.PhybeeDb;

public class ReservationService
{
	public ReservationService()
	{

	}

	public void removeAvailableSeat(Integer id_schedule, Integer seats_taken, Boolean is_priority)
	{
		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery("update schedule set ? = (? - ?) where id=?");
			
			String column_name = (is_priority ? "priority_" : "") + "seat_remain";
			
			preparedStatement.setString(1, column_name);
			preparedStatement.setString(2, column_name);
			preparedStatement.setInt(3, seats_taken);
			preparedStatement.setInt(4, id_schedule);
			
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

		}  catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return filmList;
	}
	
	public ArrayList<TicketBean> getTicketInfo() {
		
		ArrayList<TicketBean> ticketList = new ArrayList<TicketBean>();

		try
		{
			String sql = "select * from ticket";
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery(sql);

			while (resultSet.next())
			{
				ticketList.add(new TicketBean(resultSet.getInt("id"), resultSet.getString("type"), resultSet.getDouble("price")));
			}

			db.closeConnection();

		}  catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		return ticketList;
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
		String sql = " and m.title LIKE '%" + film + "%' and s.date = '" + date + "'";
		return (this.getScheduleInfoSql(sql));
	}
	
	public ArrayList<ScheduleBean> getScheduleInfo(String film)
	{
		String sql = " and m.title LIKE '%" + film + "%'";
		return (this.getScheduleInfoSql(sql));
	}

	public ArrayList<ScheduleBean> getScheduleInfo(Integer filmId, Date date)
	{
		String sql = " and m.id = " + filmId + " and s.date = '" + date + "'";
		return (this.getScheduleInfoSql(sql));
	}
	
	public ArrayList<ScheduleBean> getScheduleInfoWithFilmId(Integer filmId)
	{
		String sql = " and m.id " + filmId;
		return (this.getScheduleInfoSql(sql));
	}

	
	public ArrayList<ScheduleBean> getScheduleInfo(Date date)
	{
		String sql = " and s.date = '" + date + "'";
		return (this.getScheduleInfoSql(sql));
	}
	
	public void setReservationInfo(Integer adult, Integer child, Integer disabled, Integer schedule_id, Integer user_id)
	{
		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery("insert into reservation (id_user, id_schedule, adult, child, disabled) values (?,?,?,?,?)");

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
