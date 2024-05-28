import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesttransferDepartment {

    Developer developerJAVA;

    static EmployeeService employeeService;


    @BeforeAll
    public static void paruoštiObjektus() {

        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void transferDepartment_generalCase_ChecksDepartmentValue() {

        //Arrange
        developerJAVA = new Developer("Jonas", 24, new BigDecimal(2000), ProgrammingLanguage.JAVA);
        String expected = "Sunkūs darbai";
        //Assert
        employeeService.transferDepartment(developerJAVA,expected);
        String actual = developerJAVA.getDepartment();
        //Act
        assertEquals(expected, actual);

    }
}
