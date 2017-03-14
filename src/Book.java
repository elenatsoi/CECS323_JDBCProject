/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniawareh
 */
public class Book {
    
    private String title;
    private int YearPublished;
    private int NumberPages; 
    private WritingGroup group;
    private Publisher publisher;
    
    public Book(){
        group = new WritingGroup();
        publisher = new Publisher();
        
    }
    

    public Book(String t, int yp, int numPages){
    title = t;
    YearPublished = yp;
    NumberPages = numPages;

    }
    
    public WritingGroup getGroup(){
        return group;
        
    }
    public Publisher getPublisher(){
        return publisher;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getYearPublished(){
        return YearPublished;
    }
    
    public int getNumberPages(){
        return NumberPages;
    }
    
    public void setGroup( WritingGroup wg){
        group = wg;
        
    }
    
    public void setPublisher (Publisher p){
        publisher = p;
    }
    
    public void setTitle(String t){
        title = t;
        
    }
    
    public void setYearPublished(int yp){
        YearPublished = yp; 
    }
    
    public void setNumberPages(int np){
        NumberPages = np;
    }
}



