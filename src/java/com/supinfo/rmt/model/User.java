/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.model;

import com.supinfo.rmt.validation.SecuredPassword;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
    
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String username;
    
    @SecuredPassword
    private String password;
    
    @NotEmpty
    private String firstname;
    
    @NotEmpty
    private String lastname;
    
    @NotEmpty @Email
    private String email;
    
    @NotNull @Past
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
