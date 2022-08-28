package HibernateDao;

import Entities.Developer;
import Entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class ProjectDao {
    public static void createProject(Project project) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(project);

        session.getTransaction().commit();

    }

    public static Project getProject(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.getTransaction().commit();

        return project;
    }

    public static void updateProject(Project project, long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project newProject = session.get(Project.class, id);
        newProject.setName(project.getName());
        newProject.setTime_of_creation(project.getTime_of_creation());
        newProject.setCustomer(project.getCustomer());
        newProject.setCompany(project.getCompany());
        session.getTransaction().commit();

    }

    public static void deleteProject(long id) {

        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project= session.get(Project.class, id);
        session.remove(project);
        session.getTransaction().commit();

    }

    public static List<Project> getAllProjects() {
        SessionFactory sessionFactory = HibernateDao.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        return session.createQuery("select a from Project a",Project.class)
                .getResultList();
    }


}
