import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestevaluatePerformance {
    Developer developerJAVA;
    EmployeeService employeeService;

    private final double PERFORMANCE_BONUS_GOOD = 0.1;
    private final double PERFORMANCE_BONUS_NORMAL = 0.05;

    @BeforeEach
    public void paruoštiObjektus() {

        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);       ;

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void testEvaluatePerformanceForEmployeeGood() {

        //Arrange
        String vardas = developerJAVA.getName();
        int amzius = developerJAVA.getAge();
        BigDecimal atlyginimas = developerJAVA.getSalary();

        BigDecimal CorrectResult = atlyginimas.multiply(new BigDecimal(PERFORMANCE_BONUS_GOOD+1));
        int performaceScore = 10;

        //Assert
        employeeService.evaluatePerformance(developerJAVA,performaceScore);
        BigDecimal result = developerJAVA.getSalary();
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, developerJAVA.getName());
        assertEquals(amzius, developerJAVA.getAge());
    }

    @Test
    public void testEvaluatePerformanceForEmployeeNormal() {

        //Arrange
        String vardas = developerJAVA.getName();
        int amzius = developerJAVA.getAge();
        BigDecimal atlyginimas = developerJAVA.getSalary();

        BigDecimal CorrectResult = atlyginimas.multiply(new BigDecimal(PERFORMANCE_BONUS_NORMAL+1));
        int performaceScore = 7;

        //Assert
        employeeService.evaluatePerformance(developerJAVA,performaceScore);
        BigDecimal result = developerJAVA.getSalary();
        //Act
        assertEquals(result,CorrectResult);

        assertEquals(vardas, developerJAVA.getName());
        assertEquals(amzius, developerJAVA.getAge());
    }



}
