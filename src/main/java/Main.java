import Entities.Customer;
import HibernateDao.CustomerDao;
import HibernateDao.DeveloperDao;
import HibernateDao.ProjectDao;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("DeveloperDao.getAllDevelopers() = " + ProjectDao.getAllProjects());

    }
}
