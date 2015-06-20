package bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import entity.Account;

import javax.persistence.*;

/**
 * Created by Eric on 23/05/2015.
 */
@Component
@Scope("session")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(length = 60)
    private String password;

    private boolean enabled;

    private boolean tokenExpired;

    public UserBean() {
        super();
        this.enabled = false;
        this.tokenExpired = false;
    }

    public void setUserFromEntity(Account account)
    {
    	this.firstName = account.getFirstname();
    	this.lastName = account.getLastname();
    	this.email = account.getId().getEmail();
    	this.password = account.getPassword();
    	this.id = account.getId().getId();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean expired) {
        this.tokenExpired = expired;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserBean user = (UserBean) obj;
        if (!email.equals(user.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("User [firstName=").append(firstName).append("]").append("[lastName=").append(lastName).append("]").append("[username").append(email).append("]");
        return builder.toString();
    }
}
