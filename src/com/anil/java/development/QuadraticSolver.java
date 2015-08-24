/**
 * 
 */
package com.anil.java.development;

/**
 * @author anila
 * 
 */

public class QuadraticSolver {

	double D;
	double discriminant = 0.0;
	double root1;
	double root2;

	public double[] Quadratic(double a, double b, double c) {

		double[] roots = null;
		if (a == 0.0) {
			System.out.println("This is not a Quadratic quation ! ");
			return roots;
		}
		if (b == 0.0) {
			System.out.println("There is no solution ! ");
			return roots;
		}
		if (a > 0.0 && b > 0) {
			D = -c / b;
			System.out.println("There is a solution -c/b :" + D);
		} else
			discriminant = (Math.pow(b, 2)) - (4 * a * c);

		if (discriminant == 0.0) {
			root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			System.out.println("There is one root at: " + root1 + "Roots:");
		} else if (discriminant > 0.0) {
			root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			System.out.println("There are two real roots at: " + root1 + " "
					+ root2 + "Roots:");

		} else if (discriminant < 0.0) {
			root1 = (-b + Math.sqrt(-discriminant)) / (2 * a);
			root2 = (-b + Math.sqrt(-discriminant)) / (2 * a);
			System.out.println("There are two imaginary roots at: " + root1
					+ " " + root2 + "Roots:");
		}
		roots = new double[2];
		roots[0]=root1;
		roots[0]=root2;
		return roots;
	}
}
