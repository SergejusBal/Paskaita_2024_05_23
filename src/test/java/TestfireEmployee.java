import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Employee;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestfireEmployee {
    //Arrange
    List<Employee> employeeList;
    EmployeeService employeeService = new EmployeeServiceImpl();

    @BeforeEach
    public void paruoštiObjektus() {

        employeeList = ((EmployeeServiceImpl)employeeService).getEmployeeList();
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testFireEmployee() {

        String CorrectResult = "Jonas";
        Employee foundEmployee = employeeService.findEmployeeByName(employeeList,"Jonas");
        //Asser&Act
        employeeService.fireEmployee(foundEmployee);
        assertEquals(CorrectResult,foundEmployee.getName());

        Employee result = employeeService.findEmployeeByName(employeeList,"Jonas");
        assertTrue(employeeList.contains(result));
    }

    @Test
    public void testFireEmployeeByNameNullCase() {

        //Asser&Act
        try{
            employeeService.fireEmployee(null);
        } catch (NullPointerException e){
            fail();
        }

    }


}
