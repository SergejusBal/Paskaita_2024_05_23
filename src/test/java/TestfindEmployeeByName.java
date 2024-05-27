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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestfindEmployeeByName {

    //Arrange
    List<Employee> employeeList;
    Developer developerJAVA;
    Developer developerC_CHARP;
    Developer developer_C_PLUS_PLUS;
    Manager managerBigTeam;
    Manager managerSmallTeam;
    EmployeeService employeeService;


    @BeforeEach
    public void paruoštiObjektus() {

        employeeList = new ArrayList<>();
        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        developerC_CHARP = new Developer("Mantas", 34, new BigDecimal(5000), ProgrammingLanguage.C_SHARP);
        developer_C_PLUS_PLUS = new Developer("Janas", 44, new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS);
        managerBigTeam = new Manager("Jokūbas", 54, new BigDecimal(3000), 14);
        managerSmallTeam = new Manager("Aistė", 34, new BigDecimal(2000), 9);


        employeeList.add(developerJAVA);
        employeeList.add(developerC_CHARP);
        employeeList.add(developer_C_PLUS_PLUS);
        employeeList.add(managerBigTeam);
        employeeList.add(managerSmallTeam);

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testFindEmployeeByName() {

        String CorrectResult = "Jonas";
        //Assert
        Employee result = employeeService.findEmployeeByName(employeeList,CorrectResult);
        //Act
        assertEquals(CorrectResult,result.getName());
    }

    @Test
    public void testFindEmployeeByNameNullCase() {

        String CorrectResult = null;
        //Assert
        Employee result = employeeService.findEmployeeByName(employeeList,CorrectResult);
        //Act
        assertEquals(CorrectResult,result);
    }
    @Test
    public void testFindEmployeeByNameNoEmployeeCaseNull() {

        String CorrectResult = "sdsgsasfegtsdbafgfgafsdg";
        //Assert
        Employee result = employeeService.findEmployeeByName(employeeList,CorrectResult);
        //Act
        assertEquals(null,result);
    }


}
