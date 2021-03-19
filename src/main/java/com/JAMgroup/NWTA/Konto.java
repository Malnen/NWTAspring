
package com.JAMgroup.NWTA;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Konto {
    @Id
    @Column(name = "Login")
    private String login;

    @Column(name = "Haslo")
    private String haslo;

    @Column(name = "Email")
    private String email;

    @Column(name = "Awatar")
    private String awatar;


    @Column(name = "DataDolaczenia")
    private java.sql.Timestamp DataDolaczenia;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAwatar() {
        return awatar;
    }

    public void setAwatar(String awatar) {
        this.awatar = awatar;
    }


    public Timestamp getDataDolaczenia() {
        return DataDolaczenia;
    }

    public void setDataDolaczenia(Timestamp DataDolaczenia) {
        this.DataDolaczenia = DataDolaczenia;
    }

}
