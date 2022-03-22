package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.UserRole;

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
        String newRole = req.getParameter("role");

        System.out.println("We got some form data! Name = " + newUsername + " Password " + newPassword);

        Employee newEmployee = new Employee(newUsername, newPassword, UserRole.valueOf(newRole));
        System.out.println(newEmployee.toString());

        if(newEmployee.getUsername()==null){
            resp.sendError(400, "Email is a required field");
            return;
        }

        if(newEmployee.getPassword()==null){
            resp.sendError(400, "Password is a required field");
            return;
        }
        boolean successfulCreation = employeeDAO.getEmployeeByUsernameAndPassword(newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getRole());
        System.out.println(newEmployee.getUsername());
        System.out.println(newEmployee.getRole());
        System.out.println(successfulCreation);

        // respond to the client appropriately (HttpServletResponse)
        if(successfulCreation && newEmployee.getRole().equals(UserRole.MANAGER)){
            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
            resp.sendRedirect("/ExpenseReimbursementSystem/successSubmission.html");
        }
        if(successfulCreation && newEmployee.getRole().equals(UserRole.EMPLOYEE)){
            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
            resp.sendRedirect("/ExpenseReimbursementSystem/reim-success.html");
        }
    }
}
