package com.crm;
import java.util.ArrayList;
import java.util.List;

public class TaskNotifier 
{
    //Observer pattern
    private final List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) 
    {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) 
    {
        observers.remove(observer);
    }

    public void notifyObservers(Task task) 
    {
        for (TaskObserver observer : observers) 
        {
            observer.notify(task);
        }
    }
}