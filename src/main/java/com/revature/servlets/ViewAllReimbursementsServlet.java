package com.revature.servlets;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ViewAllReimbursementsServlet extends HttpServlet {

    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    // overriding doGet method to respond accordingly to that request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // return 200 status code
        // return hello in the response body
        resp.setStatus(200);

        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        try {
            reimbursements = reimbursementDAO.getAllReimbursements();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        String reimbursementJson = om.writeValueAsString(reimbursements);

        resp.setHeader("Content-Type", "application/json");

        try(PrintWriter pw = resp.getWriter()) {
            System.out.println(reimbursementJson);
            pw.write(reimbursementJson);
        }

//        resp.setHeader("Content-Type", "text/plain");
//        try(PrintWriter pw = resp.getWriter();) { // writes text to the body of the response
//            pw.write("Hello World! (from my servlet)");
//        }
    }


}