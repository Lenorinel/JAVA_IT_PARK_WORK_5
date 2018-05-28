package ru.itpark.service.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.Customer;
import ru.itpark.service.repositories.CustomerRepository;
import ru.itpark.service.services.CustomerService;
import ru.itpark.service.services.CustomerServiceByDataBaseImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet{
    private CustomerService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
        service = new CustomerServiceByDataBaseImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action") != null && req.getParameter("action").equals("signUp")) {
            req.getRequestDispatcher("/jsp/SignUp.jsp").forward(req, resp);
        } else {
            List<Customer> customers = service.findAllCustomersFromDatabase();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String firstname = req.getParameter("firstname");
    String lastname = req.getParameter("lastname");
    String email = req.getParameter("email");
    String address = req.getParameter("address");
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    UserForm userForm = UserForm.builder()
            .firstName(firstname)
            .secondName(lastname)
            .email(email)
            .address(address)
            .login(login)
            .password(password).
                    build();
    service.registerNewUser(userForm);
        resp.sendRedirect("/users");
    }
}
