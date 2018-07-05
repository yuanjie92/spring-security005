package com.training.entity;

import java.util.Date;

/**
 * Created by admin on 2018/7/1.
 */
public class User {
    private long id;
    private String name;
    private String password;
    private Date birthday;
    private Date createTitme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTitme() {
        return createTitme;
    }

    public void setCreateTitme(Date createTitme) {
        this.createTitme = createTitme;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", createTitme=" + createTitme +
                '}';
    }
}
