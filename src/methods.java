/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elena
 */
public static class methods {
    
    public void mainMenu()
    {
        System.out.println("1) List all Writing Groups");
        System.out.println("2) List all Publishers");
        System.out.println("3) List all Book titles");
        System.out.println("4) Add new Book");
        System.out.println("5) Add new Publisher");
        System.out.println("6) Remove a Book");
    }
    
    //SELECT
    /*String selectStr = "SELECT " + targetAttr + " FROM " + DB_NAME + "." + table +
            "WHERE " + whereAttr + "="*/
    
    //LIST ITEMS
    String selectStr = "SELECT " + targetAttr + " FROM " + DBNAME + "." + table;
    
    //LIST DATA
    String selectInstStr = "SELECT * FROM " + DBNAME + "." + table +
            " WHERE " + targetAttr + "=" + instance;
    
    //ADD BOOK
    String addBookStr = "INSERT INTO " + DBNAME + ".BOOKS VALUES (?,?,?,?,?)";
    
    //REMOVE BOOK
    String removeBook = "DELETE FROM " + DBNAME + "." + table +
            " WHERE " + pkAttr + "=" + primaryKey;
    
    //ADD PUBLISHER
    String addPubStr = "INSERT INTO " + DBNAME + ".PUBLISHERS VALUES (?,?,?,?)";
    
    //UPDATE PUBLISHER
    String updateStr = "UPDATE " + DBNAME + ".BOOKS SET publisherName=" +
            newPublisher + " WHERE publisherName=" + oldPublisher;
    
    public void listGroups();
    
    public void listGroupData(WritingGroup group);
    
    public void listPublishers();
    
    public void listPublisherData(Publisher pub);
    
    public void listBooks();
        
    public void listBookData(Book title);
    
    public void addBook();
    
    public void addPublisher();
    
    public Book removeBook();
}
