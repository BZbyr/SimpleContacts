package com.boyang.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import com.boyang.model.User;
import com.boyang.model.HibernateSessionFactory;
import org.hibernate.query.Query;

/**
 *
 *
 * @class: UserDAO
 * @author: Boyang
 * @date: 2017/12/11 21:44
 */
public class UserDAO{

    public static void add(User user) {
        Session session = HibernateSessionFactory.getSession();
        try {
            // 用户的保存
            session.save(user);
            session.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Session session = HibernateSessionFactory.getSession();
        System.out.println("Hibernate要删除的"+id);
        System.out.println("----------------------------------------------------");
        try {
            session.beginTransaction();
            // 先根据id查询对象，再判断删除
            User user = (User) session.get(User.class, id);
            if (user != null) {
                System.out.println("这里 user ！= null");
                System.out.println("----------------------------------------------------");
                session.delete(user);
            }
            session.getTransaction().commit();
            session.clear();
            session.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void update(User user){
        Session session = HibernateSessionFactory.getSession();
        try {
            // 用户的更新
            session.update(user);
            session.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<User> getAllList() {
        Session session = HibernateSessionFactory.getSession();

        try {
            List<User> resultList = new ArrayList<User>();
            Query query = session.createQuery("FROM User");
            for (Object oneObject:query.getResultList()){
                resultList.add((User)oneObject);
            }
            session.close();
            return resultList;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}
