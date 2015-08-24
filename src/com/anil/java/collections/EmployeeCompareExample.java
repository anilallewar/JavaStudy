package com.anil.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeCompareExample {

    public void checkComparableEmployee() {
        Employee e1 = new Employee();
        e1.setEmployeeId(1);
        e1.setEmployeeName("Anil Allewar");
        e1.setDesignation("PA");

        Employee e2 = new Employee(2, "Abhijeet Mahule", "SE");
        Employee e3 = new Employee(3, "Jitendra Kumar", "SE");
        Employee e4 = new Employee(4, "Deepak Gupta", "SE");

        ArrayList<Employee> list = new ArrayList<Employee>(); //Works even when the ArrayList type is not defined
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        System.out.println(list);

        Collections.sort(list);

        System.out.println("After sorting the employee collection using comparable");

        System.out.println(list);

        System.out.println("After sorting the employee collection using COMPARATOR class. The sorting is on designation");

        Collections.sort(list, new EmployeeComparator());

        System.out.println(list);
    }

    /**
     * Note that for binary search, the array/collection must be sorted before the search.
     * Also if the collecion has been sorted using comparable/comparator, then the same MUST
     * be used for binary search.
     */
    public void searchEmployee() {
        Employee e1 = new Employee();
        e1.setEmployeeId(1);
        e1.setEmployeeName("Anil Allewar");
        e1.setDesignation("PA");

        Employee e2 = new Employee(2, "Abhijeet Mahule", "SE");
        Employee e3 = new Employee(3, "Jitendra Kumar", "SE");
        Employee e4 = new Employee(4, "Deepak Gupta", "SE");

        ArrayList<Employee> list = new ArrayList<Employee>(); //Works even when the ArrayList type is not defined
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        //Sorting the collection
        Collections.sort(list);
        System.out.println(list);
        //Performing binary seeach on the collection for element e1
        System.out.println("The employee e1 representing Anil Allewar is found at position: " + Collections.binarySearch(list, e1));
        //Trying to search for a non existant employee
        Employee e5 = new Employee(5, "Acid", "PM");
        //Performing binary seeach on the collection for element e5
        System.out.println("The employee e1 representing nonoexistant employee in the list is found at position: " + Collections.binarySearch(list, e5));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EmployeeCompareExample empCompExample = new EmployeeCompareExample();
        empCompExample.checkComparableEmployee();
        System.out.println("Searching for elements in the array");
        empCompExample.searchEmployee();
    }
}

class Employee implements Comparable<Employee> {

    private int EmployeeId;
    private String EmployeeName;
    private String Designation;

    public Employee() {
    }

    public Employee(int EmployeeId, String EmployeeName, String Designation) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.Designation = Designation;
    }

    /**
     * @return Returns the designation.
     */
    public String getDesignation() {
        return Designation;
    }

    /**
     * @param designation The designation to set.
     */
    public void setDesignation(String designation) {
        Designation = designation;
    }

    /**
     * @return Returns the employeeId.
     */
    public int getEmployeeId() {
        return EmployeeId;
    }

    /**
     * @param employeeId The employeeId to set.
     */
    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    /**
     * @return Returns the employeeName.
     */
    public String getEmployeeName() {
        return EmployeeName;
    }

    /**
     * @param employeeName The employeeName to set.
     */
    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    /**
     * This is the overridden method in the Comparable interface
     * @param e
     * @return
     */
    public int compareTo(Employee e) {
        return this.EmployeeName.compareTo(e.getEmployeeName());
    }

    public String toString() {
        return this.EmployeeId + "," + this.EmployeeName + "," + this.Designation;
    }
}

class EmployeeComparator implements Comparator<Employee> {

    /**
     * The method is different from Comparable in the sense that you can sort the Collection
     * in any number of different ways.
     * 
     * The other handy thing about the Comparator interface is that you can use it to sort 
     * instances of any class, even classes you can't modify unlike the Comparable interface, 
     * which forces you to change the class whose instances you want to sort.
     * 
     * @param e1
     * @param e2
     * @return
     */
    public int compare(Employee e1, Employee e2) {
        return e1.getDesignation().compareTo(e2.getDesignation());
    }
}

