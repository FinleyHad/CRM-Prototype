package com.crm;

import java.time.LocalDate;

public class Task {
    private static int nextId = 1;
    private final int id;
    private final String description;
    private final LocalDate dueDate;
    private final int customerId;
    private boolean completed;

    public Task(String description, LocalDate dueDate, int customerId) {
        this.id = nextId++;
        this.description = description;
        this.dueDate = dueDate;
        this.customerId = customerId;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeTask() {
        this.completed = true;
    }
} 
