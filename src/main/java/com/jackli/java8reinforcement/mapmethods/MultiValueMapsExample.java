package com.jackli.java8reinforcement.mapmethods;

import java.util.*;

public class MultiValueMapsExample {
    static Map<Integer, List<Employee>> employeeDOJMap = new HashMap<>();

    public static void main(String args[]) {

        List<Employee> list2014 = Arrays.asList(
                new Employee("Deborah Sprightly", 29, 9000.00));
        employeeDOJMap.put(2014, list2014);
        List<Employee> list2015 = Arrays.asList(
                new Employee("Tom Jones", 45, 7000.00),
                new Employee("Harry Major", 25, 10000.00));
        employeeDOJMap.put(2015, list2015);
        List<Employee> list2016 = Arrays.asList(
                new Employee("Ethan Hardy", 65, 8000.00),
                new Employee("Nancy Smith", 22, 12000.00));
        employeeDOJMap.put(2016, list2016);



        System.out.println("Using Map.forEach to print the Employee in employeeDOJMap multi-value map\n");
        employeeDOJMap.forEach((year,empList)->System.out.println(year+"-->" +empList));

        System.out.println("\nCAPITALIZED Employee Names using Map.replaceAll()");
        employeeDOJMap.replaceAll((year, empList) -> {
            empList.replaceAll(emp -> {
                emp.setName(emp.getName().toUpperCase());
                return emp;
            });
            return empList;
        });
        employeeDOJMap.forEach((year, empList)-> System.out.println(year+"-->"+empList));

        //------- Java 7 way of checking and instantiating before all insertions
        System.out.println("\nJava 7 way of adding a new key(2017) in a multi-value map\n");
        List empList2017 = employeeDOJMap.get(2017);
        if (empList2017 == null) {
            empList2017 = new ArrayList<>();
        }
        empList2017.add(new Employee("Tom Newman", 45, 12000.00));
        employeeDOJMap.put(2017, empList2017);

        //--------Java 8 code to show usage of Map.computeIfAbsent() method
        employeeDOJMap.computeIfAbsent(2018, empList -> new ArrayList<>()).add(new Employee("Dick Newman", 35, 10000.00));


    }
}
