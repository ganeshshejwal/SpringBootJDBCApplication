package com.webapplication.employeeProject.daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.saveEmployee(expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.saveEmployee(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getEmployeeTest(){
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.getEmployee(id)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.getEmployee(id);
        assertEquals(expectedResult, actualResult);
    }
    @Test 
    public void getAllEmployeesTest(){
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(new Employee(UUID.randomUUID(), "Ganesh",95000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(UUID.randomUUID(),"Saurabh",78000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(UUID.randomUUID(), "Akash", 90000,Timestamp.valueOf("2023-06-01 01:02:23")));
        when(employeeDao.getAllEmployees()).thenReturn(expectedResult);
        List<Employee> actualResult = employeeDao.getAllEmployees();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmployeeTest(){
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeDao.updateEmployee(id,expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeDao.updateEmployee(id, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteEmployeeTest(){
        UUID employeeId=UUID.randomUUID();
        employeeDao.deleteEmployee(employeeId);
        verify(employeeDao, times(1)).deleteEmployee(employeeId);
    }

}
