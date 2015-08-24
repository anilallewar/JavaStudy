/**
 * 
 */
package com.anil.java.collections.binarytree;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author anila
 * 
 */
public class Calculator {
	Stack<String> opStack = new Stack<String>(); // used for infix->postfix
	// translation
	BinaryTree<String> expTree; // tree where expression is built and stored
	private String unprocessed, infix, postfix;
	private static final String VALID_SYMBOLS = "()^/*+-\t";
	private static final String DIGITS = "1234567890";
	private boolean bool = false;

	public Calculator(String exp) {
		unprocessed = exp;
		infix = "";
		postfix = "2 4 5 3 + + *";
	}

	/**
	 * Removes whitespace, inserts missing or implied * symbols, and reports
	 * illegal characters
	 */
	public void preprocessor() throws IllegalStateException {
	} // Completed, infix String now set

	/**
	 * Takes the preprocessed infix expression and translates it to postfix type
	 */
	public void infix2postfix() {
	} // Completed, postfix String now set

	/**
	 * If 'postfix' is "NA", the method returns null. Otherwise, its builds and
	 * returns an expression binary tree using 'postfix' where internal nodes
	 * store operators and leaf nodes store operands.
	 * 
	 * @return the now-filled expression tree
	 */
	public BinaryTree<String> buildExpressionTree() {
		String token = "";
		expTree = new BinaryTree<String>();
		boolean isLeafOp = false;

		String reversedString = new StringBuilder(postfix.toString()).reverse()
				.toString();
		StringTokenizer s = new StringTokenizer(reversedString, " ", false);
		while (s.hasMoreTokens()) {
			token = s.nextToken();
			opStack.push(token);

		}

		System.out.println("Token: " + opStack);

		Stack<BinaryTree> binaryTreeStack = new Stack<BinaryTree>();
		Stack<String> localOp = new Stack<String>();

		while (!opStack.empty()) {
			if (DIGITS.indexOf(opStack.peek()) > -1) {
				localOp.push(opStack.pop());
			} else {
				if (VALID_SYMBOLS.indexOf(opStack.peek()) > -1) {
					if (!isLeafOp) {
						isLeafOp = true;
						System.out.println("Local stack:" + localOp);
						expTree = new BinaryTree<String>(opStack.pop(),
								new BinaryTree<String>(localOp.pop(), null,
										null), new BinaryTree<String>(localOp
										.pop(), null, null));
					} else {
						expTree = new BinaryTree<String>(
								opStack.pop(),
								(!binaryTreeStack.isEmpty() && binaryTreeStack
										.peek() != null) ? binaryTreeStack
										.pop() : null,
								((!binaryTreeStack.isEmpty() && binaryTreeStack
										.peek() != null) ? binaryTreeStack
										.pop()
										: ((!localOp.isEmpty() && localOp
												.peek() != null) ? new BinaryTree<String>(
												localOp.pop(), null, null)
												: null)));
					}
					System.out.println(expTree.toString());
					binaryTreeStack.push(expTree);
				}
			}
		}
		System.out.println("Out of loop");
		return expTree;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the expressions:");
		while (console.hasNext()) {
			String input = console.nextLine();
			Calculator calc = new Calculator(input);
			System.out.println("Unprocessed : " + calc.getUnprocessed());
			calc.preprocessor();
			System.out.println("Processed Infix :" + calc.getInfix());
			calc.infix2postfix();
			System.out.println("Postfix :" + calc.getPostfix());
			BinaryTree eTree = calc.buildExpressionTree();
			System.out.println("Value : " + calc.toString());
			System.out.println();
		}
	}

	/**
	 * @return the unprocessed
	 */
	public String getUnprocessed() {
		return unprocessed;
	}

	/**
	 * @return the infix
	 */
	public String getInfix() {
		return infix;
	}

	/**
	 * @return the postfix
	 */
	public String getPostfix() {
		return postfix;
	}
}
