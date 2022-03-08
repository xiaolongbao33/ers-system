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
//        CustomerDAO customerDAO = new CustomerDAOImpl();
//        Customer c = new Customer("Doug", "Bradley", "dbrad@gmail.com", LocalDate.of(1991,11,19));
//        customerDAO.create(c);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee c = new Employee("Kelly", "kellypass");
        employeeDAO.create(c);

//        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
//        Reimbursement r = new Reimbursement(3, "iphone", 100.00, LocalDate.of(1991,11,19), "pending");
//        reimbursementDAO.create(r);
    }
}

