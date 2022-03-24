package com.revature.daos;

import com.revature.models.Reimbursement;

import java.sql.SQLException;
import java.util.List;

public interface ReimbursementDAO {

    /*
        required user stories
     */
    public List<Reimbursement> getAllReimbursements() throws SQLException;
    public boolean createReimbursement(Reimbursement reimbursement);
    public boolean create(Reimbursement reimbursement);

//    public List<Reimbursement> updateReimbursementPostman(int id, String status);

    // these can be replaced with a single "getReimbursementsByStatus" method
    public List<Reimbursement> getPendingReimbursements();
    public List<Reimbursement> getApprovedReimbursements();
    public List<Reimbursement> getDeniedReimbursements();

    /*
        bonus user stories
     */
    public List<Reimbursement> getReimbursementsByEmployee(int employeeId);
    public boolean updateReimbursement(Reimbursement reimbursement);

}
