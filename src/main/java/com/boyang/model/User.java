package com.boyang.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 *
 * @class: User
 * @author: Boyang
 * @date: 2017/12/11 19:49
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String category;
    private String phone;
    private String mail;
    private String description;

    public User(){}

    public User(String name, String category, String phone, String mail, String description){
        this.name = name;
        this.category = category;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public void  setId(int userId){
        this.id = userId;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return getId()+" "+getName()+" "+getCategory()+" "+getPhone()+" "+getMail()+" "+getDescription();
    }
}
