package com.serhiihonchar;

import java.io.Serializable;

public class Employee implements Serializable, Cloneable {
    public int id;
    public String name;
    public String department;
    private double salary = 550;
    private boolean isVaccinated = true;

    public Employee() {

    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New department is: " + department);
    }

    public void increaseSalary() {
        salary *= 2;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
