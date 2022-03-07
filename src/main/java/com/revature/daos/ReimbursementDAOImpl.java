package com.revature.daos;

import com.revature.models.Employee;
import com.revature.daos.ReimbursementDao;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {
    @Override
    public void create(Employee employee) {
        // use customer object to create valid SQL statement
        // insert into customer values (); this statement is parameterized so we want to use a PS
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into customer values (default, ?, ?, ?)");
            ps.setInt(1,employee.getEmployeeId());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // provide that SQL to JDBC to execute in our DB

    }

    @Override
    public List<Employee> getAllCustomerData() {
        return null;
    }
}





