package com.boyang.action;

import com.boyang.dao.CategoryDAO;
import com.boyang.dao.UserDAO;
import com.boyang.model.Category;
import com.boyang.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @package: com.boyang.action
 * @Class: AddAction
 * @author: Boyang
 * @date: 2017/12/27 23:21
 */

@SuppressWarnings("serial")
public class AddAction extends ActionSupport{
    private String name;
    private String category;
    private String phone;
    private String mail;
    private String description;
    private User user;
    private List<Category> categoryList;

    public AddAction(){
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryList = new ArrayList<Category>();
        categoryList= categoryDAO.getAllList();
    }

    public List<Category> getCategoryList() {
        System.out.println("******/AddAction/************");
        System.out.println(categoryList.get(0).toString());
        return categoryList;
    }

    private User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public String execute() throws Exception{

        ActionContext context=ActionContext.getContext();

        user = new User(name, category, phone, mail, description);

        UserDAO userDAO = new UserDAO();
        System.out.println("-----------addUser-----------------------");
        System.out.println(getUser().toString());

        UserDAO.add(getUser());

        System.out.println("------------return user list----------");
        List<User> userList = new ArrayList<User>();
        userList=userDAO.getAllList();
        System.out.println(userList.get(0).toString());
        System.out.println(userList.get(1).toString());
        System.out.println(userList.get(2).toString());
        context.put("userList",userList);

        return SUCCESS;
    }
}
