package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginServlet extends HttpServlet {

//    private ObjectMapper om = new ObjectMapper();
//    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override // this method responds to GET requests
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // obtaining user data from form
        String newUsername = req.getParameter("username");
        String newPassword = req.getParameter("password");
        System.out.println("We got some form data! Name = " + newUsername + " Password " + newPassword);

//        // use jackson-databind to convert java objects into JSON
//        ObjectMapper om = new ObjectMapper();
//        String userJson = om.writeValueAsString(users);
//
//        //check with username and password on server
//        try (PrintWriter pw = resp.getWriter()) {
////            pw.write(users.toString());  // instead of using the users toString, we want to use JSON
//            pw.write(userJson); // write the JSON to response body
//        }
//
//        Employee newEmployee = new Employee(newUsername, newPassword, null);
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
//        boolean successfulCreation = employeeDAO.getEmployeeByUsernameAndPassword();
//
//        // respond to the client appropriately (HttpServletResponse)
//        if(successfulCreation){
//            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
//        } else {
//            resp.sendError(500);
//        }
//    }
    }
}
