package com.webapplication.employeeProject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.webapplication.employeeProject.model.Employee;

@Repository
public class EmployeeDao {

    @Autowired
    private DataSource dbconnection;

    
    public Employee saveEmployee(Employee employee){

        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("INSERT INTO employee (id, name, salary,joindate) VALUES (?, ?, ?, ?)");
            ){
            ptmt.setObject(1, employee.getId());
            ptmt.setString(2, employee.getName());
            ptmt.setInt(3, employee.getSalary());
            ptmt.setTimestamp(4, employee.getJoindate());
            ptmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    public Employee getEmployee(UUID id){
        Employee employee=null;
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("SELECT * FROM employee WHERE id=?")
            ){
            ptmt.setObject(1, id);
            ResultSet resultSet = ptmt.executeQuery();
            while(resultSet.next()){
               UUID employeeId=(UUID)resultSet.getObject(1);
               String employeeName=resultSet.getString(2);
               int employeeSal= resultSet.getInt(3);
               Timestamp employeeJoinDate=resultSet.getTimestamp(4);
               employee = new Employee(employeeId,employeeName,employeeSal,employeeJoinDate);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees=new ArrayList<>();
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("SELECT * FROM employee");
            ){ 
            ResultSet resultSet = ptmt.executeQuery();
            while(resultSet.next()){
                UUID employeeId=(UUID)resultSet.getObject(1);
                String employeeName =resultSet.getString(2);
                int employeeSalary=resultSet.getInt(3);
                Timestamp employeeJoinDate=resultSet.getTimestamp(4);
                employees.add(new Employee(employeeId,employeeName,employeeSalary,employeeJoinDate));
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return employees;
    }

    public Employee updateEmployee(UUID id,Employee employee){
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("UPDATE EMPLOYEE SET name =?,salary=? WHERE id=?");
            ){
            ptmt.setString(1, employee.getName());
            ptmt.setInt(2, employee.getSalary());
            ptmt.setObject(3,id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void deleteEmployee(UUID id){
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("DELETE FROM employee WHERE id=?");
            ){
                ptmt.setObject(1, id);
                ptmt.execute();
            } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
