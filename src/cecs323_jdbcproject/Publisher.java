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
public class Publisher {
    
    private String pubName;
    private String pubAddress;
    private String pubPhone;
    private String pubEmail;
    
    public Publisher()
    {
        pubName = "";
        pubAddress = "";
        pubPhone = "";
        pubEmail = "";
    }
    
    public Publisher(String name, String address, String phone, String email)
    {
        pubName = name;
        pubAddress = address;
        pubPhone = phone;
        pubEmail = email;
    }
    
    public void setName(String name)
    {
        pubName = name;
    }
    
    public String getName()
    {
        return pubName;
    }
    
    public void setAddress(String address)
    {
        pubAddress = address;
    }
    
    public String getAddress()
    {
        return pubAddress;
    }
    
    public void setPhone(String phone)
    {
        pubPhone = phone;
    }
    
    public String getPhone()
    {
        return pubPhone;
    }
    
    public void setEmail(String email)
    {
        pubEmail = email;
    }
    
    public String getEmail()
    {
        return pubEmail;
    }
}
