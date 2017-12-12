package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 *
 * @class: HibernateSessionFactory
 * @author: Boyang
 * @date: 2017/12/11 21:48
 */
public class HibernateSessionFactory {

    private static String CONFIG_FILE_LOCATION = "resources/hibernate.cfg.xml";
    private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<Session>();
    private  static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

    static {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err
                    .println("%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }
    private HibernateSessionFactory() {
    }

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */

    public static void remove(){
        THREAD_LOCAL.remove();
    }
    public static Session getSession() throws HibernateException {
        Session session = (Session) THREAD_LOCAL.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            THREAD_LOCAL.set(session);
        }

        return session;
    }

    /**
     *  Rebuild hibernate session factory
     *
     */
    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err
                    .println("%%% Error Creating SessionFactory %%%");
            e.printStackTrace();
        }
    }

    /**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) THREAD_LOCAL.get();
        THREAD_LOCAL.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     *  return session factory
     *
     */
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    /**
     *  return hibernate configuration
     *
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
