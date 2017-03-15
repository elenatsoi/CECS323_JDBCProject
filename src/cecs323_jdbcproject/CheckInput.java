package cecs323_jdbcproject;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniawareh
 */
public class CheckInput {
    
	/**
	 * Checks that the value that was input is an integer.
	 * @return the valid input.
	 */
	public static int checkInt() {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean valid = false;
		while(!valid) {
			if(in.hasNextInt()) {
				input = in.nextInt();
				valid = true;
			} else {
				in.next();
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}
	
	/**
	 * Checks that the value that was input is an integer and 
	 * within the specified range.
	 * @param low lower bound of the range.
	 * @param high upper bound of the range.
	 * @return the valid input.
	 */
	public static int checkIntRange(int low, int high) {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean valid = false;
		while(!valid) {
			if(in.hasNextInt()) {
				input = in.nextInt();
				if(input <= high && input >=low) {
					valid = true;
				} else {
					System.out.println("Invalid Input.");
				}
			} else {
				in.next();
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}
	
	/**
	 * Checks that the value that was input is a double.
	 * @return the valid input.
	 */
	public static double checkDouble() {
		Scanner in = new Scanner(System.in);
		double input = 0;
		boolean valid = false;
		while(!valid) {
			if(in.hasNextInt()) {
				input = in.nextDouble();
				valid = true;
			} else {
				in.next();
				System.out.println("Invalid Input.");
			}
		}
		return input;
	}
	
	/**
	 * Takes in a string from the user.
	 * @return the String input.
	 */
	public static String getString() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		return input;
	}
    
    
    
}
