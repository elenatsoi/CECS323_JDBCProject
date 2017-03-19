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
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/test;user=test;password=test";
    static Scanner in = new Scanner(System.in);
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
        
        Connection conn = null; //initialize the connection
        PreparedStatement stmt = null;  //initialize the statement that we're using
        
        try {
            
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            
            
            
        boolean done = false;
        
        while(!done) {
            
           mainMenu();
            
            int userInput = CheckInput.checkIntRange(1, 10);
            
            switch(userInput) {
                case 1:
                    //1) List Writing Groups
                    listResults(conn, stmt, "GROUPNAME", "WRITINGGROUPS");
                    break;
                    
                case 2:
                    //2) List All Data For A Specific Group
                    System.out.println("Enter the group name: ");
                    String group = in.nextLine();
                    listData(conn, stmt, "WRITINGGROUPS", "GROUPNAME", group);
                    break;
                    
                case 3:
                    //3) List All Publishers
                    listResults(conn, stmt, "PUBLISHERNAME", "PUBLISHERS");
                    break;
                    
                case 4:
                    //4) List All Data For A Specific Publisher
                    System.out.println("Enter the publisher name: ");
                    String pub = in.nextLine();
                    listData(conn, stmt, "PUBLISHERS", "PUBLISHERNAME", pub);
                    break;
                    
                case 5:
                    //5) List All Book Titles
                    listResults(conn, stmt, "BOOKTITLE", "BOOKS");
                    break;
                    
                case 6:
                    //6) List All Data for A Specific Title
                    System.out.println("Enter the book title: ");
                    String book = in.nextLine();
                    listData(conn, stmt, "BOOKS", "BOOKTITLE", book);
                    break;
                    
                case 7:
                    //7) Insert A Book
                    String[] column = {"group name", "book title", "publisher", 
                    "year published", "number of pages"};
                    String[] bookInfo = new String[5];
                    
                    for(int i = 0; i < 5; i++) {
                        
                        System.out.println("Enter " + column[i]);
                        bookInfo[i] = in.nextLine();
                    }
                    break;
                    
                case 8:
                    //8) Insert A New Publisher & Update All Books
                    break;
                    
                case 9:
                    //9) Remove A Book
                    System.out.println("Enter book title: ");
                    String removeTitle = in.nextLine();
                    removeBook(conn, stmt, removeTitle);
                    break;
                    
                case 10: 
                    //10) Quit
                    done = true;
                    break;
                    
                default: 
                    System.out.println("Invalid menu selection. Please try again");
                    break;
            }
        }            
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        } 
        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } 
        finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } 
            catch (SQLException se2) {}// nothing we can do
            
            try {
                if (conn != null) {
                    conn.close();
                }
            } 
            catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        
        System.out.println("Goodbye!");
    }//end main

    public static void mainMenu()
    {
        System.out.print("\n1)  List Writing Groups"
                    + "\n2)  List All Data For A Specific Group"
                    + "\n3)  List All Publishers"
                    + "\n4)  List All Data For A Specific Publisher"
                    + "\n5)  List All Book Titles"
                    + "\n6)  List All Data for A Specific Title"
                    + "\n7)  Insert A Book"
                    + "\n8)  Insert A New Publisher & Update All Books"
                    + "\n9)  Remove A Book"
                    + "\n10) Quit\n");
    }
    
    //LIST RESULTS
    public static void listResults(Connection conn, PreparedStatement stmt, String attr, String table)
    {
        //list all writing groups in the database
        
        try {

            String sql = "SELECT " + attr + " FROM " + table;
            stmt = conn.prepareStatement(sql);
              
            ResultSet rs = stmt.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numcols = rsmd.getColumnCount();
            
            while(rs.next()){
                for(int i = 1; i <= numcols; i++){
                    //System.out.format("%" + padding +  "s", rs.getString(i));
                    System.out.println(rs.getString(i));
                }
            }// end of while loop 
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //LIST DATA
    public static void listData(Connection conn, PreparedStatement stmt, String table, String attr, String target)
    {
        //list all writing groups in the database
        
        try {
//            String sql = "SELECT groupName FROM WRITINGGROUPS";        
//            stmt = conn.prepareStatement(sql);

            String sql = "SELECT * FROM " + table + " WHERE " + attr + "=?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, target);
              
            ResultSet rs = stmt.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int numcols = rsmd.getColumnCount();
            
            while(rs.next()){
                for(int i = 1; i <= numcols; i++){
                    //System.out.format("%" + padding +  "s", rs.getString(i));
                    System.out.println(rs.getString(i));
                }
            }// end of while loop 
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertBook(Connection conn, PreparedStatement stmt, String[] bookInfo) {
    
        try {
            
            String sql = "INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)"
                    + "VALUES(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, bookInfo[0]);
            stmt.setString(2, bookInfo[1]);
            stmt.setString(3, bookInfo[2]);
            stmt.setString(4, "1/1/"+bookInfo[3]);
            stmt.setInt(5, Integer.parseInt(bookInfo[4]));
            
            stmt.executeUpdate();
            
            System.out.println(bookInfo[1] + " has been add to table");
            
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void removeBook(Connection conn, PreparedStatement stmt, String remove) {
        
        try {
            
            String sql = "DELETE FROM BOOKS WHERE BOOKTITLE=?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, remove);
            
            stmt.executeUpdate();
            
            System.out.println(remove + " has been deleted from table");
            
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }

}//end FirstExample}
