package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class ReqSubmissionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // obtain the new user info from the request body
        try(BufferedReader reader = req.getReader();){
            String requestBody = reader.readLine(); // reads in any text in the request body
            System.out.println(requestBody);
            // store that info with the rest of our user data
            // return a response to our client
        }

    }
}


