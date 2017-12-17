package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import model.User;
import org.apache.struts2.ServletActionContext;

/**
 *
 *
 * @class: UserAction
 * @author: Boyang
 * @date: 2017/12/12 21:32
 */
public class UserAction extends ActionSupport{

    private User user= new User();

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String toAddUser()throws Exception{
        return "toAddUser";
    }

    public String addUser() throws Exception{

        ActionContext context = ActionContext.getContext();

        UserDAO.add(user);

        List<User> userList = UserDAO.getAllList();

        context.put("userList", userList);

        return "user";
    }

    public String delUser()throws Exception{

        ActionContext context=ActionContext.getContext();
        HttpServletRequest request=ServletActionContext.getRequest();

        String id=request.getParameter("id");

        UserDAO.delete(Integer.parseInt(id));

        List<User> userList=UserDAO.getAllList();

        context.put("userList", userList);

        return "user";
    }

    public String showUserList()throws Exception{

        ActionContext context=ActionContext.getContext();

        List<User> userList=UserDAO.getAllList();

        context.put("userList", userList);


        return "user";
    }
}
