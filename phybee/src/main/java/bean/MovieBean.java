package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Elyo on 01/05/2015.
 */
public class MovieBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mId;
	private int mIdGenre;
    private int mIdProducer;
    private String mTitle;
    private String mSynopsis;
    private Timestamp mTime;
    private String mPoster;
    private Date mDate;
    private Date mEndDate;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmIdProducer() {
        return mIdProducer;
    }

    public void setmIdProducer(int mIdProducer) {
        this.mIdProducer = mIdProducer;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmSynopsis() {
        return mSynopsis;
    }

    public void setmSynopsis(String mSynopsis) {
        this.mSynopsis = mSynopsis;
    }

    public Timestamp getmTime() {
        return mTime;
    }

    public void setmTime(Timestamp mTime) {
        this.mTime = mTime;
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public MovieBean(int id, int idGenre, int idProducer, String title,
                 String synopsis, Timestamp time, String poster,
                 Date date, Date end_date) {
        this.setmId(id);
        this.setmIdGenre(idGenre);
        this.setmIdProducer(mIdProducer);
        this.setmTitle(title);
        this.setmSynopsis(synopsis);
        this.setmTime(time);
        this.setmPoster(poster);
        this.setmDate(date);
        this.setmEndDate(end_date);
    }

    public MovieBean(String title,
                 String synopsis, Timestamp time, String poster, Date date) {
        this.setmTitle(title);
        this.setmSynopsis(synopsis);
        this.setmTime(time);
        this.setmPoster(poster);
        this.setmDate(date);
    }

	public int getmIdGenre()
	{
		return mIdGenre;
	}

	public void setmIdGenre(int mIdGenre)
	{
		this.mIdGenre = mIdGenre;
	}

	public Date getmEndDate()
	{
		return mEndDate;
	}

	public void setmEndDate(Date mEndDate)
	{
		this.mEndDate = mEndDate;
	}
}
