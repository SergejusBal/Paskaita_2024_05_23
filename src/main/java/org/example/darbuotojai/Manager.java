package org.example.darbuotojai;

import java.math.BigDecimal;

public class Manager extends Employee {

    private int teamSize;

    public Manager(String name, int age, BigDecimal salary, int teamSize) {
        super(name, age, salary);
        this.teamSize = teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public void work() {

    }
}
