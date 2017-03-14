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
public class WritingGroup {
    
    private String groupName;
    private String headWriter;
    private int yearFormed;
    private String subject;
    
    public WritingGroup()
    {
        groupName = "";
        headWriter = "";
        yearFormed = 0;
        subject = "";
    }
    
    public WritingGroup(String name, String head, int year, String sub)
    {
        groupName = name;
        headWriter = head;
        yearFormed = year;
        subject = sub;
    }
    
    /* GET/SET TEMPLATES
    
    public void set()
    {
        = ;
    }
    
    public String get()
    {
        return ;
    }*/
    
    public void setName(String name)
    {
        groupName = name;
    }
    
    public String getName()
    {
        return groupName;
    }
    
    public void setHead(String head)
    {
        headWriter = head;
    }
    
    public String getHead()
    {
        return headWriter;
    }
    
    public void setYear(int year)
    {
        yearFormed = year;
    }
    
    public int getYear()
    {
        return yearFormed;
    }
    
    public void setSubject(String sub)
    {
        subject = sub;
    }
    
    public String getSubject()
    {
        return subject;
    }
}
