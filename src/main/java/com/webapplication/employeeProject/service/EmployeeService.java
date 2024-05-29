package com.webapplication.employeeProject.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee saveEmployee(Employee employee){
        employee.setId(UUID.randomUUID());
        employee.setJoindate(new Timestamp(System.currentTimeMillis()));
        return employeeDao.saveEmployee(employee);
    }

    public Employee getEmployee(UUID id){
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public Employee updateEmployee(UUID id,Employee employee1){
        employee1.setId(id);
        Employee employee2 = employeeDao.getEmployee(id);
        employee1.setJoindate(employee2.getJoindate());
        return employeeDao.updateEmployee(id,employee1);
    }

    public void deleteEmployee(UUID id){
        employeeDao.deleteEmployee(id);
    }
}
