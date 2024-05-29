package com.webapplication.employeeProject.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void saveEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.saveEmployee(expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeService.saveEmployee(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.getEmployee(1)).thenReturn(expectedResult);
        Employee actualResult = employeeService.getEmployee(1);
        assertEquals(expectedResult, actualResult);
    }

    @Test 
    public void getAllEmployeesTest(){
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(new Employee(1, "Ganesh",95000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(2,"Saurabh",78000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(3, "Akash", 90000,Timestamp.valueOf("2023-06-01 01:02:23")));
        when(employeeDao.getAllEmployees()).thenReturn(expectedResult);
        List<Employee> actualResult = employeeService.getAllEmployees();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.updateEmployee(1,expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeService.updateEmployee(1, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteEmployeeTest(){
        int employeeId = 1;
        employeeDao.deleteEmployee(employeeId);
        verify(employeeDao, times(1)).deleteEmployee(employeeId);
    }

}
