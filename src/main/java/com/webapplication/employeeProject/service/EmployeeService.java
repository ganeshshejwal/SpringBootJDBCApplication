package com.webapplication.employeeProject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public Employee saveEmployee(Employee employee){
        return employeeDao.saveEmployee(employee);
    }

    public Employee getEmployee(int id){
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public Employee updatEmployee(Employee employee){
        return employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }

    
}
