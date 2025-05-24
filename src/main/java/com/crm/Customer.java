package com.crm;

import java.util.ArrayList;
import java.util.List;

public class Customer 
{
    private static int nextId = 1; // static shared counter

    private final int id;
    private final String name;
    private final String email;
    private final String phone;
    private final List<String> notes;

    //Constructor for Customer
    public Customer(String name, String email, String phone) 
    {
        this.id = nextId++; //auto-increment and assign
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.notes = new ArrayList<>();
    }

    //Getters needed for Gson to serialize
    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getPhone() 
    {
        return phone;
    }

    public List<String> getNotes() 
    {
        return notes;
    }

    public void addNote(String note) 
    {
        String timestampedNote = "(" + java.time.LocalDateTime.now() + ")" + note;
        notes.add(timestampedNote);
    }

    
}
