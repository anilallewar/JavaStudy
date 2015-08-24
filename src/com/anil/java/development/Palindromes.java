/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.development;

import java.util.Scanner;

/**
 *
 * @author Anil Allewar
 */
public class Palindromes {

    public static boolean isPal(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPal(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("type a word to check if its a palindrome or not");
        System.out.println();
        String x = sc.nextLine();
        if (isPal(x)) {
            System.out.println(x + " is a palindrome");
        } else {
            System.out.println(x + " is not a palindrome");
        }
    }
}
