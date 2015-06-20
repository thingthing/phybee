package entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the account database table.
 * 
 */
@Embeddable
public class AccountPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	public AccountPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccountPK)) {
			return false;
		}
		AccountPK castOther = (AccountPK)other;
		return 
			(this.id == castOther.id)
			&& this.email.equals(castOther.email);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.email.hashCode();
		
		return hash;
	}
}