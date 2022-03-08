package com.revature;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

import java.time.LocalDate;

public class Driver {

    public static void main(String[] args) {

//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        Employee c = new Employee("Kelly", "kellypass");
//        employeeDAO.create(c);

        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
        // new Reimbursement(reimb_id, reimb_desc, reimb_amount, reimb_date_req, reimb_status, )
        Reimbursement r = new Reimbursement("iphone", 100.00, LocalDate.of(1991,11,19), "pending");
        reimbursementDAO.create(r);
    }
}

