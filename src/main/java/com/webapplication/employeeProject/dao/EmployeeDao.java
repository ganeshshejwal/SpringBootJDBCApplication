package com.webapplication.employeeProject.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            PreparedStatement ptmt = con.prepareStatement("INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)");
            ){
            ptmt.setInt(1, employee.getId());
            ptmt.setString(2, employee.getName());
            ptmt.setInt(3, employee.getSalary());
            ptmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    public Employee getEmployee(int id){
        Employee employee=null;
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("SELECT * FROM employee WHERE id=?")
            ){
            ptmt.setInt(1, id);
            ResultSet resultSet = ptmt.executeQuery();
            while(resultSet.next()){
               int employeeId=resultSet.getInt(1);
               String employeeName=resultSet.getString(2);
               int employeeSal= resultSet.getInt(3);
               employee = new Employee(employeeId,employeeName,employeeSal);
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
                int employeeId=resultSet.getInt(1);
                String employeeName =resultSet.getString(2);
                int employeeSalary=resultSet.getInt(3);
                employees.add(new Employee(employeeId,employeeName,employeeSalary));
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return employees;
    }

    public Employee updateEmployee(int id,Employee employee){
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("UPDATE EMPLOYEE SET name =?,salary=? WHERE id=?");
            ){
            ptmt.setString(1, employee.getName());
            ptmt.setInt(2, employee.getSalary());
            ptmt.setInt(3,id);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void deleteEmployee(int id){
        try(Connection con = dbconnection.getConnection();
            PreparedStatement ptmt = con.prepareStatement("DELETE FROM employee WHERE id=?");
            ){
            ptmt.execute(); 
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
