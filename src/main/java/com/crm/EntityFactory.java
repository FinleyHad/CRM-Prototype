package com.crm;
import java.time.LocalDate;
import java.util.List;

public class EntityFactory 
{
    //Factory pattern
    //Creats the customer
    public static Customer createCustomer(String name, String email, String phone) 
    {
        return new Customer(name, email, phone);
    }

    //Creates a new task
    public static Task createTask(String description, LocalDate dueDate, int customerId) 
    {
        return new Task(description, dueDate, customerId);
    }

    //Creates a new comuunication 
    public static Communication createCommunication(String type, LocalDate date, String notes, List<String> tags, int customerId) 
    {
        return new Communication(type, date, notes, tags, customerId);
    }
}