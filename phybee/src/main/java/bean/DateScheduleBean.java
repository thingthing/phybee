package bean;

import java.sql.Date;
import java.util.ArrayList;

import entity.Schedule;

public class DateScheduleBean
{
	private Date date;
	private ArrayList<Schedule> schedule;
	
	public DateScheduleBean()
	{
		super();
	}
	public DateScheduleBean(Date date, ArrayList<Schedule> schedule)
	{
		super();
		this.date = date;
		this.schedule = schedule;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public ArrayList<Schedule> getSchedule()
	{
		return schedule;
	}
	public void setSchedule(ArrayList<Schedule> schedule)
	{
		this.schedule = schedule;
	}
	public void addSchedule(Schedule sched)
	{
		this.schedule.add(sched);
	}
	
}
