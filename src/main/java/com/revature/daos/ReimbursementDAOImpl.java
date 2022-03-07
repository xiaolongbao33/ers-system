package com.revature.daos;

import com.revature.models.Employee;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {
    @Override
    public void create(Reimbursement reimbursement) {
        // use customer object to create valid SQL statement
        // insert into customer values (); this statement is parameterized so we want to use a PS
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into reimbursement values (default, ?, ?, ?, ?)");
            ps.setInt(1, reimbursement.getReimbursementId());
            ps.setString(2, reimbursement.getReimbursementDesc());
            ps.setInt(3, reimbursement.getReimbursementAmount());
            ps.setString(4, reimbursement.getReimbursementStatus());

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





