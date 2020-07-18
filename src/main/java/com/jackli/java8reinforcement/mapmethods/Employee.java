package com.jackli.java8reinforcement.mapmethods;
import lombok.Data;


import java.text.DecimalFormat;
import java.util.Objects;

@Data
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString(){
        DecimalFormat dformat = new DecimalFormat(".##");
        return "Employee Name:"+this.name
                +"  Age:"+this.age
                +"  Salary:"+dformat.format(this.salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) &&
                age.equals(employee.age) &&
                salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }
}
