package com.crm;
public class Report 
{
    private final String content;

    //Creats a report for the bussines
    public Report(String content) 
    {
        this.content = content;
    }

    public String generate() 
    {
        return content;
    }

    public void print()
    {
        System.out.println(content);
    }
    
    @Override
    public String toString() 
    {
        return content; 
    }
}