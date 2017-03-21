//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Elena
// */
//public class methods {
//    
//    public void mainMenu()
//    {
//        System.out.print("\n1) List Writing Groups"
//                    + "\n2)  List All Data For A Specific Group"
//                    + "\n3)  List All Publishers"
//                    + "\n4)  List All Data For A Specific Publisher"
//                    + "\n5)  List All Book Titles"
//                    + "\n6)  List All Data for A Specific Title"
//                    + "\n7)  Insert A Book"
//                    + "\n8)  Insert A New Publisher & Update All Books"
//                    + "\n9)  Remove A Book"
//                    + "\n10) Quit\n");
//    }
//    
//    public void listGroups(Connection conn)
//    {
//        //list all writing groups in the database
//          Statement selectStmt;
//        try {
//            selectStmt = conn.createStatement();
//            String sql;
//            sql = "SELECT groupName FROM WRITINGGROUPS;";
//            ResultSet rs = selectStmt.executeQuery(sql);
//            
//            do{
//                System.out.println(rs.getString("groupName"));
//                  
//            }while(rs.next());
//        
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//  
//    }
//    
//    
//    public void listDataGroup(){
//        //list all the data of a specific group
//        
//    //SELECT
//    /*String selectStr = "SELECT " + targetAttr + " FROM " + DB_NAME + "." + table +
//            "WHERE " + whereAttr + "="*/
//    
//    //LIST ITEMS
//    String selectStr = "SELECT " + targetAttr + " FROM " + DBNAME + "." + table;
//    
//    //LIST DATA
//    String selectInstStr = "SELECT * FROM " + DBNAME + "." + table +
//            " WHERE " + targetAttr + "=" + instance;
//    
//    //ADD BOOK
//    String addBookStr = "INSERT INTO " + DBNAME + ".BOOKS VALUES (?,?,?,?,?)";
//    
//    //REMOVE BOOK
//    String removeBook = "DELETE FROM " + DBNAME + "." + table +
//            " WHERE " + pkAttr + "=" + primaryKey;
//    
//    //ADD PUBLISHER
//    String addPubStr = "INSERT INTO " + DBNAME + ".PUBLISHERS VALUES (?,?,?,?)";
//    
//    //UPDATE PUBLISHER
//    String updateStr = "UPDATE " + DBNAME + ".BOOKS SET publisherName=" +
//            newPublisher + " WHERE publisherName=" + oldPublisher;
//    
//    
//    public void listGroups();
//    
//    public void listGroupData(WritingGroup group);
//    
//    public void listPublishers();
//    
//    public void listPublisherData(Publisher pub);
//    
//    public void listBooks();
//        
//<<<<<<< HEAD
//    }
//    
//    
//    public void listPublishers(Connection conn){
//
//        //List all the publishers in the database
//         Statement selectStmt;
//        try {
//            selectStmt = conn.createStatement();
//            String sql;
//            sql = "SELECT publisherName FROM PUBLISHERS;";
//            ResultSet rs = selectStmt.executeQuery(sql);
//            
//            do{
//                System.out.println(rs.getString("publisherName"));
//                  
//            }while(rs.next());
//        
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        
//    }
//    
//    public void listDataPublisher(){
//        //List all the data for a specific publisher
//        
//    }
//    
//    public void listTitles(Connection conn){
//        
//        //list all the titles in the database
//        
//        Statement selectStmt;
//        try {
//            selectStmt = conn.createStatement();
//            String sql;
//            sql = "SELECT bookTitles FROM BOOKS;";
//            ResultSet rs = selectStmt.executeQuery(sql);
//            
//            do{
//                System.out.println(rs.getString("bookTitle"));
//                  
//            }while(rs.next());
//        
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//  
//    }
//    
//    public void listDataTitle(Connection conn, String bookTitle, String groupName){
//        //user needs to input groupname and booktitle. need to ask for the 
//        //primary keys to properly identify one book. 
//        //list all the data for a specific title
//         Statement selectStmt;
//        try {
//            String sql;
//             sql = "SELECT * BOOKS natural join WRITINGGROUPS natural join PUBLISHERS"
//                    + "where bookTitle = ? AND groupName = ? ;";
//            selectStmt = conn.prepareStatement(sql);
//            
//            selectStmt.setString(1, bookTitle );
//            selectStmt.setString(2, groupName );
//           
//            ResultSet rs = selectStmt.executeQuery();
//     
//            do{
//                System.out.print(rs.getString("bookTitle")));
//                System.out.print(rs.getString("groupName")));
//                ystem.out.print(rs.getString("publisher")));
//                
//                  
//            }while(rs.next());
// 
//        } catch (SQLException ex) {
//            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }
//    
//    
//    public void insertBook( ){
//        
//        // adds a book to the database
//      
//        
//        
//        
//    }
//    
//    public void insertPublisher(){
//        
//        // insert a publisher. Not sure if updating all the books should also 
//        // be its own method. 
//    }
//    
//    public void removeBook(){
//        //remove book from the database
//        //getting the deleted album
//       
//    }
//    
//    
//=======
//    public void listBookData(Book title);
//    
//    public void addBook();
//    
//    public void addPublisher();
//    
//    public Book removeBook();
//>>>>>>> origin/master
//}
