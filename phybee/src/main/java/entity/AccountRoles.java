package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name = "account_roles")
@NamedQuery(name = "AccountRoles.findAll", query = "SELECT a FROM AccountRoles a")
public class AccountRoles implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_role_id")
	private int id;
	
	// bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumns({
		    @JoinColumn(name="email", referencedColumnName="email"),
		    @JoinColumn(name="id_account", referencedColumnName="id")
		})
	private Account account;
	
	@Column(name="ROLE")
	private String role;

	public AccountRoles()
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

	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
}
