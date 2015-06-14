package bean;

import java.sql.Date;
import java.util.ArrayList;

public class DateScheduleBean
{
	private Date date;
	private ArrayList<ScheduleBean> schedule;
	
	public DateScheduleBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public DateScheduleBean(Date date, ArrayList<ScheduleBean> schedule)
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
	public ArrayList<ScheduleBean> getSchedule()
	{
		return schedule;
	}
	public void setSchedule(ArrayList<ScheduleBean> schedule)
	{
		this.schedule = schedule;
	}
	public void addSchedule(ScheduleBean sched)
	{
		this.schedule.add(sched);
	}
	
}
