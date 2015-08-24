/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.development;

/**
 *
 * @author Anil Allewar
 */
public class CockTailSort {

    /**
     * Performs a one-directional bubble sort on the passed set
     */
    private Integer[] BubbleSort(Integer[] unsorted) {
        int beg = 0;	           	//Beginning index for the left-to-right pass
        int end = unsorted.length - 1;	//End index for the left-to-right pass
        Integer tmp = null;          	//Temporary variable for swapping
        boolean hasSwapped;		//Denotes whether a swap was made during a pass

        do {
            hasSwapped = false;
            System.out.println("beg: " + beg + " :end: " + end);
            //Bubble sort from left-to-right starting at beg and ending at end
            for (int i = beg; i < end; ++i) {
                if (unsorted[i] < unsorted[i + 1]) {
                    tmp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = tmp;

                    hasSwapped = true;
                }
            }
            end--;
        } while (hasSwapped == true && end > 0);

        return unsorted;
    }

    /**
     * Performs a bi-directional bubble sort on the passed set, also know as a cocktail sort.
     * After making passes from left to right, the algorithm then passes from right to left
     */
    private Integer[] cocktailSort(Integer[] unsorted) {
        int beg = 0;	           	//Beginning index for the left-to-right pass
        int end = unsorted.length - 1;	//End index for the left-to-right pass
        Integer tmp = null;          	//Temporary variable for swapping
        boolean hasSwapped;		//Denotes whether a swap was made during a pass

        do {
            hasSwapped = false;
            System.out.println("beg: " + beg + " :end: " + end);
            //Bubble sort from left-to-right starting at beg and ending at end
            for (int i = beg; i < end; ++i) {
                if (unsorted[i] > unsorted[i + 1]) {
                    tmp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = tmp;

                    hasSwapped = true;
                }
            }
            end--;     //Decrease end by one

            //Bubble sort from right-to-left starting at end and ending at beg
            for (int i = end; i > beg; --i) {
                if (unsorted[i] < unsorted[i - 1]) {
                    tmp = unsorted[i];
                    unsorted[i] = unsorted[i - 1];
                    unsorted[i - 1] = tmp;

                    hasSwapped = true;
                }
            }
            beg++;     //Increment beg by one

        } while ((hasSwapped == true) && (beg != end)); //While no swaps have been made

        return unsorted;
    }

    public static Integer[] insertionSort(Integer[] list, int length) {
        int firstOutOfOrder, location, temp;

        for (firstOutOfOrder = 1; firstOutOfOrder < length; firstOutOfOrder++) { //Starts at second term, goes until the end of the array.
            if (list[firstOutOfOrder] < list[firstOutOfOrder - 1]) { //If the two are out of order, we move the element to its rightful place.
                temp = list[firstOutOfOrder];
                location = firstOutOfOrder;

                System.out.println("Out of order at location[" + location +"] is:" + temp);
                do { //Keep moving down the array until we find exactly where it's supposed to go.
                    list[location] = list[location - 1];
                    location--;
                } while (location > 0 && list[location - 1] > temp);

                list[location] = temp;
            }
        }

        return list;
    }

    /**
     * Invokes a cocktail sort on the unsorted unsorted
     * @param unsorted the unsorted integer set to be sorted
     * @return a sorted version of the unsorted integer set
     */
    public Integer[] sort(Integer[] unsorted) {
        return cocktailSort(unsorted.clone());
    }

    /* Invokes a Bubble sort on the unsorted unsorted
     * @param unsorted the unsorted integer set to be sorted
     * @return a sorted version of the unsorted integer set
     */
    public Integer[] bubbleSort(Integer[] unsorted) {
        return BubbleSort(unsorted.clone());
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[7];
        A[0] = new Integer(3);
        A[1] = new Integer(2);
        A[2] = new Integer(37);
        A[3] = new Integer(25);
        A[4] = new Integer(5);
        A[5] = new Integer(3);
        A[6] = new Integer(9);

        Integer[] result = new Integer[7];

        CockTailSort C = new CockTailSort();
        result = C.sort(A);
        for (int i : result) {
            System.out.println(i);
        }

        System.out.println("Calling bubble sort");

        result = C.bubbleSort(A);
        for (int i : result) {
            System.out.println(i);
        }

        System.out.println("Calling Insertion sort");

        result = insertionSort(A, A.length);
        for (int i : result) {
            System.out.println(i);
        }


    }
}
