package com.anil.java.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraySortExample {

    public void checkAsList(int[] temp) {
        if (temp == null) {
            return;
        }
        Integer[] temp1 = new Integer[temp.length];
        System.out.println("Printing the array received in the method");
        int count = 0;
        for (int i : temp) {
            temp1[count++] = i;
        }
         for(Integer i1:temp1){
            System.out.print(i1.intValue() + ",");
        }
        System.out.println();
        List list = Arrays.asList(temp1);
        Iterator i = list.iterator();
        System.out.println("Printing the backed up list after addition to the list");
        
        list.set(2, 23);
        System.out.println(list);
        System.out.println("Change in list should be propogated back to the array");
        for(Integer i1:temp1){
            System.out.print(i1.intValue() + ",");
        }
        System.out.println();
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {41, 2, 45, 3, 7, 5, 90};
        //Trying to find element in an array that has not been sorted
        System.out.println("The element 41 is at position: " + Arrays.binarySearch(a, 41));
        //Note that primitives are always sorted on the natural order and there is no custom comparator/comparable 
        //that can be provided gor primitive sorting
        Arrays.sort(a, 2, 6);
        for (int i : a) {
            System.out.print(i+",");
        }
        System.out.println();
        //This will give unpredicatble results since 41 was not sorted 
        System.out.println("The element 41 is at position: " + Arrays.binarySearch(a, 41));
        //Sorting the entire array
        Arrays.sort(a);
        for (int i : a) {
            System.out.print(i+ ",");
        }
        System.out.println();
        //This will give correct results since 41 is now sorted 
        System.out.println("The element 41 is at position: " + Arrays.binarySearch(a, 41));
        //Searching for a non existant key will give the insert position. Since 0 is a valid insertion
        //position, the insertion position returned is (-(insertion position)-1)
        System.out.println("The element 11 is at position: " + Arrays.binarySearch(a, 11));
        //Calling the asList() method will cause the array and list to be joined at the hip i.e.
        //changes to one will affect the another
        ArraySortExample arrSortExample = new ArraySortExample();
        arrSortExample.checkAsList(a);
        System.out.println("No changes to the original int[] as we converted it to Integer[] while using");
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}
