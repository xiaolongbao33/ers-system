package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {

    @Override
    public List<Reimbursement> getAllReimbursements() throws SQLException {
        try(Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();){

                // execute statement, get a resultset in return
                ResultSet resultSet = statement.executeQuery("select * from reimbursement");

                // creating list to store reimbursements when I get them from the db
                List<Reimbursement> reimbursements = new ArrayList<>();

                while(resultSet.next()){
                    // get all data from the row
                    int id = resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    String status = resultSet.getString("status");
                    Double amount = resultSet.getDouble("amount");
                    LocalDate date = resultSet.getObject("date", LocalDate.class);
                    Reimbursement r = new Reimbursement(id, description, status, amount, date);

                    // add customer objects to a list
                    reimbursements.add(r);
                }
                System.out.println(reimbursements);
                // return list
                return reimbursements;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createReimbursement(Reimbursement reimbursement) {
        return false;
    }

    @Override
    public boolean create(Reimbursement reimbursement) {
        // use customer object to create valid SQL statement
        // insert into customer values (); this statement is parameterized so we want to use a PS
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("insert into reimbursement values (default, ?, ?, ?, ?)");
//            ps.setInt(1, reimbursement.getReimbursementId());
//            ps.setInt(1, reimbursement.getId());
            // String description, double amount, LocalDate date, String status
            ps.setString(1, reimbursement.getDescription());
            ps.setString(2, reimbursement.getStatus());
            ps.setDouble(3, reimbursement.getAmount());
            ps.setObject(4, reimbursement.getDate());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // provide that SQL to JDBC to execute in our DB
        return false;
    }

    @Override
    public boolean updateReimbursement(Reimbursement reimbursement) {
        try(Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement ps = connection.prepareStatement("update REIMBURSEMENT set STATUS = ? where ID = ?");

            ps.setString(1, reimbursement.getStatus());
            ps.setInt(2, reimbursement.getId());

            ps.executeUpdate();
//            connection.setAutoCommit(false);
//            connection.commit();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


//    @Override
//    public List<Reimbursement> updateReimbursementPostman(int id, String status) {
//
//        try(Connection connection = ConnectionUtil.getConnection()){
//            PreparedStatement ps = connection.prepareStatement("UPDATE reimbursement SET STATUS = ? WHERE id = ?");
//            // UPDATE Student SET NAME = 'PRATIK' WHERE Age = 20;
////        PreparedStatement ps = null;
////
//        ps.setInt(1, id);
//        ps.setString(2, status);
//
//        ps.executeUpdate();
//
////            return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

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



}





