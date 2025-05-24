package com.crm;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CRMSystemTest {

    private CRMSystem crm;

    // Test class for CRMSystem
    @BeforeEach
    void setUp() 
    {
        crm = CRMSystem.getInstance();
        crm.getCustomers().clear();
        crm.getTasks().clear();
        crm.getCommunications().clear();
    }

    // Test to ensure the CRM system can add a customer, create a task, and create a communication
    @Test
    void testAddCustomer() 
    {
        Customer customer = new Customer("Alice", "alice@example.com", "1234567890");
        crm.addCustomer(customer);
        assertEquals(1, crm.getCustomers().size());
        assertEquals("Alice", crm.getCustomers().get(0).getName());
    }

    // Test to ensure the CRM system can create a task for an existing customer
    @Test
    void testCreateTask() 
    {
        Customer customer = new Customer("Bob", "bob@example.com", "0987654321");
        crm.addCustomer(customer);
        Task task = new Task("Follow up", LocalDate.now(), customer.getId());
        crm.createTask(task);
        assertEquals(1, crm.getTasks().size());
    }

    // Test to ensure the CRM system throws an exception when trying to create a task for a non-existing customer
    @Test
    void testCreateCommunication() 
    {
        Customer customer = new Customer("Eve", "eve@example.com", "1112223333");
        crm.addCustomer(customer);
        Communication comm = new Communication("email", "Hello", LocalDate.now(), customer.getId());
        crm.createCommunication(comm);
        assertEquals(1, crm.getCommunications().size());

    }

    // Test to ensure the CRM system throws an exception when trying to create a communication for a non-existing customer
    @Test
    void testCreateTaskWithInvalidCustomer() 
    {
        Task task = new Task("Invalid", LocalDate.now(), 999);
        assertThrows(IllegalArgumentException.class, () -> crm.createTask(task));
    }

    @Test
    void testObserverNotifiedOnTaskCreation() 
    {
        final boolean[] wasNotified = { false };

        crm.registerObserver(task -> wasNotified[0] = true);

        Customer customer = new Customer("Test", "t@example.com", "123");
        crm.addCustomer(customer);
        Task task = new Task("Notify test", LocalDate.now(), customer.getId());
        crm.createTask(task);

        assertTrue(wasNotified[0], "Observer should have been notified.");
    }

    // Test to ensure the CRM system generates a report with the correct information
    @Test
    void testReportIncludesTaskCount() 
    {
        Customer customer = new Customer("ReportGuy", "r@example.com", "321");
        crm.addCustomer(customer);
        crm.createTask(new Task("Do it", LocalDate.now(), customer.getId()));

        String report = crm.generateReport().toString();

        assertTrue(report.contains("Total Tasks: 1"));
        assertTrue(report.contains("Total Customers: 1"));
    }

    // Test to ensure the CRM system Throws an exception when trying to create a communication with an invalid customer ID
    @Test
    void testCreateCommunicationWithInvalidCustomer() 
    {
        Communication comm = new Communication("email", "Oops", LocalDate.now(), 999);
        assertThrows(IllegalArgumentException.class, () -> crm.createCommunication(comm));
    }

    // Test to ensure the CRM system generates a report with the correct number of communications
    @Test
    void testReportIncludesCommunicationCount() 
    {
        Customer customer = new Customer("Reporter", "report@example.com", "987");
        crm.addCustomer(customer);
        crm.createCommunication(new Communication("call", "Test call", LocalDate.now(), customer.getId()));
        String report = crm.generateReport().toString();
        assertTrue(report.contains("Total Communications: 1"));
    }
}
