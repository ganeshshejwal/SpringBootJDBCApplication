package com.webapplication.employeeProject.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.webapplication.employeeProject.model.Employee;

@Repository
public class EmployeeDao {

    @Autowired
    DataSource dbconnection;

    public Employee saveEmployee(Employee employee){
        try(Connection con = dbconnection.getConnection();
            Statement  stmt = con.createStatement();
            ){
            String query = "insert into employee (id, name, salary) values (" + employee.getId() + ", '" + employee.getName() + "', " + employee.getSalary() + ")";
            stmt.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    public Employee getEmployee(int id){
        Employee employee=null;
        try(Connection con = dbconnection.getConnection();
            Statement  stmt = con.createStatement();
            ){
            String query="select * from employee where id="+id;
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
               int employeeid=resultSet.getInt("id");
               String employeename=resultSet.getString("name");
               int employeesal= resultSet.getInt("salary");
               employee = new Employee(employeeid,employeename,employeesal);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees=new ArrayList<>();
        try(Connection con = dbconnection.getConnection();
            Statement  stmt = con.createStatement();
            ){ 
            String query = "select * from employee";
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name =resultSet.getString("name");
                int salary=resultSet.getInt("salary");
                employees.add(new Employee(id,name,salary));
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return employees;
    }

    public Employee updateEmployee(Employee employee){
        try(Connection con = dbconnection.getConnection();
            Statement  stmt = con.createStatement();
            ){
                String query = "update employee set name ='"+employee.getName()+ "',salary="+employee.getSalary()+"where id="+employee.getId();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void deleteEmployee(int id){
        try(Connection con = dbconnection.getConnection();
            Statement  stmt = con.createStatement();
            ){
            String query="delete from employee where id="+id;
            stmt.execute(query); 
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
