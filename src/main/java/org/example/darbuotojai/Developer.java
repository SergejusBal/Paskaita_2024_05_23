package org.example.darbuotojai;

import java.math.BigDecimal;

public class Developer extends Employee{

    private ProgrammingLanguage programmingLanguage;

    public Developer(String name, int age, BigDecimal salary, ProgrammingLanguage programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {

    }


}
