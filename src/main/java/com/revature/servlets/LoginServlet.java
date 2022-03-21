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

        // add new record to the db -> use the CustomerDAO to do this
        boolean successfulCreation = EmployeeDAO.getEmployeeByUsernameAndPassword(newUsername, newPassword);
        System.out.println(successfulCreation);
        // respond to the client appropriately (HttpServletResponse)
        if(successfulCreation){
            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
            resp.sendRedirect("/successSubmission.html");
        } else {
            resp.sendError(500);
        }

        // obtain user input from the HttpServletRequest (request body)
//        try (BufferedReader reader = req.getReader()) {
//            String requestBody = reader.readLine();
//            System.out.println(requestBody);
//
//            if (requestBody == null) {
//                resp.sendError(400, "Empty request body not supported");
//                return;
//            }
//
//            // parse the input -> use jackson to create a customer object
//            Employee employee = om.readValue(requestBody, Employee.class);
//
//            if (employee.getUsername() == null) {
//                resp.sendError(400, "Email is a required field");
//                return;
//            }
//
//            if (employee.getPassword() == null) {
//                resp.sendError(400, "Email is a required field");
//                return;
//            }
//
//            // add new record to the db -> use the CustomerDAO to do this
//            boolean successfulCreation = employeeDAO.getEmployeeByUsernameAndPassword(newUsername, newPassword);
//
//            // respond to the client appropriately (HttpServletResponse)
//            if (!successfulCreation) resp.sendError(500);
//            else {
//                resp.setStatus(201);
//                resp.sendRedirect("/successSubmission.html");
//            }
//
//        }


        // obtaining user data from form
//        String newUsername = req.getParameter("username");
//        String newPassword = req.getParameter("password");
//        System.out.println("We got some form data! Name = " + newUsername + " Password " + newPassword);
//
//        Employee newEmployee = new Employee(newUsername, newPassword, null);
//
////        // use jackson-databind to convert java objects into JSON
//        ObjectMapper om = new ObjectMapper();
//        String userJson = om.writeValueAsString(newEmployee);
//
//        //check with username and password on server
//        try (PrintWriter pw = resp.getWriter()) {
//            pw.write(newEmployee.toString());  // instead of using the users toString, we want to use JSON
//            pw.write(employeeJson); // write the JSON to response body
//        }
//
//        if(newEmployee.getUsername()==null){
//            resp.sendError(400, "Email is a required field");
//            return;
//        }
//
//        if(newEmployee.getPassword()==null){
//            resp.sendError(400, "Password is a required field");
//            return;
//        }
//
//        // add new record to the db -> use the CustomerDAO to do this
//        boolean successfulCreation = EmployeeDAO.getEmployeeByUsernameAndPassword();
//
//        // respond to the client appropriately (HttpServletResponse)
//        if(successfulCreation){
//            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
//            resp.sendRedirect("/successSubmission.html");
//        } else {
//            resp.sendError(500);
//        }
//    }
    }
}
