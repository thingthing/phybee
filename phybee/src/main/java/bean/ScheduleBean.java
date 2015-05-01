package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class ScheduleBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer id_movie;
	private Integer id_room;
	private String title_movie;
	private Time start;
	private Time end;
	private Date date;
	private Integer seat_remain;
	private Integer priority_seat_remain;
	
	public ScheduleBean(Integer id, Integer id_movie, Integer id_room,
			String title_movie, Time start, Time end, Date date, Integer seat_remain,
			Integer priority_seat_remain)
	{
		super();
		this.id = id;
		this.id_movie = id_movie;
		this.id_room = id_room;
		this.title_movie = title_movie;
		this.start = start;
		this.end = end;
		this.setDate(date);
		this.seat_remain = seat_remain;
		this.priority_seat_remain = priority_seat_remain;
	}

	public ScheduleBean()
	{
	}
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId_movie()
	{
		return id_movie;
	}

	public void setId_movie(Integer id_movie)
	{
		this.id_movie = id_movie;
	}

	public Integer getId_room()
	{
		return id_room;
	}

	public void setId_room(Integer id_room)
	{
		this.id_room = id_room;
	}

	public String getTitle_movie()
	{
		return title_movie;
	}

	public void setTitle_movie(String title_movie)
	{
		this.title_movie = title_movie;
	}

	public Time getStart()
	{
		return start;
	}

	public void setStart(Time start)
	{
		this.start = start;
	}

	public Time getEnd()
	{
		return end;
	}

	public void setEnd(Time end)
	{
		this.end = end;
	}

	public Integer getSeat_remain()
	{
		return seat_remain;
	}

	public void setSeat_remain(Integer seat_remain)
	{
		this.seat_remain = seat_remain;
	}

	public Integer getPriority_seat_remain()
	{
		return priority_seat_remain;
	}

	public void setPriority_seat_remain(Integer priority_seat_remain)
	{
		this.priority_seat_remain = priority_seat_remain;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}
