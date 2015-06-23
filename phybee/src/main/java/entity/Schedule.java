package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="schedule_date")
	private Date scheduleDate;

	private Time end;

	@Column(name="priority_seat_remain")
	private int prioritySeatRemain;

	@Column(name="seat_remain")
	private int seatRemain;

	private Time start;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="id_movie")
	private Movie movie;

	//bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name="id_room")
	private Room room;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="schedule")
	private List<Reservation> reservations;

	public Schedule() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getScheduleDate() {
		return this.scheduleDate;
	}

	public void setScheduleDate(Date date) {
		this.scheduleDate = date;
	}

	public Time getEnd() {
		return this.end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public int getPrioritySeatRemain() {
		return this.prioritySeatRemain;
	}

	public void setPrioritySeatRemain(int prioritySeatRemain) {
		this.prioritySeatRemain = prioritySeatRemain;
	}

	public int getSeatRemain() {
		return this.seatRemain;
	}

	public void setSeatRemain(int seatRemain) {
		this.seatRemain = seatRemain;
	}

	public Time getStart() {
		return this.start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setSchedule(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setSchedule(null);

		return reservation;
	}

}