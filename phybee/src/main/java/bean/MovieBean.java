package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entity.Genre;
import entity.Movie;
import entity.Moviegenre;
import entity.Schedule;

/**
 * Created by Elyo on 01/05/2015.
 */
public class MovieBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mId;
	private int mIdProducer;
	private ArrayList<Genre> mGenre;
	private String mTitle;
	private String mSynopsis;
	private String mTrailer;
	private Time mTime;
	private String mPoster;
	private Date mDate;
	private Date mEndDate;
	private List<DateScheduleBean> mDateSchedule;

	public int getmId()
	{
		return mId;
	}

	public void setmId(int mId)
	{
		this.mId = mId;
	}

	public int getmIdProducer()
	{
		return mIdProducer;
	}

	public void setmIdProducer(int mIdProducer)
	{
		this.mIdProducer = mIdProducer;
	}

	public String getmTitle()
	{
		return mTitle;
	}

	public void setmTitle(String mTitle)
	{
		this.mTitle = mTitle;
	}

	public String getmSynopsis()
	{
		return mSynopsis;
	}

	public void setmSynopsis(String mSynopsis)
	{
		this.mSynopsis = mSynopsis;
	}

	public String getmTrailer()
	{
		return mTrailer;
	}

	public void setmTrailer(String mTrailer)
	{
		this.mTrailer = mTrailer;
	}

	public Time getmTime()
	{
		return mTime;
	}

	public void setmTime(Time mTime)
	{
		this.mTime = mTime;
	}

	public String getmPoster()
	{
		return mPoster;
	}

	public void setmPoster(String mPoster)
	{
		this.mPoster = mPoster;
	}

	public Date getmDate()
	{
		return mDate;
	}

	public void setmDate(Date mDate)
	{
		this.mDate = mDate;
	}

	public MovieBean(Movie movie)
	{
		this.setmId(movie.getId());
		this.setmIdProducer(movie.getProducer().getId());
		this.setmTitle(movie.getTitle());
		this.setmSynopsis(movie.getSynopsis());
		this.setmTrailer(movie.getTrailer());
		this.setmTime(movie.getDuration());
		this.setmPoster(movie.getPoster());
		this.setmDate(movie.getStartRelease());
		this.setmEndDate(movie.getEndRelease());

		ArrayList<Genre> genre = new ArrayList<Genre>();
		for (Moviegenre g : movie.getMoviegenres())
		{
			genre.add(g.getGenre());
		}
		this.setmGenre(genre);

		this.mDateSchedule = new ArrayList<DateScheduleBean>();
		DateScheduleBean dateschedule = null;
		Date currentDate = new Date(new java.util.Date().getTime());
		for (Schedule s : movie.getSchedules())
		{
			Date date = s.getScheduleDate();
			if (date.before(currentDate) == true)
				continue;
			if (dateschedule == null
					|| date.equals(dateschedule.getDate()) == false)
			{
				if (dateschedule != null)
					this.mDateSchedule.add(dateschedule);
				dateschedule = new DateScheduleBean(date,
						new ArrayList<Schedule>());
			}
			dateschedule.addSchedule(s);
		}
		if (dateschedule != null)
			this.mDateSchedule.add(dateschedule);
	}

	public MovieBean(int id, int idProducer, String title, String synopsis,
			String trailer, Time time, String poster, Date date, Date end_date,
			ArrayList<Genre> genre)
	{
		this.setmId(id);
		this.setmTitle(title);
		this.setmSynopsis(synopsis);
		this.setmTrailer(trailer);
		this.setmTime(time);
		this.setmPoster(poster);
		this.setmDate(date);
		this.setmEndDate(end_date);
		this.setmGenre(genre);
	}

	public MovieBean(String title, String synopsis, String trailer, Time time,
			String poster, Date date)
	{
		this.setmTitle(title);
		this.setmSynopsis(synopsis);
		this.setmTrailer(trailer);
		this.setmTime(time);
		this.setmPoster(poster);
		this.setmDate(date);
	}

	public Date getmEndDate()
	{
		return mEndDate;
	}

	public void setmEndDate(Date mEndDate)
	{
		this.mEndDate = mEndDate;
	}

	public ArrayList<Genre> getmGenre()
	{
		return mGenre;
	}

	public void setmGenre(ArrayList<Genre> mGenre)
	{
		this.mGenre = mGenre;
	}

	public List<DateScheduleBean> getmDateSchedule()
	{
		return mDateSchedule;
	}

	public void setmDateSchedule(List<DateScheduleBean> mDateSchedule)
	{
		this.mDateSchedule = mDateSchedule;
	}
}
