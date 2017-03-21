/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs323_jdbcproject;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    static String DB_URL = "jdbc:derby://localhost:1527/test1;user=test;password=test";
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
                    String[] bColumn = {"group name", "book title", "publisher", 
                    "year published", "number of pages"};
                    String[] bookInfo = new String[5];
                    
                    for(int i = 0; i < bookInfo.length; i++) {
                        
                        System.out.println("Enter " + bColumn[i] + ": ");
                        bookInfo[i] = in.nextLine();
                    }
                    
                    //checkGroup(conn, stmt, table, attr, val);
                    checkFK(conn, stmt, "WRITINGGROUPS", "GROUPNAME", bookInfo[0]);
                    checkFK(conn, stmt, "PUBLISHERS", "PUBLISHERNAME", bookInfo[2]);
                    
                    insertBook(conn, stmt, bookInfo);
                    break;
                    
                case 8:
                    //8) Insert A New Publisher & Update All Books
                    
                    String[] pubInfo = new String[4];
                    
                    String[] pColumn = {"name", "address", "phone", "email"};
                    
                    for(int i = 0; i < pubInfo.length; i++) {
                        
                        System.out.println("Enter new publisher's " + pColumn[i] + ": ");
                        pubInfo[i] = in.nextLine();
                    }
                    
                    addPublisher(conn, stmt, pubInfo);
                    
                    System.out.println("Enter old publisher name: ");
                    String oldPub = in.nextLine();
                    
                    updatePublisher(conn, stmt, pubInfo[0], oldPub);
                    
                    removeRec(conn, stmt, "PUBLISHERS", "PUBLISHERNAME", oldPub);
                    break;
                    
                case 9:
                    //9) Remove A Book
                    System.out.println("Enter book title: ");
                    String removeTitle = in.nextLine();
                    
                    removeRec(conn, stmt, "BOOKS", "BOOKTITLE", removeTitle);
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
        } 
        catch (SQLException ex) {
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
        } 
        catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //INSERT BOOK
    public static void insertBook(Connection conn, PreparedStatement stmt, String[] bookInfo) {
    
        System.out.println("TestInsert - insertBook");
        java.sql.Date converted = getSQLDate(Integer.parseInt(bookInfo[3]));
        
        try {
            
            String sql = "INSERT INTO "
                    + "BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages) "
                    + "VALUES((SELECT groupName FROM WRITINGGROUPS WHERE groupName=?), "
                    + "?, (SELECT publisherName FROM PUBLISHERS WHERE publisherName=?), "
                    + "?, ?)";
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, bookInfo[0]);
            stmt.setString(2, bookInfo[1]);
            stmt.setString(3, bookInfo[2]);
            stmt.setDate(4, converted);
            stmt.setInt(5, Integer.parseInt(bookInfo[4]));
            
            stmt.executeUpdate();
            
            System.out.println(bookInfo[1] + " has been inserted into the BOOKS table");
            
            stmt.close();
        } 
        catch (SQLException ex) {
            
            System.out.println("Record insert failed");
        }
    }// end insertBook
    
    //GET SQL DATE
    public static java.sql.Date getSQLDate(int year) {
        
        java.util.Date temp = new java.util.Date(year, 1, 1);
        return new java.sql.Date(temp.getTime());
    }// end getSQLDate
    
    //CHECK FOREIGN KEY
    public static void checkFK(Connection conn, PreparedStatement stmt, String table, String attr, String val) {
        
        try {
            String sql = "SELECT * FROM " + table + " WHERE " + attr + "=?";
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, val);
            
            ResultSet rs = stmt.executeQuery();
            
            if (!rs.next()) {
                
                System.out.println(val + " does not exist in the " + table + " table");
            }
            
            stmt.close(); 
        }
        catch (SQLException ex) {}
    }// end checkFK
    
    //ADD PUBLISHER
    public static void addPublisher(Connection conn, PreparedStatement stmt, String[] pubInfo) {
        
        try {
            
            String sql = "INSERT INTO PUBLISHERS "
                    + "VALUES(?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, pubInfo[0]);
            stmt.setString(2, pubInfo[1]);
            stmt.setString(3, pubInfo[2]);
            stmt.setString(4, pubInfo[3]);
            
            stmt.executeUpdate();
            
            System.out.println(pubInfo[0] + " has been inserted into PUBLISHERS table");
        }
        catch (SQLException ex) {}
    }// end addPublisher
    
    //UPDATE PUBLISHER
    public static void updatePublisher(Connection conn, PreparedStatement stmt, String newPub, String oldPub) {
        
        try {
            
            String sql = "UPDATE BOOKS SET publisherName=? WHERE publisherName=?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, newPub);
            stmt.setString(2, oldPub);
            
            stmt.executeUpdate();
            
            System.out.println(oldPub + " has been updated to " + newPub + " in BOOKS table");
        }
        catch (SQLException ex) {}
    }// end updatePublisher
    
    //REMOVE RECORD
    public static void removeRec(Connection conn, PreparedStatement stmt, String table, String attr, String remove) {
        
        try {
            
            String sql = "DELETE FROM " + table + " WHERE " + attr + "=?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, remove);
            
            stmt.executeUpdate();
            
            System.out.println(remove + " has been removed from the " + table + " table");
            
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }// end removeRec
    
}//end FirstExample}
