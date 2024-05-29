package com.webapplication.employeeProject.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        logger.info("Data Saved Successfully");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable("id") UUID id){
        logger.info("Data Fetched Successfully Using Id");
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAll(){
        logger.info("Data Fetched Successfully");
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable("id") UUID id, @RequestBody Employee employee){
        logger.info("Data Updated Successfully");
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id){
        logger.info("Data Deleted Successfully");
        employeeService.deleteEmployee(id);
        return "Data deleted sucessfully";
    }
}
