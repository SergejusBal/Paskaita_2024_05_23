import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Employee;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestgetEmployeeInfo {
    Developer developerJAVA;
    Developer developerC_CHARP;
    Developer developer_C_PLUS_PLUS;
    Manager managerBigTeam;
    Manager managerSmallTeam;
    EmployeeService employeeService;

    @BeforeEach
    public void paruoštiObjektus() {

        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        developerC_CHARP = new Developer("Mantas", 34, new BigDecimal(5000), ProgrammingLanguage.C_SHARP);
        developer_C_PLUS_PLUS = new Developer("Janas", 44, new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS);
        managerBigTeam = new Manager("Jokūbas", 54, new BigDecimal(3000), 14);
        managerSmallTeam = new Manager("Aistė", 34, new BigDecimal(2000), 9);

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testGetEmplouyeeInfoForDeveloperJAVA() {

        //Arrange
        String vardas = developerJAVA.getName();
        int amzius = developerJAVA.getAge();
        BigDecimal atlyginimas = developerJAVA.getSalary();

        String CorrectResult = "Name: " + developerJAVA.getName() + ", Age: " + developerJAVA.getAge() + ", Salary: " + developerJAVA.getSalary().toString();
        //Assert
        String result = employeeService.getEmployeeInfo(developerJAVA);
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, developerJAVA.getName());
        assertEquals(amzius, developerJAVA.getAge());
        assertEquals(atlyginimas, developerJAVA.getSalary());
    }
    @Test
    public void testGetEmplouyeeInfoForDeveloperC_SHARP() {

        //Arrange
        String vardas = developerC_CHARP.getName();
        int amzius = developerC_CHARP.getAge();
        BigDecimal atlyginimas = developerC_CHARP.getSalary();

        String CorrectResult = "Name: " + developerC_CHARP.getName() + ", Age: " + developerC_CHARP.getAge() + ", Salary: " + developerC_CHARP.getSalary().toString();
        //Assert
        String result = employeeService.getEmployeeInfo(developerC_CHARP);
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, developerC_CHARP.getName());
        assertEquals(amzius, developerC_CHARP.getAge());
        assertEquals(atlyginimas, developerC_CHARP.getSalary());
    }
    @Test
    public void testGetEmplouyeeInfoForDeveloperC_PLUS_PLUS() {

        //Arrange
        String vardas = developer_C_PLUS_PLUS.getName();
        int amzius = developer_C_PLUS_PLUS.getAge();
        BigDecimal atlyginimas = developer_C_PLUS_PLUS.getSalary();

        String CorrectResult = "Name: " + developer_C_PLUS_PLUS.getName() + ", Age: " + developer_C_PLUS_PLUS.getAge() + ", Salary: " + developer_C_PLUS_PLUS.getSalary().toString();
        //Assert
        String result = employeeService.getEmployeeInfo(developer_C_PLUS_PLUS);
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, developer_C_PLUS_PLUS.getName());
        assertEquals(amzius, developer_C_PLUS_PLUS.getAge());
        assertEquals(atlyginimas, developer_C_PLUS_PLUS.getSalary());
    }
    @Test
    public void testGetEmplouyeeInfoForManagerBigTeam() {

        //Arrange
        String vardas = managerBigTeam.getName();
        int amzius = managerBigTeam.getAge();
        BigDecimal atlyginimas = managerBigTeam.getSalary();


        String CorrectResult = "Name: " + managerBigTeam.getName() + ", Age: " + managerBigTeam.getAge() + ", Salary: " + managerBigTeam.getSalary().toString();
        //Assert
        String result = employeeService.getEmployeeInfo(managerBigTeam);
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, managerBigTeam.getName());
        assertEquals(amzius, managerBigTeam.getAge());
        assertEquals(atlyginimas, managerBigTeam.getSalary());
    }

    @Test
    public void testGetEmplouyeeInfoForManagerSmallTeam() {

        //Arrange
        String vardas = managerSmallTeam.getName();
        int amzius = managerSmallTeam.getAge();
        BigDecimal atlyginimas = managerSmallTeam.getSalary();

        String CorrectResult = "Name: " + managerSmallTeam.getName() + ", Age: " + managerSmallTeam.getAge() + ", Salary: " + managerSmallTeam.getSalary().toString();
        //Assert
        String result = employeeService.getEmployeeInfo(managerSmallTeam);
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, managerSmallTeam.getName());
        assertEquals(amzius, managerSmallTeam.getAge());
        assertEquals(atlyginimas, managerSmallTeam.getSalary());
    }
}
