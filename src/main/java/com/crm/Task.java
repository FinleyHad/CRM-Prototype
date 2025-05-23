package com.crm;
import java.time.LocalDate;

public class Task 
{
    private static int nextID = 1;
    private final int id;
    private final String description;
    private final LocalDate dueDate;
    private boolean completed;
    private final int customerID;

    //Constructer that defines a task
    public Task(String description, LocalDate dueDate, int customerId) 
    {
        this.id = nextID++;
        this.description = description;
        this.dueDate = dueDate;
        this.customerID = customerId;
        this.completed = false;
    }

    public int getId() 
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public LocalDate getDueDate() 
    {
        return dueDate;
    }

    public boolean isCompleted() 
    {
        return completed;
    }

    public int getCustomerId() 
    {
        return customerID;
    }

    public void completeTask() 
    {
       this.completed = true; 
    }
}
