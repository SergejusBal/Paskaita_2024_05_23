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

public class TestperformDuties {

    //Arrange
    Developer developerJAVA;
    Developer developerC_CHARP;
    Developer developer_C_PLUS_PLUS;
    Manager managerBigTeam;
    Manager managerSmallTeam;
    EmployeeService employeeService;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void paruoštiObjektus() {

     //   employeeList = new ArrayList<>();
        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        developerC_CHARP = new Developer("Mantas", 34, new BigDecimal(5000), ProgrammingLanguage.C_SHARP);
        developer_C_PLUS_PLUS = new Developer("Janas", 44, new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS);
        managerBigTeam = new Manager("Jokūbas", 54, new BigDecimal(3000), 14);
        managerSmallTeam = new Manager("Aistė", 34, new BigDecimal(2000), 9);

        System.setOut(new PrintStream(outputStreamCaptor));


        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testperformDutiesForDeveloperJAVA() {

        //Arrange
        String vardas = developerJAVA.getName();
        int amzius = developerJAVA.getAge();
        BigDecimal atlyginimas = developerJAVA.getSalary();
        //Assert
        employeeService.performDuties(developerJAVA);
        //Act
        assertEquals(   "Kalba: " + developerJAVA.getProgrammingLanguage().toString() +
                                 " * Alga: " + developerJAVA.getSalary()+ "\r\n"                                ,outputStreamCaptor.toString());
        assertEquals(vardas, developerJAVA.getName());
        assertEquals(amzius, developerJAVA.getAge());
        assertEquals(atlyginimas, developerJAVA.getSalary());
    }

    @Test
    public void testperformDutiesForDeveloperC_CHARP() {

        //Arrange
        String vardas = developerC_CHARP.getName();
        int amzius = developerC_CHARP.getAge();
        BigDecimal atlyginimas = developerC_CHARP.getSalary();
        //Assert
        employeeService.performDuties(developerC_CHARP);
        //Act
        assertEquals(   "Kalba: " + developerC_CHARP.getProgrammingLanguage().toString() +
                                " * Alga: " + developerC_CHARP.getSalary()+ "\r\n"                               ,outputStreamCaptor.toString());

        assertEquals(vardas, developerC_CHARP.getName());
        assertEquals(amzius, developerC_CHARP.getAge());
        assertEquals(atlyginimas, developerC_CHARP.getSalary());
    }

    @Test
    public void testperformDutiesForDeveloperC_PLUS_PLUS() {

        //Arrange
        String vardas = developer_C_PLUS_PLUS.getName();
        int amzius = developer_C_PLUS_PLUS.getAge();
        BigDecimal atlyginimas = developer_C_PLUS_PLUS.getSalary();
        //Assert
        employeeService.performDuties(developer_C_PLUS_PLUS);
        //Act
        assertEquals(   "Kalba: " + developer_C_PLUS_PLUS.getProgrammingLanguage().toString() +
                " * Alga: " + developer_C_PLUS_PLUS.getSalary()+ "\r\n"                               ,outputStreamCaptor.toString());

        assertEquals(vardas, developer_C_PLUS_PLUS.getName());
        assertEquals(amzius, developer_C_PLUS_PLUS.getAge());
        assertEquals(atlyginimas, developer_C_PLUS_PLUS.getSalary());
    }

    @Test
    public void testperformDutiesForManagerBigTeam() {

        //Arrange
        String vardas = managerBigTeam.getName();
        int amzius = managerBigTeam.getAge();
        BigDecimal atlyginimas = managerBigTeam.getSalary();
        //Assert
        employeeService.performDuties(managerBigTeam);
        //Act
        assertEquals("Valdo didelę komandą!\r\n", outputStreamCaptor.toString());

        assertEquals(vardas, managerBigTeam.getName());
        assertEquals(amzius, managerBigTeam.getAge());
        assertEquals(atlyginimas, managerBigTeam.getSalary());
    }

    @Test
    public void testperformDutiesForManagerSmallTeam() {

        //Arrange
        String vardas = managerSmallTeam.getName();
        int amzius = managerSmallTeam.getAge();
        BigDecimal atlyginimas = managerSmallTeam.getSalary();
        //Assert
        employeeService.performDuties(managerSmallTeam);
        //Act
        assertEquals("Valdo mažą komandą!\r\n", outputStreamCaptor.toString());

        assertEquals(vardas, managerSmallTeam.getName());
        assertEquals(amzius, managerSmallTeam.getAge());
        assertEquals(atlyginimas, managerSmallTeam.getSalary());
    }

}
