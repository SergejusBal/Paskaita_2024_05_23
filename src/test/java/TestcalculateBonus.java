import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestcalculateBonus {

    Developer developerJAVA;
    Developer developerC_CHARP;
    Developer developer_C_PLUS_PLUS;
    Manager managerBigTeam;
    Manager managerSmallTeam;
    EmployeeService employeeService;

    final double MANAGER_BONUS_SIZE = 0.1;
    final double DEVELOPER_BONUS_SIZE = 0.05;
    final double OTHER_BONUS_SIZE = 0.03;

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
    public void testCalculateBonusForDeveloperJAVA() {

        //Arrange
        String vardas = developerJAVA.getName();
        int amzius = developerJAVA.getAge();
        BigDecimal atlyginimas = developerJAVA.getSalary();

        //Vertė kuri turi būti
        double atsakymas = Double.parseDouble(atlyginimas.toString())*(DEVELOPER_BONUS_SIZE);
        //Assert
        double  paskaicuotasBonusas = employeeService.calculateBonus(developerJAVA);
        //Act
        assertEquals(paskaicuotasBonusas,atsakymas);

        assertEquals(vardas, developerJAVA.getName());
        assertEquals(amzius, developerJAVA.getAge());
        assertEquals(atlyginimas, developerJAVA.getSalary());
    }
    @Test
    public void testCalculateBonusForDeveloperC_SHARP() {
        
        //Arrange
        String vardas = developerC_CHARP.getName();
        int amzius = developerC_CHARP.getAge();
        BigDecimal atlyginimas = developerC_CHARP.getSalary();

        //Vertė kuri turi būti
        double atsakymas = Double.parseDouble(atlyginimas.toString())*DEVELOPER_BONUS_SIZE;
        //Assert
        double  paskaicuotasBonusas = employeeService.calculateBonus(developerC_CHARP);
        //Act
        assertEquals(paskaicuotasBonusas,atsakymas);

        assertEquals(vardas, developerC_CHARP.getName());
        assertEquals(amzius, developerC_CHARP.getAge());
        assertEquals(atlyginimas, developerC_CHARP.getSalary());
    }
    @Test    
    public void testCalculateBonusForDeveloperC_PLUS_PLUS() {

        //Arrange
        String vardas = developer_C_PLUS_PLUS.getName();
        int amzius = developer_C_PLUS_PLUS.getAge();
        BigDecimal atlyginimas = developer_C_PLUS_PLUS.getSalary();

        //Vertė kuri turi būti
        double atsakymas = Double.parseDouble(atlyginimas.toString())*DEVELOPER_BONUS_SIZE;
        //Assert
        double  paskaicuotasBonusas = employeeService.calculateBonus(developer_C_PLUS_PLUS);
        //Act
        assertEquals(paskaicuotasBonusas,atsakymas);

        assertEquals(vardas, developer_C_PLUS_PLUS.getName());
        assertEquals(amzius, developer_C_PLUS_PLUS.getAge());
        assertEquals(atlyginimas, developer_C_PLUS_PLUS.getSalary());
    }
    @Test
    public void testCalculateBonusForManagerBigTeam() {

        //Arrange
        String vardas = managerBigTeam.getName();
        int amzius = managerBigTeam.getAge();
        BigDecimal atlyginimas = managerBigTeam.getSalary();

        //Vertė kuri turi būti
        double atsakymas = Double.parseDouble(atlyginimas.toString())*MANAGER_BONUS_SIZE;
        //Assert
        double  paskaicuotasBonusas = employeeService.calculateBonus(managerBigTeam);
        //Act
        assertEquals(paskaicuotasBonusas,atsakymas);

        assertEquals(vardas, managerBigTeam.getName());
        assertEquals(amzius, managerBigTeam.getAge());
        assertEquals(atlyginimas, managerBigTeam.getSalary());
    }

    @Test
    public void testCalculateBonusForManagerSmallTeam() {

        //Arrange
        String vardas = managerSmallTeam.getName();
        int amzius = managerSmallTeam.getAge();
        BigDecimal atlyginimas = managerSmallTeam.getSalary();

        //Vertė kuri turi būti
        double atsakymas = Double.parseDouble(atlyginimas.toString())*MANAGER_BONUS_SIZE;
        //Assert
        double  paskaicuotasBonusas = employeeService.calculateBonus(managerSmallTeam);
        //Act
        assertEquals(paskaicuotasBonusas,atsakymas);

        assertEquals(vardas, managerSmallTeam.getName());
        assertEquals(amzius, managerSmallTeam.getAge());
        assertEquals(atlyginimas, managerSmallTeam.getSalary());
    }
    
    


}
