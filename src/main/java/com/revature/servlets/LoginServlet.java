package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.daos.EmployeeDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private ObjectMapper om = new ObjectMapper();
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//
    @Override // this method responds to GET requests
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // obtaining user data from form
        String newUsername = req.getParameter("username");
        String newPassword = req.getParameter("password");
//        String newRole = req.getParameter("role");

        System.out.println("We got some form data! Name = " + newUsername + " Password " + newPassword);

        Employee newEmployee = new Employee(newUsername, newPassword, null);

        if(newEmployee.getUsername()==null){
            resp.sendError(400, "Email is a required field");
            return;
        }

        if(newEmployee.getPassword()==null){
            resp.sendError(400, "Password is a required field");
            return;
        }
        boolean successfulCreation = employeeDAO.getEmployeeByUsernameAndPassword(newEmployee.getUsername(), newEmployee.getPassword());
        System.out.println(newEmployee.getUsername());

        // respond to the client appropriately (HttpServletResponse)
        if(successfulCreation){
            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
            resp.sendRedirect("/ExpenseReimbursementSystem/successSubmission.html");
        } else {
            resp.sendError(500);
        }
    }
}
