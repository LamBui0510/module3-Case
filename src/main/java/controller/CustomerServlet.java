package controller;

import model.Customer;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                List<Customer> customerList = customerService.getList();
                request.setAttribute("customer", customerList);
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
                break;
            case "edit":
            customerList = customerService.getList();
               request.setAttribute("customer", customerList);
               request.getRequestDispatcher("editCustomer.jsp").forward(request, response);
                break;
            case "delete":
               int id = Integer.parseInt(request.getParameter("id"));
                customerService.delete(id) ;
                response.sendRedirect("/home.jsp");
                break;
            default:
                requestDispatcher = request.getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                String user = request.getParameter("userName");
                String password = request.getParameter("password");
                Customer customer = customerService.checkLoginCustomer(user,password);
                if(customer == null){
                    response.sendRedirect("/login.jsp");
                }else {
                    request.getRequestDispatcher("/home.jsp").forward(request,response);
                }
                break;
            case "register":
                String email = request.getParameter("email");
                String passwords = request.getParameter("password");
                request.setAttribute("customer", customerService.getList());
                request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
                break;
            default: response.sendRedirect("/home.jsp");
        }
    }
}
