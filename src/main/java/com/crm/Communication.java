package com.crm;

import java.time.LocalDate;

public class Communication {
    private static int nextId = 1;
    private final int id;
    private final String type;
    private final String content;
    private final LocalDate date;
    private final int customerId;

    //Constructor for Communication
    public Communication(String type, String content, LocalDate date, int customerId) 
    {
        this.id = nextId++;
        this.type = type;
        this.content = content;
        this.date = date;
        this.customerId = customerId;
    }

    //Getter methods for Communication
    public int getId() 
    {
        return id;
    }

    public String getType() 
    {
        return type;
    }

    public String getContent() 
    {
        return content;
    }

    public LocalDate getDate() 
    {
        return date;
    }

    public int getCustomerId() 
    {
        return customerId;
    }
} 
