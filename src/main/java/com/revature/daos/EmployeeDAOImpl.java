package com.revature.daos;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public boolean getEmployeeByUsernameAndPassword(String username, String password) {
        // create a connection to the database (using try with resources bc connection is Autocloseable)
        try (Connection connection = ConnectionUtil.getConnection();
             // create a statement (set params if we need to)
             // select * from customer
             Statement statement = connection.createStatement();) {

            // execute statement, get a resultset in return
            ResultSet resultSet = statement.executeQuery("select * from employee where username=? and password=?");

            // creating list to store my customers when I get them from the db
            List<Employee> employees = new ArrayList<>();
            Employee e = new Employee(username, password);

            // create customer objects with what we get from the database (resultset)
            // get all of the fields from the records in our db and use them to populate a customer object
            boolean success = false;
            while (resultSet.next()) {
                // get all data from the row
                String userName = resultSet.getString("username");
                String passWord = resultSet.getString("password");
                // add customer objects to a list
                employees.add(e);
                success = employees.equals(e);
            }

            // return list
            return success;

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






