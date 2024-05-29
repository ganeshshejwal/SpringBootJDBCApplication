package com.webapplication.employeeProject.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;

public class EmployeeDaoTest {

    @Mock
    private EmployeeDao employeeDao;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.saveEmployee(expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.saveEmployee(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.getEmployee(1)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.getEmployee(1);
        assertEquals(expectedResult, actualResult);
    }
    @Test 
    public void getAllEmployeesTest(){
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(new Employee(1, "Ganesh",95000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(2,"Saurabh",78000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(3, "Akash", 90000,Timestamp.valueOf("2023-06-01 01:02:23")));
        when(employeeDao.getAllEmployees()).thenReturn(expectedResult);
        List<Employee> actualResult = employeeDao.getAllEmployees();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.updateEmployee(1,expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.updateEmployee(1, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteEmployeeTest(){
        int employeeId = 1;
        employeeDao.deleteEmployee(employeeId);
        verify(employeeDao, times(1)).deleteEmployee(employeeId);
    }

}
