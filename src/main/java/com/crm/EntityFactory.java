package com.crm;

import java.time.LocalDate;

/**
 * Factory class for creating CRM entities.
 */
public class EntityFactory {

    /**
     * Creates a new Customer.
     */
    public static Customer createCustomer(String name, String email, String phone) {
        return new Customer(name, email, phone);
    }

    /**
     * Creates a new Task.
     */
    public static Task createTask(String description, LocalDate dueDate, int customerId) {
        return new Task(description, dueDate, customerId);
    }

    /**
     * Creates a new Communication.
     */
    public static Communication createCommunication(String type, String content, LocalDate date, int customerId) {
        return new Communication(type, content, date, customerId);
    }
}
