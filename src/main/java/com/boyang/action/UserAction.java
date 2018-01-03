package com.boyang.action;

import java.util.ArrayList;
import java.util.List;

import com.boyang.dao.CategoryDAO;
import com.boyang.model.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.boyang.dao.UserDAO;
import com.boyang.model.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * @class: UserAction
 * @author: Boyang
 * @date: 2017/12/12 21:32
 */
public class UserAction extends ActionSupport{

    private User user= new User();
    private int id;
    private String name;
    private String category;
    private String phone;
    private String mail;
    private String description;
    private List<Category> categoryList;

    public UserAction(){
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryList = new ArrayList<Category>();
        categoryList= categoryDAO.getAllList();
    }

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        this.user.setName(name);
    }

    public String getCategory() {
        return this.category;
    }


    public void setCategory(String category) {
        this.category = category;
        this.user.setCategory(category);
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.user.setPhone(phone);
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
        this.user.setMail(mail);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.user.setDescription(description);
    }


    public List<Category> getCategoryList() {
        System.out.println("*******************************");
        System.out.println(categoryList.get(0).toString());
        return categoryList;
    }

    private User getUser(){
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String toAddUser()throws Exception{
        return "toAddUser";
    }

    public String addUser() throws Exception{

        ActionContext context=ActionContext.getContext();

        UserDAO userDAO = new UserDAO();
        System.out.println("----------------------------------------------------");
        System.out.println(getUser().toString());

        UserDAO.add(getUser());

        System.out.println("----------------------------------------------------");
        List<User> userList = new ArrayList<User>();
        userList=userDAO.getAllList();
        System.out.println(userList.get(0).toString());
        System.out.println(userList.get(1).toString());
        System.out.println(userList.get(2).toString());

        context.put("userList",userList);

        return "user";
    }

    public String delUser()throws Exception{
        UserDAO userDAO = new UserDAO();
        ActionContext context=ActionContext.getContext();

        System.out.println("----------------------------------------------------");

        int id = getId();
        System.out.println("我要删除的"+id);
        System.out.println("----------------------------------------------------");

        userDAO.delete(id);

        List<User> userList=userDAO.getAllList();

        context.put("userList", userList);

        return "user";
    }

    public String showUserList()throws Exception{
        UserDAO userDAO = new UserDAO();
        ActionContext context=ActionContext.getContext();

        List<User> userList = new ArrayList<User>();
        userList=userDAO.getAllList();
        context.put("userList",userList);

        return "user";
    }
}
