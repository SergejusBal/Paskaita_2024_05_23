import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesTpromoteEmployee {

    Developer developerJAVA;
    Developer developerC_CHARP;
    Developer developer_C_PLUS_PLUS;
    Manager managerBigTeam;
    Manager managerSmallTeam;
    static EmployeeService employeeService;

    final double MANAGER_PROMOTION_SIZE = 0.1;
    final double DEVELOPER_PROMOTION_SIZE_JAVA = 0.12;
    final double DEVELOPER_PROMOTION_SIZE_C_SHARP = 0.07;
    final double OTHERS = 0;


    @BeforeAll
    public static void paruoštiObjektus() {

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void promoteEmplyee_CaseJAVAdeveloper_SalaryCheck() {

        //Arrange
        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        BigDecimal expected = developerJAVA.getSalary().multiply(new BigDecimal(1 + DEVELOPER_PROMOTION_SIZE_JAVA));
        //Assert
        employeeService.promoteEmployee(developerJAVA);
        //Act
        assertEquals(expected, developerJAVA.getSalary());

    }

    @Test
    public void promoteEmplyee_developerC_CHARP_SalaryCheck() {

        //Arrange
        developerC_CHARP = new Developer("Mantas", 34, new BigDecimal(5000), ProgrammingLanguage.C_SHARP);
        BigDecimal expected = developerC_CHARP.getSalary().multiply(new BigDecimal(1 + DEVELOPER_PROMOTION_SIZE_C_SHARP));
        //Assert
        employeeService.promoteEmployee(developerC_CHARP);
        //Act
        assertEquals(expected, developerC_CHARP.getSalary());

    }
    @Test
    public void promoteEmplyee_developerC_PLUS_PLUS_SalaryCheck() {

        //Arrange
        developer_C_PLUS_PLUS = new Developer("Janas", 44, new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS);
        BigDecimal expected = developer_C_PLUS_PLUS.getSalary().multiply(new BigDecimal(1 + OTHERS));
        //Assert
        employeeService.promoteEmployee(developer_C_PLUS_PLUS);
        //Act
        assertEquals(expected, developer_C_PLUS_PLUS.getSalary());
    }

    @Test
    public void promoteEmplyee_managerBigTeam_SalaryCheck() {

        //Arrange
        managerBigTeam = new Manager("Jokūbas", 54, new BigDecimal(3000), 14);
        BigDecimal expected = managerBigTeam.getSalary().multiply(new BigDecimal(1 + MANAGER_PROMOTION_SIZE));
        //Assert
        employeeService.promoteEmployee(managerBigTeam);
        //Act
        assertEquals(expected, managerBigTeam.getSalary());
    }

    @Test
    public void promoteEmplyee_managerSmallTeam_SalaryCheck() {

        //Arrange
        managerSmallTeam = new Manager("Aistė", 34, new BigDecimal(2000), 9);
        BigDecimal expected = managerSmallTeam.getSalary().multiply(new BigDecimal(1 ));
        //Assert
        employeeService.promoteEmployee(managerSmallTeam);
        //Act
        assertEquals(expected, managerSmallTeam.getSalary());
    }




}