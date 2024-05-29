package com.webapplication.employeeProject.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.webapplication.employeeProject.controller.EmployeeController;
import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;


@ExtendWith(MockitoExtension.class)

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    
    @Test
    public void saveEmployeeTest(){
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeService.saveEmployee(expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeController.save(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getEmployeeTest(){
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeService.getEmployee(id)).thenReturn(expectedResult);
        Employee actualResult = employeeController.get(id);
        assertEquals(expectedResult, actualResult);
    }

    @Test 
    public void getAllEmployeesTest(){
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(new Employee(UUID.randomUUID(), "Ganesh",95000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(UUID.randomUUID(),"Saurabh",78000,Timestamp.valueOf("2023-06-01 01:02:23")));
        expectedResult.add(new Employee(UUID.randomUUID(), "Akash", 90000,Timestamp.valueOf("2023-06-01 01:02:23")));
        when(employeeService.getAllEmployees()).thenReturn(expectedResult);
        List<Employee> actualResult = employeeController.getAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmployeeTest(){
        UUID id=UUID.randomUUID();
        Employee expectedResult = new Employee(id,"Ganesh",90000,Timestamp.valueOf("2023-06-01 01:02:23"));
        when(employeeService.updateEmployee(id,expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeController.update(id, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteEmployeeTest(){
        UUID employeeId = UUID.randomUUID();
        employeeController.delete(employeeId);
        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }


    
}
