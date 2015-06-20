package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="priority_seat")
	private int prioritySeat;

	private int seat;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="room")
	private List<Schedule> schedules;

	public Room() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrioritySeat() {
		return this.prioritySeat;
	}

	public void setPrioritySeat(int prioritySeat) {
		this.prioritySeat = prioritySeat;
	}

	public int getSeat() {
		return this.seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Schedule addSchedule(Schedule schedule) {
		getSchedules().add(schedule);
		schedule.setRoom(this);

		return schedule;
	}

	public Schedule removeSchedule(Schedule schedule) {
		getSchedules().remove(schedule);
		schedule.setRoom(null);

		return schedule;
	}

}