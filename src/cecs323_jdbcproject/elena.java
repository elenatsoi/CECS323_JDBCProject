//import java.sql.*;
//import java.util.Scanner;
//import java.util.logging.*;
//
//public class CECS323_JDBCProject {
//
//	// Database credentials
//    static String USER;
//    static String PASS;
//    static String DBNAME;
//    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
//    static String DB_URL = "jdbc:derby://localhost:1527/";
//    
//    // Variables for Prepared statements
//    String targetAttr, table, instance, pkAttr, primaryKey, newPublisher, oldPublisher;
//    
//    // Prepared statements
//    //LIST ITEMS
//    //String selectStr = "SELECT " + targetAttr + " FROM " + DBNAME + "." + table;
//    //1) target attribute, 2) dbname, 3) table, 4) order attribute
//    static String selectStr = "SELECT ? FROM ?.? ORDER BY ?";
//    
//    //LIST DATA
//    //String selectInstStr = "SELECT * FROM " + DBNAME + "." + table + " WHERE " + targetAttr + "=" + instance;
//    //1) dbname, 2) table, 3) target attribute, 4) target value
//    static String selectInstStr = "SELECT * FROM ?.? WHERE ?='?'";
//    
//    //ADD BOOK
//    //String addBookStr = "INSERT INTO " + DBNAME + ".BOOKS VALUES (?,?,?,?,?)";
//    
//    
//    //REMOVE BOOK
//    //String removeBook = "DELETE FROM " + DBNAME + "." + table + " WHERE " + pkAttr + "=" + primaryKey;
//    
//    //ADD PUBLISHER
//    //String addPubStr = "INSERT INTO " + DBNAME + ".PUBLISHERS VALUES (?,?,?,?)";
//    
//    //UPDATE PUBLISHER
//    //String updateStr = "UPDATE " + DBNAME + ".BOOKS SET publisherName=" + newPublisher + " WHERE publisherName=" + oldPublisher;
//    
//    
//    //MAIN
//	public static void main(String[] args) {
//		
//		Scanner in = new Scanner(System.in);
//       
//		System.out.print("Name of the database (not the user account): ");
//        DBNAME = in.nextLine();
//        
//        System.out.print("Database user name: ");
//        USER = in.nextLine();
//        
//        System.out.print("Database password: ");
//        PASS = in.nextLine();
//        
//        //Constructing the database URL connection string
//        DB_URL = DB_URL + DBNAME + ";user="+ USER + ";password=" + PASS;
//        
//        Connection conn = null; //initialize the connection
//        PreparedStatement stmt = null; //initialize the statement that we're using
//        
//        try {
//            
//        	//STEP 2: Register JDBC driver
//            Class.forName("org.apache.derby.jdbc.ClientDriver");
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL);
//           
//            listResults(conn, stmt, selectStr, DBNAME, "WRITINGGROUPS", "GROUPNAME");
//            
//            listResultData();
//	        conn.close();
//	    } 
//		catch (SQLException se) {
//	    
//			//Handle errors for JDBC
//	        se.printStackTrace();
//	    } 
//		catch (Exception e) {
//	    
//			//Handle errors for Class.forName
//	        e.printStackTrace();
//	    } 
//		finally {
//	        
//			//finally block used to close resources
//	        try {
//	        
//	        	if (stmt != null) {
//	                stmt.close();
//	            }
//	        } 
//	        catch (SQLException se2) {}// nothing we can do
//	        
//	        try {
//	        
//	        	if (conn != null) {
//	                conn.close();
//	            }
//	        } 
//	        catch (SQLException se) {
//	        
//	        	se.printStackTrace();
//	        }//end finally try
//	    }//end try
//	    
//		System.out.println("Goodbye!");
//		
//	}//end MAIN
//	
//	
//	// LIST GENERIC
//	public void listResults(Connection conn, PreparedStatement stmt, String sql, String db, String table, String targetAttr) {
//		
//  sql.setString(1, targetAttr);
//  sql.setString(2, db);
//  sql.setString(3, table);
//  sql.setString(4, targetAttr);
//  
//	try {
//			
//			stmt = conn.prepareStatement();
//			ResultSet rs = selectStmt.executeQuery(sql);
//			
//			while( rs.next() ) {
//				
//				System.out.println(rs.getString("groupName"));			
//			}
//		}
//		catch (SQLException ex) {
//            
//			//Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//        }
//	}// end LIST GENERIC
//	
//	// LIST DATA GENERIC
//		public void listResultData(Connection conn, String sql, String db, String table, String targetAttr, String targetVal) {
//			
//      sql.setString(1, db);
//      sql.setString(2, table);
//      sql.setString(3, targetAttr);
//      sql.setString(4, targetVal);
//			
//			try {
//				
//				selectStmt = conn.createStatement();
//				ResultSet rs = selectStmt.executeQuery(sql);
//				
//				while( rs.next() ) {
//					
//					System.out.println(rs.getString("groupName"));			
//				}
//			}
//			catch (SQLException ex) {
//	            
//				//Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
//	        }
//		}// end LIST GENERIC
//	
//    }// end LIST GROUPS
//	
//	// DISPLAY NULL
//	public static String dispNull (String input) {
//        
//		//because of short circuiting, if it's null, it never checks the length.
//        if (input == null || input.length() == 0)
//            return "N/A";
//        else
//            return input;
//    }// end DISPLAY NULL
//}
