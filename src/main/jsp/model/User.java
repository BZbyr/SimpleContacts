package model;

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
    private String userName;
    private String category;
    private String phone;
    private String mail;
    private String description;

    public User(){}

    public User(String userName, String category, String phone, String mail, String description){
        this.userName = userName;
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


    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String name) {
        this.userName = name;
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
        return getId()+" "+getUserName()+" "+getCategory()+" "+getPhone()+" "+getMail()+" "+getDescription();
    }
}
