package com.crm;
public class Report 
{
    private final String content;

    //Creats a report for the bussines
    public Report(String content) 
    {
        this.content = content;
    }

    //Generates the report
    public String generate() 
    {
        return content;
    }

    //Prints the report
    public void print()
    {
        System.out.println(content);
    }
   
    //Allows for the report to be printed in a readable format
    @Override
    public String toString() 
    {
        return content; 
    }
}