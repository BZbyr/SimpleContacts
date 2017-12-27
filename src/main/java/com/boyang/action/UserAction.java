package com.boyang.action;

import java.util.ArrayList;
import java.util.List;

import com.boyang.dao.CategoryDAO;
import com.boyang.model.Category;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.boyang.dao.UserDAO;
import com.boyang.model.User;

/**
 *
 *
 * @class: UserAction
 * @author: Boyang
 * @date: 2017/12/12 21:32
 */
public class UserAction extends ActionSupport{

    private User user= new User();
    private List<Category> categoryList;

    public UserAction(){
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryList = new ArrayList<Category>();
        categoryList= categoryDAO.getAllList();
    }

    public List<Category> getCategoryList() {
        System.out.println("*******************************");
        System.out.println(categoryList.get(0).toString());
        return categoryList;
    }

    public User getUser(){
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


    public String delUser()throws Exception{
        UserDAO userDAO = new UserDAO();
        ActionContext context=ActionContext.getContext();

        int id = user.getId();

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

        context.put("userList", userList);

        return "user";
    }
}
