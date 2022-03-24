package com.revature.servlets;


import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateStatusServlet extends HttpServlet {

    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Reimbursement reimbursement = new Reimbursement(3,"approved");
        reimbursementDAO.updateReimbursement(reimbursement);

        //        if (successfulCreation) {
//            System.out.println("Reimbursement " + reimbursement.getId() + " updated to " + reimbursement.getStatus());
//        }

    }


}
