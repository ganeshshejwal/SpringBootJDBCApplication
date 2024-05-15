package com.webapplication.employeeProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapplication.employeeProject.model.Employee;

@Repository
public class EmpRepository {
    @Autowired
    DataSource dbconnection;
    public Employee saveEmployee(Employee emp) throws Exception{
        Connection con = dbconnection.getConnection();
        PreparedStatement ptmt = con.prepareStatement("insert into employee values(?,?,?)");
        ptmt.setInt(1, emp.getId());
        ptmt.setString(2, emp.getName());
        ptmt.setInt(3, emp.getSalary());
        ptmt.executeUpdate();
        ptmt.close();
        con.close();

        return emp;
    }
    public Employee getEmployee(int id) throws Exception{
        Employee emp=null;
        Connection con = dbconnection.getConnection();
        PreparedStatement ptmt = con.prepareStatement("select * from employee where id=?");
        ptmt.setInt(1, id);
        ResultSet res = ptmt.executeQuery();
        if(res.next()){
            int empid=res.getInt("id");
            String empname=res.getString("name");
            int empsal= res.getInt("salary");
            emp = new Employee(empid,empname,empsal);
        }
        ptmt.close();
        con.close();
        return emp;

    }
    public Employee updateEmployee(Employee emp) throws Exception{
        Connection con = dbconnection.getConnection();
        PreparedStatement ptmt = con.prepareStatement("update employee set name=?,salary=? where id=?");
        ptmt.setString(1, emp.getName());
        ptmt.setInt(2, emp.getSalary());
        ptmt.setInt(3, emp.getId());
        ptmt.executeUpdate();
        ptmt.close();
        con.close();
        return emp;
    }
    public void deleteEmployee(int id) throws Exception{
        Connection con = dbconnection.getConnection();
        PreparedStatement ptmt = con.prepareStatement("delete from employee where id=?");
        ptmt.setInt(1, id);
        ptmt.executeUpdate();
        ptmt.close();
        con.close();
    }
}
