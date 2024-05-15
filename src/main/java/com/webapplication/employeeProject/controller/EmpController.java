package com.webapplication.employeeProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmpService;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee emp) throws Exception {
        return empService.savemployee(emp);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable("id") int id) throws Exception{
        return empService.getEmployee(id);
    }

    @PutMapping("/update/{id}")
    public Employee updatEmployee(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("salary") int sal) throws Exception{
        return empService.updatEmployee(new Employee(id,name,sal));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) throws Exception{
        empService.deleteEmployee(id);
        return "data deleted sucessfully";
    }
}
