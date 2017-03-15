/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs323_jdbcproject;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Elena Tsoi-A-Sue and Dania Wareh (tweaking from Mimi Opkins and Dave Brown)
 */
public class CECS323_JDBCProject {

    //  Database credentials
    static String USER;
    static String PASS;
    static String DBNAME;
    
    /*
    This is the specification for the printout that I'm doing:
    each % denotes the start of a new field.
    The - denotes left justification.
    The number indicates how wide to make the field.
    The "s" denotes that it's a string.  All of our output in this test are
    strings, but that won't always be the case.
    */
    //Display for Writing Groups (varchar(20), varchar(30), date(year only), varchar(20))
    static final String groupDisplayFormat="%-25s%-35s%-9s%-25s\n";
    
    //Display for Publishers (varchar(30), varchar(20), varchar(10), varchar(30))
    static final String pubDisplayFormat="%-35s%-25s%-15s%-35s\n";
    
    //Display for Books (including Writing Group and Publisher info)
    //()
    static final String bookDisplayFormat="%-5s%-15s%-15s%-15s\n";
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/";
//            + "testdb;user=";
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

    public static void main(String[] args) {
        //Prompt the user for the database name, and the credentials.
        //If your database has no credentials, you can update this code to
        //remove that from the connection string.
        Scanner in = new Scanner(System.in);
        System.out.print("Name of the database (not the user account): ");
        DBNAME = in.nextLine();
        System.out.print("Database user name: ");
        USER = in.nextLine();
        System.out.print("Database password: ");
        PASS = in.nextLine();
        //Constructing the database URL connection string
        DB_URL = DB_URL + DBNAME + ";user="+ USER + ";password=" + PASS;
        Connection conn = null; //initialize the connection
        Statement stmt = null;  //initialize the statement that we're using
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT au_id, au_fname, au_lname, phone FROM Authors";
            ResultSet rs = stmt.executeQuery(sql);
            
            
        boolean done = false;
        
        while(!done) {
            int menu1Choice = getIntInput("\n1) List Writing Groups"
                    + "\n2)  List All Data For A Specific Group"
                    + "\n3)  List All Publishers"
                    + "\n4)  List All Data For A Specific Publisher"
                    + "\n5)  List All Book Titles"
                    + "\n6)  List All Data for A Specific Title"
                    + "\n7)  Insert A Book"
                    + "\n8)  Insert A New Publisher & Update All Books"
                    + "\n9)  Remove A Book"
                    + "\n10) Quit\n");
            
            switch(menu1Choice) {
                case 1:
                    //1) List Writing Groups
                    break;
                case 2:
                    //2) List All Data For A Specific Group
                    break;
                case 3:
                    //3) List All Publishers
                    break;
                case 4:
                    //4) List All Data For A Specific Publisher
                    break;
                case 5:
                    //5) List All Book Titles
                    break;
                case 6:
                    //6) List All Data for A Specific Title
                    break;
                case 7:
                    //7) Insert A Book
                    break;
                case 8:
                    //8) Insert A New Publisher & Update All Books
                    break;
                case 9:
                    //9) Remove A Book
                    break;
                case 10: 
                    //10) Quit
                    done = true;
                    break;
                default: System.out.println("Invalid menu selection. Please try again");
            }
        }
        
    }
            
            
  
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "ID", "First Name", "Last Name", "Phone #");
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("au_id");
                String phone = rs.getString("phone");
                String first = rs.getString("au_fname");
                String last = rs.getString("au_lname");

                //Display values
                System.out.printf(displayFormat,
                        dispNull(id), dispNull(first), dispNull(last), dispNull(phone));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample}
