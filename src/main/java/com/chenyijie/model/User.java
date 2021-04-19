package com.chenyijie.model;
import java.util.Date;
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String gender;
    private Date birthdate;

    public User(){

    }

    public User(int id, String name, String password, String email, String gender, Date birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getUsername() {
        return name;
    }
    public void setUsername(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
                + gender + ", birthdate=" + birthdate + "]";
    }

}

