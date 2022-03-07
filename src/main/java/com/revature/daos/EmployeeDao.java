package com.revature.daos;

import com.revature.models.Employee;
import java.util.List;

public interface EmployeeDao {

    /*
        required user stories
     */
    public Employee getEmployeeByUsernameAndPassword(String username, String password);

    /*
        bonus user stories
     */
    public List<Employee> getAllEmployees();
    public List<Employee> getGeneralEmployees();
    public List<Employee> getManagerEmployees();

}





