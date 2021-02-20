package com.fenghen.pojo;

import java.util.Date;

public class User implements java.io.Serializable {
    private Integer id;
    private String username;
    private String emailname;
    private String password;
    private Date register_time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailname='" + emailname + '\'' +
                ", password='" + password + '\'' +
                ", register_time=" + register_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailname() {
        return emailname;
    }

    public void setEmailname(String emailname) {
        this.emailname = emailname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }
}
