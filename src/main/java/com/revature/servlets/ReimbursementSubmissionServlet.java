package com.revature.servlets;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class ReimbursementSubmissionServlet extends HttpServlet {

    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // obtaining user data from form
//        String newId = req.getParameter("employeeid");
        String newDesc = req.getParameter("description");
        String newAmount = req.getParameter("amount");
        String newDate = req.getParameter("date");
        String newStatus = req.getParameter("status");

        double amountDB = Double.parseDouble(newAmount);
//        int employeeDB = Integer.parseInt(newId);

        System.out.println("We got some form data! Name = " + newDesc + " Password " + newAmount);

        Reimbursement newReimbursement = new Reimbursement(newDesc, newStatus, amountDB, LocalDate.parse(newDate));
        System.out.println(newReimbursement.toString());

        if(newReimbursement.getDescription()==null){
            resp.sendError(400, "Description is a required field");
        }

        boolean successfulCreation = reimbursementDAO.create(newReimbursement);
        System.out.println(newReimbursement.getDescription());
        System.out.println(newReimbursement.getAmount());
        System.out.println(successfulCreation);

        // respond to the client appropriately (HttpServletResponse)
        if(successfulCreation){
            //redirect to either submission request page or manager view all submission page
//            resp.setStatus(201);
            resp.sendRedirect("/ExpenseReimbursementSystem/submission-confirmation.html");
        }

    }
}


