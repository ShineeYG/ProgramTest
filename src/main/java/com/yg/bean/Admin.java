package com.yg.bean;

import java.util.Date;

/**
 * Created by yg on 17/9/1.
 */
public class Admin {
    private int admin_id;
    private String admin_code;
    private int password;
    private String name;
    private String telephone;
    private String email;
    private Date enrodate;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_code='" + admin_code + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrodate=" + enrodate +
                '}';
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrodate() {
        return enrodate;
    }

    public void setEnrodate(Date enrodate) {
        this.enrodate = enrodate;
    }
}
