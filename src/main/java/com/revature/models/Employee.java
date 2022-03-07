package com.revature.models;

import java.util.Objects;

public class Employee {

    private int employeeId;
    private String username;
    private String password;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee() {
        super();
    }

    public Employee(String username, String password) {
        super();
        this.username = username;
        this.password = password;

    }

    public Employee(int employeeId, String username, String password) {
        super();
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
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
        return Objects.hash(employeeId, username, password);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

