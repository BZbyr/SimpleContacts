package com.boyang.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import com.boyang.model.Category;
import com.boyang.model.HibernateSessionFactory;
import org.hibernate.query.Query;
/**
 *
 *
 * @class: CategoryDAO
 * @author: Boyang
 * @date: 2017/12/12 21:18
 */
public class CategoryDAO{
    public static void add(Category category) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            // 开启事务
            tx = session.beginTransaction();
            // 用户的保存
            session.save(category);
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

    public static void delete(String categoryId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            // 先根据id查询对象，再判断删除
            Category category = (Category) session.get(Category.class, categoryId);
            if (category != null) {
                session.delete(category);
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

    public static void update(Category category){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.update(category);
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

    public List<Category> getAllList() {
        Session session = HibernateSessionFactory.getSession();

        try {
            List<Category> resultList = new ArrayList<Category>();
            Query query = session.createQuery("FROM Category ");
            for (Object oneObject:query.getResultList()){
                resultList.add((Category) oneObject);
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
