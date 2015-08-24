/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Anil Allewar
 */
public class CollectionsPriorityQueueExample {
    //Class has to be static as it is called from the static main method
    static class PQsort
            implements Comparator<Integer> {  // inverse sort

        public int compare(Integer one, Integer two) {
            return two - one;                     // unboxing
        }
    }

    public static void main(String[] args) {
        int[] ia = {1, 5, 3, 7, 6, 9, 8};              // unordered data
        PriorityQueue<Integer> pq1 =
                new PriorityQueue<Integer>();         // use natural order

        for (int x : ia) // load queue
        {
            pq1.offer(x);
        }
        for (int x : ia) // review queue
        {
            System.out.print(pq1.poll() + " ");
        }
        System.out.println("");

        PQsort pqs = new PQsort();             // get a Comparator
        PriorityQueue<Integer> pq2 =
                new PriorityQueue<Integer>(10, pqs);  // use Comparator

        for (int x : ia) // load queue
        {
            pq2.offer(x);
        }
        System.out.println("size " + pq2.size());
        System.out.println("peek " + pq2.peek());
        System.out.println("size " + pq2.size());
        System.out.println("poll " + pq2.poll());
        System.out.println("size " + pq2.size());
        while(pq2.size() > 0) // review queue
        {
            System.out.print(pq2.poll() + " ");
        }
    }
}
