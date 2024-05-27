package org.example.darbuotojai;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Manager manager = (Manager) object;
        return teamSize == manager.teamSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamSize);
    }
}
