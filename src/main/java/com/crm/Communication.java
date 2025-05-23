package com.crm;
import java.time.LocalDate;
import java.util.List;

public class Communication 
{
    //Information on the entity being added
    private static int nextId = 1;
    private final int id;
    private final String type;
    private final LocalDate date;
    private final String notes;
    private final List<String> tags;
    private final int customerId;

    //Allows for set interaction between the bussines and costumer
    public Communication(String type, LocalDate date, String notes, List<String> tags, int customerId) 
    {
        this.id = nextId++;
        this.type = type;
        this.date = date;
        this.notes = notes;
        this.tags = tags;
        this.customerId = customerId;
    }

    public int getId() 
    {
        return id;
    }

    public String getType() 
    {
        return type;
    }

    public LocalDate getDate() 
    {
        return date;
    }

    public String getNotes() 
    {
        return notes;
    }

    public List<String> getTags() 
    {
        return tags;
    }

    public int getCustomerId() 
    {
        return customerId;
    }
    
    @Override
    public String toString() {
        return String.format("Communication #%d: %s with Customer %d on %s\nTags: %s\nNotes: %s\n",
                id, type, customerId, date, tags.toString(), notes);
    }
}
