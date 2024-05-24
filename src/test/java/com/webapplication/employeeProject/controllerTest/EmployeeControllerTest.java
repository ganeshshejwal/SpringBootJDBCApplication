package com.webapplication.employeeProject.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.webapplication.employeeProject.controller.EmployeeController;
import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    public void saveEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000);
        when(employeeService.saveEmployee(expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeController.save(expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000);
        when(employeeService.getEmployee(1)).thenReturn(expectedResult);
        Employee actualResult = employeeController.get(1);
        assertEquals(expectedResult, actualResult);
    }

    @Test 
    public void getAllEmployeesTest(){
        List<Employee> expectedResult = new ArrayList<>();
        expectedResult.add(new Employee(1, "Ganesh",95000));
        expectedResult.add(new Employee(2,"Saurabh",78000));
        expectedResult.add(new Employee(3, "Akash", 90000));
        when(employeeService.getAllEmployees()).thenReturn(expectedResult);
        List<Employee> actualResult = employeeController.getAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateEmployeeTest(){
        Employee expectedResult = new Employee(1,"Ganesh",90000);
        when(employeeService.updateEmployee(1,expectedResult)).thenReturn(expectedResult);
        Employee actualResult = employeeController.update(1, expectedResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteEmployeeTest(){
        int employeeId = 1;
        employeeController.delete(employeeId);
        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }


    
}
