//package com.revature.servlets;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//public class ViewAllSubmissionServlet extends HttpServlet {
//
//    @Override // this method responds to GET requests
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // obtaining user data
//        UserService userService = new UserService();
//        List<User> users = userService.getAll();
//
//        // use jackson-databind to convert java objects into JSON
//        ObjectMapper om = new ObjectMapper();
//        String userJson = om.writeValueAsString(users);
//
//        try (PrintWriter pw = resp.getWriter()) {
////            pw.write(users.toString());  // instead of using the users toString, we want to use JSON
//            pw.write(userJson); // write the JSON to response body
//        }
//    }
//
//}