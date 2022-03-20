package com.revature.daos;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee getEmployeeByUsernameAndPassword(String username, String password) {
        // get username and password from HTML form
        // compare username and password
        // redirect manager to 'all-reimbursement' page
        // redirect employee to 'submit-reimbursement' page
        // create a statement (set params if we need to)
        // select * from customer

        return null;
    }

    @Override
    public void create(Employee employee) {
        // use customer object to create valid SQL statement
        // insert into customer values (); this statement is parameterized, so we want to use a PS
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into employee values (default, ?, ?)");
//            ps.setInt(1,employee.getEmployeeId());
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // provide that SQL to JDBC to execute in our DB

    }


    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public List<Employee> getGeneralEmployees() {
        return null;
    }

    @Override
    public List<Employee> getManagerEmployees() {
        return null;
    }

}






