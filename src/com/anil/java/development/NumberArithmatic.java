/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.development;

import java.util.Arrays;
import java.util.TreeSet;

import org.apache.commons.math.stat.Frequency;
import org.apache.commons.math.stat.descriptive.rank.Percentile;

/**
 *
 * @author Anil Allewar
 */
public class NumberArithmatic {

    private boolean isPerfectNumber(int n) {
        boolean result = false;

        int upperbound = n / 2;
        int temp = 0;

        for (int i = upperbound; i > 0; i--) {
            if (n % i == 0) {
                temp += i;
            }
        }

        if (temp == n) {
            result = true;
        }
        return result;
    }

    private void primeFactors(int x) {
        int i = 2;
        while (x != 1) {
            if (x % i == 0) {
                System.out.print(i + " ");
                x = x / i;
            } else {
                i++;
            }
        }
        System.out.println();
    }

    private void LCMGCD(int a, int b) {
        int big;
        int small;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        for (int i = 1; i <= big; i++) {
            if (((big * i) % small) == 0) {
                int lcm = big * i;
                System.out.println("The least common multiple is " + (lcm));
                break;
            }
        }
        int temp = 1;
        while (temp != 0) {
            temp = big % small;
            if (temp == 0) {
                System.out.println("GCD is " + small);
            } else {
                big = small;
                small = temp;
            }
        }
    }

    //Note this method returns -1 if the int supplied has no factorial (eg a negative number)
    private int factorial(int num) {
        //BASE CASES: 0! = 1 and factorial not defined for negative ints
        if (num < 0) {
            return -1;
        }
        if (num == 0) {
            return 1;
        }
        if (num <= 2) {
            return num;
        }

        //RECURSIVE STEP: n! = n * (n-1)!
        return (num * factorial(num - 1));
    }

    private void integerToBinary(int num, int base) {
        if(num>0) { //Check to make sure integer is positive.
            integerToBinary(num/base, base); //These two lines do all the work - the actual recursion
            System.out.print(num%base);
        }
    }

    
    private int isBitSet(int value, int bit) {
    	//Need to set to bit-1 as your 1st bit is 2^0
    	int flag = (int)Math.pow(2, bit-1);
        if ((value & flag) == flag) {
            return 1;
        } else {
            return 0;
        }
    }
    
	private double getPercentileValue(double[] inputValueSorted,
			double valuePercentileRequired) {

		Percentile percentile = new Percentile();
		percentile.setData(inputValueSorted);

		return percentile.evaluate(valuePercentileRequired);
	}
	
	private Double getPercentileValueWithFrequency(TreeSet<Double> inputValueSorted,
			Double value){
		
		Frequency frequency = new Frequency();
		for (Double input:inputValueSorted){
			frequency.addValue(input);
		}
		
		return frequency.getCumPct(value);
	}
    
    public static void main(String[] args) {
    	NumberArithmatic numberArith = new NumberArithmatic();
    	System.out.println("numberArith.isPerfectNumber(6):" + numberArith.isPerfectNumber(6));
        System.out.println("numberArith.isPerfectNumber(5):" + numberArith.isPerfectNumber(5));
        System.out.println("numberArith.isPerfectNumber(13):" + numberArith.isPerfectNumber(13));
        System.out.println("numberArith.isPerfectNumber(28):" + numberArith.isPerfectNumber(28));
        System.out.println("Calling primeFactors(28)");
        numberArith.primeFactors(28);
        System.out.println("Calling primeFactors(25)");
        numberArith.primeFactors(25);
        System.out.println("Calling primeFactors(13)");
        numberArith.primeFactors(13);
        System.out.println("Calling LCMGCD(13,52)");
        numberArith.LCMGCD(13, 52);
        System.out.println("Calling LCMGCD(4,52)");
        numberArith.LCMGCD(4, 52);
        System.out.println("Calling LCMGCD(4,55)");
        numberArith.LCMGCD(4, 55);
        System.out.println("Calling integerToBinary(67, 2)");
        numberArith.integerToBinary(67, 2);
        System.out.println();
        int b = (int) 0xB1;
        System.out.println("Checking the 5th bit set for: " + b);
        numberArith.integerToBinary(b, 2);
        System.out.println();
        System.out.println(numberArith.isBitSet(b, 5));
        System.out.println(numberArith.isBitSet(b, 2));
        
        double[] inputPercentileArray = {2.4,3.4,8.9,3.6,4.5,6.7,3.6};
        System.out.println("The input array is: " + inputPercentileArray.toString());
        System.out.println("Value for 0.01 percentile is: " + numberArith.getPercentileValue(inputPercentileArray, 0.01));
        System.out.println("Value for 20 percentile is: " + numberArith.getPercentileValue(inputPercentileArray, 20));
        System.out.println("Value for 40 percentile is: " + numberArith.getPercentileValue(inputPercentileArray, 40));
        System.out.println("Value for 60 percentile is: " + numberArith.getPercentileValue(inputPercentileArray, 60));
        System.out.println("Value for 100 percentile is: " + numberArith.getPercentileValue(inputPercentileArray, 100));

		Double[] frequencyInputPercentileArray = { 3.4, 3.6, 3.6, 3.6, 4.5,
				6.7, 8.9, 2.4 };

		TreeSet<Double> doubleTreeSet = new TreeSet<Double>(
				Arrays.asList(frequencyInputPercentileArray));

		System.out.println(doubleTreeSet);

		System.out
				.println("The percentile value for 2.4 using frequency method is: "
						+ numberArith.getPercentileValueWithFrequency(
								doubleTreeSet, 2.4));
		System.out
				.println("The percentile value for 3.4 using frequency method is: "
						+ numberArith.getPercentileValueWithFrequency(
								doubleTreeSet, 3.4));
		System.out
				.println("The percentile value for 3.6 using frequency method is: "
						+ numberArith.getPercentileValueWithFrequency(
								doubleTreeSet, 3.6));
		System.out
				.println("The percentile value for 4.5 using frequency method is: "
						+ numberArith.getPercentileValueWithFrequency(
								doubleTreeSet, 4.5));
		System.out
				.println("The percentile value for 8.9 using frequency method is: "
						+ numberArith.getPercentileValueWithFrequency(
								doubleTreeSet, 8.9));
		System.out
		.println("The percentile value for 6.9 using frequency method is: "
				+ numberArith.getPercentileValueWithFrequency(
						doubleTreeSet, 6.9));
    }
}
