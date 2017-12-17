package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import model.User;
import model.HibernateSessionFactory;
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
        Session session = null;
        Transaction tx = null;
        try {
            // 获取Session
            session = HibernateSessionFactory.getSession();
            // 开启事务
            tx = session.beginTransaction();
            // 用户的保存
            session.save(user);
        } catch (Exception e) {
            // TODO: handle exception

            // 进行事务的回滚
            if (tx != null) {
                tx.rollback();
            } else {
                e.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            // 进行事务的提交
            assert tx != null;
            tx.commit();
            // 关闭session
            session.close();
        }
    }

    public static void delete(int id) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            // 先根据id查询对象，再判断删除
            User user = (User) session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
        } catch (Exception e) {
            // TODO: handle exception

            // 进行事务的回滚
            if (tx != null) {
                tx.rollback();
            } else {
                e.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            // 进行事务的提交
            assert tx != null;
            tx.commit();
            // 关闭session
            session.close();
        }
    }

    public static void update(User user){
        Session session = null;
        Transaction tx = null;
        try {
            // 获取Session
            session = HibernateSessionFactory.getSession();
            // 开启事务
            tx = session.beginTransaction();
            // 用户的更新
            session.update(user);
        } catch (Exception e) {
            // TODO: handle exception

            // 进行事务的回滚
            if (tx != null) {
                tx.rollback();
            } else {
                e.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            // 进行事务的提交
            assert tx != null;
            tx.commit();
            // 关闭session
            session.close();
        }
    }

    public static List<User> getAllList() {
        Session session = null;
        Transaction tx = null;
        List<User> resultList = new ArrayList<User>();
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User");
            for (Object oneObject:query.getResultList()){
                resultList.add((User)oneObject);
            }
            return resultList;
        } catch (Exception e) {
            // TODO: handle exception

            // 进行事务的回滚
            if (tx != null) {
                tx.rollback();
            } else {
                e.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            // 进行事务的提交
            assert tx != null;
            tx.commit();
            // 关闭session
            session.close();
        }

    }
}
