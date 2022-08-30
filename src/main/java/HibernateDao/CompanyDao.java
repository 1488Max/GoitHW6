package HibernateDao;

import Entities.Company;
import Entities.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;


public class CompanyDao {
    public static void createCompany(Company company) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(company);

        session.getTransaction().commit();

    }

    public static Company getCompany(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.getTransaction().commit();

        return company;
    }

    public static void updateCompany(Company company, long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company newCompany = session.get(Company.class, id);
        newCompany.setName(company.getName());
        newCompany.setArea(company.getArea());
        session.getTransaction().commit();

    }

    public static void deleteCompany(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.remove(company);
        session.getTransaction().commit();

    }



}
