package bean;

import java.sql.Date;
import java.sql.Time;

public class UserMovies
{
	private MovieBean movie;
	private Integer adult;
	private Integer child;
	private Integer disabled;
	private Date date;
	private Time start;
	private Time end;

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
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

	public Integer getAdult()
	{
		return adult;
	}

	public void setAdult(Integer adult)
	{
		this.adult = adult;
	}

	public Integer getChild()
	{
		return child;
	}

	public void setChild(Integer child)
	{
		this.child = child;
	}

	public Integer getDisabled()
	{
		return disabled;
	}

	public void setDisabled(Integer disabled)
	{
		this.disabled = disabled;
	}

	public MovieBean getMovie()
	{
		return movie;
	}

	public void setMovie(MovieBean movie)
	{
		this.movie = movie;
	}

	public UserMovies(MovieBean movie, Integer adult, Integer child,
			Integer disabled, Date date, Time start, Time end)
	{
		super();
		this.movie = movie;
		this.adult = adult;
		this.child = child;
		this.disabled = disabled;
		this.date = date;
		this.start = start;
		this.end = end;
	}

	public UserMovies()
	{

	}
}