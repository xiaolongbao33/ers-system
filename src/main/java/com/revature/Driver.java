package com.revature;

import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;
import com.revature.models.Employee;

public class Driver {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee c = new Employee("Kelly", "kellypass");
        employeeDAO.create(c);
    }
}

