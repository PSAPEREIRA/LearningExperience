package Entities;

import java.util.ArrayList;
import java.util.List;

public class ListedEmployee {

    private String name;
    private int id;
    private double salary;


    public ListedEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void salaryIncrease(double percentage){
        salary+=salary*percentage/100;
    }



    @Override
    public String toString() {
        return "List of Employees:\n" +id+", "+name+", "+String.format("%.2f",salary);

    }
}
