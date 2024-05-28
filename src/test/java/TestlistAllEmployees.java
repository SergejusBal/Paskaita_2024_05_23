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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestlistAllEmployees {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    List<Employee> employeeList;
    EmployeeService employeeService = new EmployeeServiceImpl();


    @BeforeEach
    public void paruoštiObjektus() {
        //Arrange
        System.setOut(new PrintStream(outputStreamCaptor));

        employeeList = new ArrayList<>();

    }
    //MethodName_StateUnderTest_ExpectedBehavior
    @Test
    public void listAllEmployees_listwithThreeCases_returnPrintList() {

        //Arrange
        Developer developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        Developer developer_C_PLUS_PLUS = new Developer("Janas", 44, new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS);
        Manager managerBigTeam = new Manager("Jokūbas", 54, new BigDecimal(3000), 14);

        employeeList.add(developerJAVA);
        employeeList.add(developer_C_PLUS_PLUS);
        employeeList.add(managerBigTeam);

        String Expected =   developerJAVA + " " + developerJAVA.getProgrammingLanguage() + "\r\n" +
                            developer_C_PLUS_PLUS + " " + developer_C_PLUS_PLUS.getProgrammingLanguage() + "\r\n" +
                            managerBigTeam + " " + managerBigTeam.getTeamSize() + "\r\n";


        //Assert
        employeeService.listAllEmployees(employeeList);
        //Act
        assertEquals(Expected, outputStreamCaptor.toString());



    }
}
