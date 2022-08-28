package HibernateDao;

import Entities.Customer;

import Entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class CustomerDao {
    public static void createCustomer(Customer customer){

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(customer);

        session.getTransaction().commit();

    }

    public static Customer getCustomer(long id){

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.getTransaction().commit();

        return customer;
    }

    public static void updateCustomer(Customer customer,long id){

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer newCustomer = session.get(Customer.class,id);
        newCustomer.setName(customer.getName());
        newCustomer.setSurname(customer.getSurname());
        session.getTransaction().commit();

    }

    public static void deleteCustomer(long id){

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.remove(customer);
        session.getTransaction().commit();

    }
    public static List<Customer> getAllCustomers() {
        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session.createQuery("select a from Customer a",Customer.class)
                .getResultList();
    }


}
