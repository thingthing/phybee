package entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a"),
	@NamedQuery(name="Account.findByMail", query="SELECT a FROM Account a where a.id IS NOT NULL AND a.id.email LIKE :mail"),
	@NamedQuery(name="Account.findById", query="SELECT a FROM Account a where a.id IS NOT NULL AND a.id.id = :id")
	})
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccountPK id;

	private byte enabled;

	private String firstname;

	private String lastname;

	private String password;

	//bi-directional many-to-one association to AccountRole
	@OneToMany(mappedBy="account")
	private List<AccountRoles> accountRole;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="account")
	private List<Reservation> reservations;

	public Account() {
		this.enabled = 1;
	}

	public AccountPK getId() {
		return this.id;
	}

	public void setId(AccountPK id) {
		this.id = id;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountRoles> getAccountRole() {
		return this.accountRole;
	}

	public void setAccountRole(List<AccountRoles> accountRole) {
		this.accountRole = accountRole;
	}

	public AccountRoles addAccountRole(AccountRoles accountRole) {
		getAccountRole().add(accountRole);
		accountRole.setAccount(this);

		return accountRole;
	}

	public AccountRoles removeReservation(AccountRoles accountRole) {
		getAccountRole().remove(accountRole);
		accountRole.setAccount(null);

		return accountRole;
	}
	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setAccount(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setAccount(null);

		return reservation;
	}

}