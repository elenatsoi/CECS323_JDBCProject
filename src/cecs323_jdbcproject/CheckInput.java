package cecs323_jdbcproject;

import java.util.Scanner;

public class CheckInput() {

    static Scanner intIn = new Scanner(System.in);
    static Scanner strIn = new Scanner(System.in);

    //CHECK STRING NOT NULL
    public static String checkString(String attr) {
        
        boolean valid = false;
        String temp = "";
        
        while (!valid) {
            
            temp = strIn.nextLine();
            
            if (temp.length() >= 1) {
                
                valid = true;
            }
            else {
                
                System.out.println("Cannot be null.\n"
                        + "Please enter valid " + attr + ": ");
            }
        }
        
        return temp;
    }
    
    //CHECK INT
    public static int checkInt() {
        
        boolean valid = false;
        int validInt = 0;
        
        while (!valid) {
            
            if (intIn.hasNextInt()) {
                
                validInt = in.nextInt();
                valid = true;
            }
            else {
                
                in.next();
                System.out.println("Invalid input entered. "
                        + "\nPlease enter an integer: ");
            }
        }
        
        return validInt;
    }

    //CHECK INT LOW
    public static String checkInt(int low) {
        
        boolean valid = false;
        int input = 0;
        
        while (!valid) {
            
            if (in.hasNextInt()) {
                
                input = in.nextInt();
                
                if (input >= low) {
                    
                    valid = true;
                } 
                else {
                    
                    System.out.println("Invalid number of pages entered."
                        + "\nEnter valid number of pages: ");
                }
            }
            else {
                
                in.next();
                System.out.println("Invalid number of pages entered."
                        + "\nEnter valid number of pages: ");
            }
        }
        
        return Integer.toString(input);
    }
    
    //CHECK INT LOW - HIGH
    public static String checkInt(int low, int high) {
        
        boolean valid = false;
        int input = 0;
        
        while (!valid) {
            
            if (intIn.hasNextInt()) {
                
                input = in.nextInt();
                
                if (input >= low && input <= high) {
                    
                    valid = true;
                }
                else {
                    
                    System.out.println("Invalid input entered. "
                        + "\nEnter number between " + low + " and " + high + ": ");
                }
            }
            else {
                
                in.next();
                System.out.println("Invalid input entered. "
                        + "\nEnter number between " + low + " and " + high + ": ");
            }
        }
        
        return Integer.toString(input);
    }
}