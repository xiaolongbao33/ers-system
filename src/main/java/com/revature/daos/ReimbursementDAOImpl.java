package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {

    @Override
    public List<Reimbursement> getAllReimbursements() {
        return null;
    }

    @Override
    public boolean createReimbursement(Reimbursement reimbursement) {
        return false;
    }

    @Override
    public void create(Reimbursement reimbursement) {
        // use customer object to create valid SQL statement
        // insert into customer values (); this statement is parameterized so we want to use a PS
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into reimbursement values (default, ?, ?, ?, ?)");
            ps.setInt(1, reimbursement.getReimbursementId());
            ps.setString(2, reimbursement.getReimbursementDesc());
            ps.setDouble(3, reimbursement.getReimbursementAmount());
            ps.setString(4, reimbursement.getReimbursementStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // provide that SQL to JDBC to execute in our DB

    }

    @Override
    public List<Reimbursement> getPendingReimbursements() {
        return null;
    }

    @Override
    public List<Reimbursement> getApprovedReimbursements() {
        return null;
    }

    @Override
    public List<Reimbursement> getDeniedReimbursements() {
        return null;
    }

    @Override
    public List<Reimbursement> getReimbursementsByEmployee(int employeeId) {
        return null;
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement) {
        return false;
    }

}





