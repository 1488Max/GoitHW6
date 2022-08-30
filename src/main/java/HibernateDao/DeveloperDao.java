package HibernateDao;

import Entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class DeveloperDao {
    public static void createDeveloper(Developer developer) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(developer);

        session.getTransaction().commit();

    }

    public static Developer getDeveloper(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        session.getTransaction().commit();

        return developer;
    }

    public static void updateDeveloper(Developer developer, long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Developer newDeveloper = session.get(Developer.class, id);
        newDeveloper.setName(developer.getName());
        newDeveloper.setSex(developer.getSex());
        newDeveloper.setSalary(developer.getSalary());
        session.getTransaction().commit();

    }

    public static void deleteDeveloper(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        session.remove(developer);
        session.getTransaction().commit();

    }

    public static List<Developer> getAllDevelopers() {
        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session.createQuery("select a from Developer a", Developer.class)
                .getResultList();
    }


}
