package HibernateDao;

import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDao {
    public static SessionFactory getSessionFactory(){
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Developer.class)
                .addAnnotatedClass(Project.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Skill.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}
