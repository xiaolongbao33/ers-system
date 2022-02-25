package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDao {

    /*
        required user stories
     */
    public List<Reimbursement> getAllReimbursements();
    public boolean createReimbursement(Reimbursement reimbursement);

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
