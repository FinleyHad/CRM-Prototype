package com.crm;
import java.util.ArrayList;
import java.util.List;

public class CRMSystem {
    private static CRMSystem instance;
    private List<Customer> customers;
    private List<Task> tasks;
    private List<Communication> communications;
    private final TaskNotifier taskNotifier = new TaskNotifier();

    //Singelton class allows for a single instance of the system
    private CRMSystem() 
    {
        customers = new ArrayList<>();
        tasks = new ArrayList<>();
        communications = new ArrayList<>();
    }

    //Allows other classes to get the instance of the system
    public static CRMSystem getInstance() 
    {
     if (instance == null) {
            instance = new CRMSystem();
        }
        return instance;
    }

    public void addCustomer(Customer customer) 
    {
        customers.add(customer);
    }

    //Creats a task if customer is found then notifies the system
    public void createTask(Task task) 
    {
        Customer customer = findCustomerById(task.getCustomerId());
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        tasks.add(task);
        taskNotifier.notifyObservers(task);
    }

    //Creats a text based communication between the customer and the bussines
    public void createCommunication(Communication communication) 
    {
        Customer customer = findCustomerById(communication.getCustomerId());
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        communications.add(communication);
        customer.addNote("Logged a " + communication.getType() + " on " + communication.getDate());
    }

    //Creats a report of the overall system inclouding incompleted/completeed tasks, number of customers, cummunications, and tasks
    public Report generateReport() 
    {
        List<Customer> customersList = getCustomers();
        List<Task> tasksList = getTasks();
        List<Communication> commsList = getCommunications();

        int totalCustomers = customersList.size();
        int totalTasks = tasksList.size();
        long completedTasks = tasksList.stream().filter(Task::isCompleted).count();
        long overdueTasks = tasksList.stream().filter(t -> !t.isCompleted() && t.getDueDate().isBefore(java.time.LocalDate.now())).count();
        int totalCommunications = commsList.size();


        StringBuilder content = new StringBuilder();
        content.append("=== CRM Report ===\n")
            .append("Total Customers: ").append(totalCustomers).append("\n")
            .append("Total Tasks: ").append(totalTasks).append("\n")
            .append("Completed Tasks: ").append(completedTasks).append("\n")
            .append("Overdue Tasks: ").append(overdueTasks).append("\n")
            .append("Total Communications: ").append(totalCommunications).append("\n");

        return new Report(content.toString());
    }

    //Returns a customer ID through a filtered data pipeline if it exists 
    private Customer findCustomerById(int id) 
    {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    //Adds a new observer
    public void registerObserver(TaskObserver observer) 
    {
         taskNotifier.addObserver(observer);
    }

    public List<Customer> getCustomers() 
    {
    if (customers == null) 
    {
        customers = new ArrayList<>();
    }
    return customers;
    }
    public List<Task> getTasks() 
    {
        if (tasks == null) 
        {
            tasks = new ArrayList<>();
        }
        return tasks;
    }
    public List<Communication> getCommunications() 
    {
        if (communications == null) 
        {
            communications = new ArrayList<>();
        }
        return communications;
    }
    public void removeCustomerById(int id) 
    {
        customers.removeIf(c -> c.getId() == id);
    }


}   