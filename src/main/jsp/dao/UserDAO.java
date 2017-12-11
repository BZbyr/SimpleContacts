package dao;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.User;
import model.HibernateSessionFactory;
/**
 *
 *
 * @package: dao
 * @class: UserDAO
 * @author: Boyang
 * @date: 2017/12/11 21:44
 */
public class UserDAO {
    public static void addUser(User user){
        Session session=HibernateSessionFactory.getSession();
        try{
            session.save(user);
        }catch (Exception e){
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        Session session=HibernateSessionFactory.getSession();
        try {
            session.beginTransaction();
            User user=(User)session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.clear();
            session.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
