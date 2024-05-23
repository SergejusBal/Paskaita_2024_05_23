package org.example.EmployeeService;

import org.example.Custom;
import org.example.darbuotojai.Developer;
import org.example.darbuotojai.Employee;
import org.example.darbuotojai.Manager;
import org.example.darbuotojai.ProgrammingLanguage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final int TEAM_SIZE_BIG = 10;
    private final int PROMOTION_TEAM_SIZE = 15;
    private final double MANAGER_PROMOTION_SIZE = 0.1;
    private final double DEVELOPER_PROMOTION_SIZE_JAVA = 0.12;
    private final double DEVELOPER_PROMOTION_SIZE_C_SHARP = 0.07;

    private final double MANAGER_BONUS_SIZE = 0.1;
    private final double DEVELOPER_BONUS_SIZE = 0.05;
    private final double OTHER_BONUS_SIZE = 0.03;

    private final double PERFORMANCE_BONUS_GOOD = 0.1;
    private final double PERFORMANCE_BONUS_NORMAL = 0.05;




    private List<Employee> employeeList;


    public EmployeeServiceImpl() {
        employeeList = createEmployeeList();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public void listAllEmployees(List<Employee> employees) {
        List<Employee> employeeListForOut = employees;
        for(Employee e:employeeListForOut){
            System.out.print(e);
            if (e instanceof Manager){
                System.out.println(" " + ((Manager)e).getTeamSize());
            }
            else if(e instanceof Developer){
                System.out.println(" " + ((Developer)e).getProgrammingLanguage().toString());
            }

        }
    }

    @Override
    public Employee findEmployeeByName(List<Employee> employees, String name) {
        List<Employee> employeeListFind = employees;
        Employee employee = null;
        for(int i = 0; i < employeeListFind.size(); i++){
            if(employeeListFind.get(i).getName().equals(name)){
                employee = employeeListFind.get(i);
                break;
            }
        }
        return employee;
    }

    @Override
    public void transferDepartment(Employee employee, String newDepartment) {
        employee.setDepartment(newDepartment);
    }

    @Override
    public void evaluatePerformance(Employee employee, int performanceScore) {
        if (performanceScore>=9){
            employee.setSalary(employee.getSalary().multiply(new BigDecimal(PERFORMANCE_BONUS_GOOD+1)));
        }
        else if(performanceScore>=7){
            employee.setSalary(employee.getSalary().multiply(new BigDecimal(PERFORMANCE_BONUS_NORMAL+1)));
        }
        else
            System.out.println("Darbuotojui reikia pasistengti.");

    }

    @Override
    public double calculateBonus(Employee employee) {
        if (employee instanceof Manager){
            return Double.parseDouble(employee.getSalary().multiply(new BigDecimal(MANAGER_BONUS_SIZE+1)).toString());
        }
        else if(employee instanceof Developer){
            return Double.parseDouble(employee.getSalary().multiply(new BigDecimal(DEVELOPER_BONUS_SIZE+1)).toString());
        }
        else
            return Double.parseDouble(employee.getSalary().multiply(new BigDecimal(OTHER_BONUS_SIZE+1)).toString());
    }

    @Override
    public void fireEmployee(Employee employee) {
        if(employee == null) return;

        employeeList.remove(employee);
    }

    @Override
    public void changeEmpleyeeInfo(Employee employee) {
        if(employee == null) return;

        System.out.println("Įveskite darbuotojo vardą");
        employee.setName(Custom.nuskaitytiStringVerteCon());
        System.out.println("Įveskite darbuotojo amžių");
        employee.setAge(Custom.nuskaitytiIntVerteCon());
    }

    @Override
    public void promoteEmployee(Employee employee) {
        if (employee instanceof Manager){
            promoteManager((Manager) employee);
        }
        else if(employee instanceof Developer){
            promoteDeveloper((Developer) employee);
        }
        else System.out.println("Šis darbuotojas yra tesiog svečias");
    }

    @Override
    public void performDuties(Employee employee) {
        if (employee instanceof Manager){
            managerTeamSizeMessage((Manager) employee);
        }
        else if(employee instanceof Developer){
            programavimoKalbaIrALga((Developer) employee);
        }
        else System.out.println("Šis darbuotojas yra tesiog svečias");
    }

    @Override
    public String getEmployeeInfo(Employee employee) {
        return employee.toString();
    }

    private void promoteManager(Manager manager){
       manager.setTeamSize(manager.getTeamSize()+1);
       if(manager.getTeamSize() == PROMOTION_TEAM_SIZE)
           manager.setSalary(manager.getSalary().multiply(new BigDecimal(MANAGER_PROMOTION_SIZE + 1)));
    }

    private void promoteDeveloper(Developer developer){
        ProgrammingLanguage programmingLanguage = developer.getProgrammingLanguage();
        switch (programmingLanguage){
            case JAVA:
                developer.setSalary(developer.getSalary().multiply(new BigDecimal(DEVELOPER_PROMOTION_SIZE_JAVA + 1)));
                break;
            case C_SHARP:
                developer.setSalary(developer.getSalary().multiply(new BigDecimal(DEVELOPER_PROMOTION_SIZE_C_SHARP + 1)));
                break;
        }
    }

    private void managerTeamSizeMessage(Manager manager){
        if(manager.getTeamSize() > TEAM_SIZE_BIG) System.out.println("Valdo didelę komandą!");
        else System.out.println("Valdo mažą komandą!");
    }

    private void programavimoKalbaIrALga(Developer developer){
        ProgrammingLanguage programmingLanguage = developer.getProgrammingLanguage();
        System.out.print("Kalba: ");
        switch (programmingLanguage){
            case JAVA:
                System.out.print(ProgrammingLanguage.JAVA);
                break;
            case C_SHARP:
                System.out.print(ProgrammingLanguage.C_SHARP);
                break;
            default:
                System.out.print(developer.getProgrammingLanguage());
                break;
        }
        System.out.println(" * Alga: " + developer.getSalary().toString());
    }

    private List<Employee> createEmployeeList(){

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Developer("Jonas",24,new BigDecimal(2000), ProgrammingLanguage.JAVA));
        employeeList.add(new Developer("Mantas",34,new BigDecimal(5000), ProgrammingLanguage.C_SHARP));
        employeeList.add(new Developer("Janas",44,new BigDecimal(400), ProgrammingLanguage.C_PLUS_PLUS));
        employeeList.add(new Manager("Jokūbas",54,new BigDecimal(3000), 14));
        employeeList.add(new Manager("Aistė",34,new BigDecimal(2000), 9));

        return employeeList;
    }

}
