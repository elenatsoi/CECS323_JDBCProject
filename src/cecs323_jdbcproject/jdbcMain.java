/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs323_jdbcproject;

/**
 *
 * @author Elena
 */
import java.sql.*;
import java.util.Scanner;

public class jdbcMain {
    
    //Database credentials
    static String USER;
    static String PASS;
    static String DBNAME;
    
    Scanner in = new Scanner(System.in);
    System.out.print("Name of the database (not the user account): ");
    DBNAME = in.nextLine();
    System.out.print("Database user name: ");
    USER = in.nextLine();
    System.out.print("Database password: ");
    PASS = in.nextLine();

    //Constructing the database URL connection string
    DB_URL = DB_URL + DBNAME + ";user="+ USER + ";password=" + PASS;

    //initialize the connection
    Connection conn = null; 
    
    //initialize the statement that we're using
    Statement stmt = null;  
    

    try {
        //STEP 2: Register JDBC driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        //STEP 3: Open a connection
        conn = DriverManager.getConnection(DB_URL);

        
        //STEP 4: Execute a query
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        
        //STEP 5: Extract data from result set

        

        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
        
    } 
    //Handle errors for JDBC
    catch (SQLException se) {
        
        se.printStackTrace();
    }
    //Handle errors for Class.forName
    catch (Exception e) {
        
        e.printStackTrace();
    }
    //finally block used to close resources
    finally {
        
        try {
            
            if (stmt != null) {
                stmt.close();
            }
        } 
        // nothing we can do
        catch (SQLException se2) {}
        try {
            
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            
            se.printStackTrace();
        }//end finally try
    }//end try
}
        
    /**
    * Takes the input string and outputs "N/A" if the string is empty or null.
    * @param input The string to be mapped.
    * @return  Either the input string or "N/A" as appropriate.
    */
    public static String dispNull (String input) {
        //because of short circuiting, if it's null, it never checks the length.
        if (input == null || input.length() == 0)
            return "N/A";
        else
            return input;
    }
}
