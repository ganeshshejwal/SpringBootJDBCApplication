package com.webapplication.employeeProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable("id") int id){
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("salary") int sal){
        return employeeService.updatEmployee(new Employee(id,name,sal));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return "data deleted sucessfully";
    }
}
