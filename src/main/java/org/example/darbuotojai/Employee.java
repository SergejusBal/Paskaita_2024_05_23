package org.example.darbuotojai;

import java.math.BigDecimal;

public abstract class Employee {

    private String name;
    private int age;
    private BigDecimal salary;

    private String department;

    public Employee(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = null;
    }
    public abstract void work();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary.toString();
    }
}
