package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeLinkedList=new LinkedList<>();
        employeeLinkedList.add(new Employee(2,"a","s"));
        employeeLinkedList.add(new Employee(2,"a","s"));
        employeeLinkedList.add(new Employee(1,"e","s"));
        employeeLinkedList.add(new Employee(3,"e","a"));
        employeeLinkedList.add(new Employee(3,"e","a"));

/*findDuplicates(employeeLinkedList).forEach(employee->System.out.println(employee.getFirstname()+employee.getLastName()+employee.getId()));*/
        System.out.println("*****findDuplicates*****");
        System.out.println(findDuplicates(employeeLinkedList));
        System.out.println("*****findUniques*****");
        System.out.println(findUniques(employeeLinkedList));
        System.out.println("*****removeDuplicates*****");
        System.out.println(removeDuplicates(employeeLinkedList));
    }

    public static List<Employee> findDuplicates(List<Employee> employeeList){
        Set<Employee> uniqueEmployeeSet=new HashSet<>();
        List<Employee> duplicateList=new LinkedList<>();
        for(Employee employee:employeeList){
            if(!uniqueEmployeeSet.add(employee)){
                duplicateList.add(employee);
            }

        }
        return duplicateList;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employeeList){
        Set<Employee> uniqueEmployeeSet=new HashSet<>(employeeList);
        Map<Integer,Employee> uniqueEmployeeMap=new HashMap<>();
        for(Employee employee:uniqueEmployeeSet){
            if(employee!=null){
                uniqueEmployeeMap.put(employee.getId(),employee);
            }
        }
        return uniqueEmployeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList) {
        Set<Employee> uniqueEmployeeSet = new HashSet<>(employeeList);
        List<Employee> result = new ArrayList<>();

        for (Employee employee : uniqueEmployeeSet) {
            if (Collections.frequency(employeeList, employee) == 1 && employee != null ) {

                result.add(employee);
            }
        }
        return result;
    }
}