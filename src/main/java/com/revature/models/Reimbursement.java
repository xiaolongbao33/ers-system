package com.revature.models;


import java.time.LocalDate;
import java.util.Objects;

public class Reimbursement {

    // TODO: Define Reimbursement Model
    private int reimbursementId;
    private String reimbursementDesc;
    private double reimbursementAmount;
    private LocalDate dateRequested;
    private String reimbursementStatus;

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public String getReimbursementDesc() {
        return reimbursementDesc;
    }

    public void setReimbursementDesc(String reimbursementDesc) {
        this.reimbursementDesc = reimbursementDesc;
    }

    public double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(int reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    public Reimbursement(int reimbursementId, String iphone, double v, LocalDate of, String pending) {
        super();
    }

    public Reimbursement(int reimbursementId, String reimbursementDesc, int reimbursementAmount, LocalDate dateRequested, String reimbursementStatus) {
        super();
        this.reimbursementId = reimbursementId;
        this.reimbursementDesc = reimbursementDesc;
        this.reimbursementAmount = reimbursementAmount;
        this.dateRequested = dateRequested;
        this.reimbursementStatus = reimbursementStatus;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return employee == employee.employeeId && Objects.equals(username, employee.username) && Objects.equals(password, employee.password);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursementId, reimbursementDesc, reimbursementAmount, dateRequested, reimbursementStatus);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementDesc='" + reimbursementDesc + '\'' +
                ", reimbursementAmount='" + reimbursementAmount + '\'' +
                ", dateRequested,='" + dateRequested + '\'' +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                '}';
    }

}


