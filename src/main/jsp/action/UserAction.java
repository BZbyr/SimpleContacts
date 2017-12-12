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

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String addUser() throws Exception{
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String userName = request.getParameter("name");
        String category = request.getParameter("category");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        String description = request.getParameter("description");
        UserDAO.add(userName, category, phone, mail, description);
        List<User> userList = UserDAO.getAllList();
        context.put("userList", userList);

        return "user";
    }
}
