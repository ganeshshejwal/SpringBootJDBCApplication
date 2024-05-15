package com.webapplication.employeeProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.employeeProject.dao.EmpRepository;
import com.webapplication.employeeProject.model.Employee;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;

    public Employee savemployee(Employee emp) throws Exception{
        return empRepository.saveEmployee(emp);
    }
    public Employee getEmployee(int id) throws Exception{
        return empRepository.getEmployee(id);
    }
    public Employee updatEmployee(Employee emp) throws Exception{
        return empRepository.updateEmployee(emp);
    }
    public void deleteEmployee(int id) throws Exception{
        empRepository.deleteEmployee(id);
    }

    
}
