package bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Elyo on 01/05/2015.
 */
public class Movie implements Serializable{

    private int mId;
    private int mIdProducer;
    private String mTitle;
    private String mSynopsis;
    private Timestamp mTime;
    private String mPoster;
    private Date mDate;

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

    public Movie(int id, int idProducer, String title,
                 String synopsis, Timestamp time, String poster, Date date) {
        this.setmId(id);
        this.setmIdProducer(mIdProducer);
        this.setmTitle(title);
        this.setmSynopsis(synopsis);
        this.setmTime(time);
        this.setmPoster(poster);
        this.setmDate(date);
    }

    public Movie(String title,
                 String synopsis, Timestamp time, String poster, Date date) {
        this.setmTitle(title);
        this.setmSynopsis(synopsis);
        this.setmTime(time);
        this.setmPoster(poster);
        this.setmDate(date);
    }
}
