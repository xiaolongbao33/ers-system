package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewAllReimbursementsServlet extends HttpServlet {

    // overriding doGet method to respond accordingly to that request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // return 200 status code
        // return hello in the response body
        resp.setStatus(200);
        resp.setHeader("Content-Type", "text/plain");
        try(PrintWriter pw = resp.getWriter();) { // writes text to the body of the response
            pw.write("Hello World! (from my servlet)");
        }
    }


}