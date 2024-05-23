package org.example;

import org.example.EmployeeService.EmployeeService;
import org.example.EmployeeService.EmployeeServiceImpl;
import org.example.darbuotojai.Employee;

import java.util.Iterator;
import java.util.List;

public class ProgramUI {
    EmployeeServiceImpl employeeServiceImp;
    public ProgramUI() {
        employeeServiceImp = new EmployeeServiceImpl();

    }

    public void paleistiUI(){

        List<Employee> employeeList = employeeServiceImp.getEmployeeList();
        Iterator<Employee> iterator = employeeList.iterator();
        Employee employee;

            System.out.println("**********************************************");
            System.out.println("Pirma dalis (1)");
            System.out.println("performDuties (2)");
            System.out.println("getEmployeeInfo (3)");
            System.out.println("promoteEmployee (4)");
            System.out.println("changeEmpleyeeInfo (5)");
            System.out.println("fireEmployee (6)");
            System.out.println("calculateBonus (7)");
            System.out.println("evaluatePerformance (8)");
            System.out.println("transferDepartment (9)");
            System.out.println("listAllEmployees (10)");
            System.out.println("findEmployeeByName(11)");
            System.out.println("Pasirinkite paslaugą:");
            int pasirinkimas = Custom.nuskaitytiIntVerteCon();
            switch (pasirinkimas){
                case 1:
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        System.out.println(employeeServiceImp.getEmployeeInfo(employee));
                        employeeServiceImp.performDuties(employee);
                    }
                    break;
                case 2:
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        employeeServiceImp.performDuties(employee);
                    }

                    break;
                case 3:
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        System.out.println(employeeServiceImp.getEmployeeInfo(employee));
                    }
                    break;
                case 4:
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        System.out.println("Info Prieš");
                        System.out.println(employeeServiceImp.getEmployeeInfo(employee));

                        employeeServiceImp.promoteEmployee(employee);

                        System.out.println("Info po");
                        System.out.println(employeeServiceImp.getEmployeeInfo(employee));
                    }
                    break;
                case 5:
                    employee  = iterator.next();
                    System.out.println(employee);
                    employeeServiceImp.changeEmpleyeeInfo(employee);
                    System.out.println(employee);
                    break;
                case 6:
                    employee  = iterator.next();
                    System.out.println("List: " + employeeList);
                    employeeServiceImp.fireEmployee(employee);
                    System.out.println("List: " + employeeList);
                    break;
                case 7:
                    employeeServiceImp.listAllEmployees(employeeList);
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        System.out.println(employeeServiceImp.calculateBonus(employee));
                    }
                    break;

                case 8:
                    employeeServiceImp.listAllEmployees(employeeList);
                    int index = 10;
                    while(iterator.hasNext()){
                        employee  = iterator.next();
                        employeeServiceImp.evaluatePerformance(employee,index);
                        index--;
                    }
                    employeeServiceImp.listAllEmployees(employeeList);
                    break;
                case 9:
                    employee  = iterator.next();
                    System.out.println(employee.getDepartment());
                    employeeServiceImp.transferDepartment(employee,"New dep");
                    System.out.println(employee.getDepartment());
                    break;

                case 10:
                    employeeServiceImp.listAllEmployees(employeeList);
                    break;
                case 11:
                    employee = employeeServiceImp.findEmployeeByName(employeeList,"Jonas");
                    System.out.println(employee);
                    break;
            }

    }



}
