package com.revature.daos;

import com.revature.models.Employee;
import com.revature.models.UserRole;

import java.util.List;

public interface EmployeeDAO {
    /*
       required user stories
    */
    public boolean getEmployeeByUsernameAndPassword(String newUsername, String newPassword, UserRole role);

    public boolean create(Employee employee);

    /*
        bonus user stories
     */
    public List<Employee> getAllEmployees();
    public List<Employee> getGeneralEmployees();
    public List<Employee> getManagerEmployees();

}





