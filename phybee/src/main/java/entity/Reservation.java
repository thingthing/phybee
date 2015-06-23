package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
public class Reservation implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int child;

	private int adult;

	private int disabled;

	// bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="email", referencedColumnName="email"),
	    @JoinColumn(name="id_user", referencedColumnName="id")
	})
	private Account account;

	// bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name = "id_schedule")
	private Schedule schedule;

	public Reservation()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getChild()
	{
		return child;
	}

	public void setChild(int child)
	{
		this.child = child;
	}

	public int getAdult()
	{
		return adult;
	}

	public void setAdult(int adult)
	{
		this.adult = adult;
	}

	public int getDisabled()
	{
		return disabled;
	}

	public void setDisabled(int disabled)
	{
		this.disabled = disabled;
	}

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public Schedule getSchedule()
	{
		return schedule;
	}

	public void setSchedule(Schedule schedule)
	{
		this.schedule = schedule;
	}
}
