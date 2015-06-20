package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="end_release")
	private Date endRelease;

	private String poster;

	@Temporal(TemporalType.DATE)
	private Date release;

	@Lob
	private String synopsis;

	private Time time;

	private String title;

	@Lob
	private String trailer;

	//bi-directional many-to-one association to Producer
	@ManyToOne
	@JoinColumn(name="id_producer")
	private Producer producer;

	//bi-directional many-to-one association to Moviegenre
	@OneToMany(mappedBy="movie")
	private List<Moviegenre> moviegenres;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="movie")
	private List<Schedule> schedules;

	public Movie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndRelease() {
		return this.endRelease;
	}

	public void setEndRelease(Date endRelease) {
		this.endRelease = endRelease;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Date getRelease() {
		return this.release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public String getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public List<Moviegenre> getMoviegenres() {
		return this.moviegenres;
	}

	public void setMoviegenres(List<Moviegenre> moviegenres) {
		this.moviegenres = moviegenres;
	}

	public Moviegenre addMoviegenre(Moviegenre moviegenre) {
		getMoviegenres().add(moviegenre);
		moviegenre.setMovie(this);

		return moviegenre;
	}

	public Moviegenre removeMoviegenre(Moviegenre moviegenre) {
		getMoviegenres().remove(moviegenre);
		moviegenre.setMovie(null);

		return moviegenre;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setMovie(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setMovie(null);

		return schedule;
	}

}