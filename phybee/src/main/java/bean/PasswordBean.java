package bean;

import validator.PasswordMatches;

/**
 * Created by Eric on 14/06/2015.
 */
@PasswordMatches
public class PasswordBean {
    private String password;
    private String matchingPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public PasswordBean (String old, String newP, String matching) {
        super();
        this.password = newP;
        this.matchingPassword = matching;
    }

    public PasswordBean() {
        super();
    }

}
