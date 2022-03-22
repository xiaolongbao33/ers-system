package com.revature.daos;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public boolean getEmployeeByUsernameAndPassword(String username, String password) {
        // create a connection to the database (using try with resources bc connection is Autocloseable)
        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from employee where username=? and password=?");){

            ps.setString(1, username);
            ps.setString(2, password);

            // execute statement, get a result set in return
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean create(Employee employee) {
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

        return false;
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






