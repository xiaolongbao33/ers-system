package com.revature.models;

import java.time.LocalDate;
import java.util.Objects;

public class Reimbursement {

    // TODO: Define Reimbursement Model
    private int id;
    private String description;
    private double amount;
    private LocalDate date;
    private String status;

    public Reimbursement() {
        super();
    }

    public Reimbursement(int id, String description, String status, double amount, LocalDate date) {
        super();
        this.id = id;
        this.description = description;
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    public Reimbursement(String description, String status, double amount, LocalDate date) {
        super();
//        this.id = id;
        this.description = description;
        this.status = status;
        this.amount = amount;
        this.date = date;

    }

    public Reimbursement(int id, String status) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return Objects.hash(description, amount, date, status);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", date,='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}


