package Servlets;

import Entities.Customer;
import Entities.Developer;
import Entities.Project;
import HibernateDao.CustomerDao;
import HibernateDao.DeveloperDao;
import HibernateDao.ProjectDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class Servlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        final String value = "developer";

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertDeveloper(request, response);
                    break;
                case "/delete":
                    deleteDeveloper(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateDeveloper(request, response);
                    break;
                case "/newCustomer":
                    showNewFormCustomer(request, response);
                    break;
                case "/insertCustomer":
                    insertCustomer(request, response);
                    break;
                case "/deleteCustomer":
                    deleteCustomer(request, response);
                    break;
                case "/editCustomer":
                    showEditFormCustomer(request, response);
                    break;
                case "/updateCustomer":
                    updateCustomer(request, response);
                    break;
                case "/listCustomer":
                    listCustomer(request,response);
                    break;
                case "/newProject":
                    showNewFormProject(request, response);
                    break;
                case "/insertProject":
                    insertProject(request, response);
                    break;
                case "/deleteProject":
                    deleteProject(request, response);
                    break;
                case "/editProject":
                    showEditFormProject(request, response);
                    break;
                case "/updateProject":
                    updateProject(request, response);
                    break;
                case "/listProject":
                    listProject(request,response);
                    break;
                default:
                    listDeveloper(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Developer> listDeveloper = DeveloperDao.getAllDevelopers();
        request.setAttribute("listDeveloper", listDeveloper);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewDevelopers.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Developers-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Developer developer = DeveloperDao.getDeveloper(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Developers-form.jsp");
        request.setAttribute("developer", developer);
        dispatcher.forward(request, response);

    }

    private void insertDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Developer developer = new Developer(name, sex, salary);
        DeveloperDao.createDeveloper(developer);
        response.sendRedirect("ViewDevelopers.jsp");
    }

    private void updateDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int salary = Integer.parseInt(request.getParameter("salary"));

        Developer developer = new Developer(id, name, sex, salary);
        DeveloperDao.updateDeveloper(developer,id);
        response.sendRedirect("ViewDevelopers.jsp");
    }

    private void deleteDeveloper(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DeveloperDao.deleteDeveloper(id);
        response.sendRedirect("ViewDevelopers.jsp");

    }
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = CustomerDao.getAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = CustomerDao.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);

    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Customer customer = new Customer(name,surname);
        CustomerDao.createCustomer(customer);
        response.sendRedirect("ViewCustomer.jsp");
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        Customer customer = new Customer(name,surname);
        CustomerDao.updateCustomer(customer,id);
        response.sendRedirect("ViewCustomer.jsp");

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(id);
        response.sendRedirect("ViewCustomer.jsp");

    }

    private void listProject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Project> listProject = ProjectDao.getAllProjects();
        request.setAttribute("listProject", listProject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProject.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Project-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormProject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Project project = ProjectDao.getProject(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Project-form.jsp");
        request.setAttribute("project", project);
        dispatcher.forward(request, response);

    }

    private void insertProject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String time_of_creation = request.getParameter("time_of_creation");
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        long companyId = Long.parseLong(request.getParameter("company_id"));


        ProjectDao.createProject(new Project(name,time_of_creation,customerId,customerId));
        response.sendRedirect("ViewProject.jsp");
    }

    private void updateProject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String time_of_creation = request.getParameter("time_of_creation");
        long customerId = Long.parseLong(request.getParameter("customer_id"));
        long companyId = Long.parseLong(request.getParameter("company_id"));

        ProjectDao.updateProject(new Project(name,time_of_creation,customerId,companyId),id);
        response.sendRedirect("ViewProject.jsp");

    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProjectDao.deleteProject(id);
        response.sendRedirect("ViewProject.jsp");

    }


}