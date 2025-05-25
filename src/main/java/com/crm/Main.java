package com.crm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Main {
    public static void main(String[] args) {
        port(4567); //Web server port
        staticFiles.location("public"); 

        //GsonBuilder with TypeAdapters for LocalDate and LocalDateTime
        Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDate.class,
            (JsonDeserializer<LocalDate>) (json, type, context) ->
                LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
        .registerTypeAdapter(LocalDate.class,
            (com.google.gson.JsonSerializer<LocalDate>) (src, type, context) ->
                new com.google.gson.JsonPrimitive(src.toString()))
        .registerTypeAdapter(LocalDateTime.class,
            (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
        .create();

        CRMSystem crm = CRMSystem.getInstance();
        crm.registerObserver(new TaskObserver() {
            @Override
            public void notify(Task task) {
                System.out.println("New task added: " + task.getDescription());
            }
        });

        // CUSTOMERS
        get("/api/customers", (req, res) -> {
            res.type("application/json");
            return gson.toJson(crm.getCustomers());
        });

        post("/api/customers", (req, res) -> {
            Customer newCustomer = gson.fromJson(req.body(), Customer.class);
            crm.addCustomer(newCustomer);
            res.status(201);
            System.out.println("Received customer: " + newCustomer.getName());
            return "";
        });

        delete("/api/customers/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            CRMSystem.getInstance().removeCustomerById(id);
            return "Deleted";
        });
        //

        // TASKS
        get("/api/tasks", (req, res) -> {
            res.type("application/json");
            return gson.toJson(crm.getTasks());
        });

        post("/api/tasks", (req, res) -> {
            String body = req.body();
            System.out.println("TASK REQUEST RECEIVED");
            System.out.println("Raw JSON: " + body);

            try {
                Task newTask = gson.fromJson(body, Task.class);
                if (newTask == null) throw new IllegalArgumentException("Parsed task is null");

                System.out.println("Parsed task:");
                System.out.println(" - Description: " + newTask.getDescription());
                System.out.println(" - Due Date: " + newTask.getDueDate());
                System.out.println(" - Customer ID: " + newTask.getCustomerId());

                crm.createTask(newTask);
                res.status(201);
                return "Task created successfully";
            } catch (Exception e) {
                res.status(400);
                System.err.println("Failed to parse or create task: " + e.getMessage());
                return "Task creation error: " + e.getMessage();
            }
        });
        //

        // COMMUNICATIONS
        get("/api/communications", (req, res) -> {
            res.type("application/json");
            return gson.toJson(crm.getCommunications());
        });

        post("/api/communications", (req, res) -> {
            String body = req.body();
            System.out.println("COMMUNICATION REQUEST RECEIVED");
            System.out.println("Raw JSON: " + body);

            try
            {
                Communication comm = gson.fromJson(body, Communication.class);
                if (comm == null) throw new IllegalArgumentException("Parsed communication is null");

                System.out.println("Parsed communication:");
                System.out.println(" - Type: " + comm.getType());
                System.out.println(" - Content: " + comm.getContent());
                System.out.println(" - Date: " + comm.getDate());
                System.out.println(" - Customer ID: " + comm.getCustomerId());

                crm.createCommunication(comm);
                res.status(201);
                return "Communication logged";
            } 
            catch (Exception e) 
            {
                res.status(400);
                System.err.println("Failed to parse or log communication: " + e.getMessage());
                return "Communication error: " + e.getMessage();
            }
        });

        //Direct Messages
        get("/api/communications/customer/:id", (req, res) -> {
            int customerId = Integer.parseInt(req.params("id"));
            List<Communication> all = CRMSystem.getInstance().getCommunications();
            List<Communication> result = all.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .toList();

            res.type("application/json");
            return new Gson().toJson(result);
        });
        //


        // REPORT
        get("/api/report", (req, res) -> {
            res.type("text/plain");
            return crm.generateReport().toString();
        });

        post("/api/report", (req, res) -> {
            Report report = crm.generateReport();
            report.print();
            res.status(200);
            return "Report printed to console";
        });
        //

        //Gives the terminal the link to the web page
        System.out.println("CRM system running at http://localhost:4567");

        //Filter customers by query string
        get("/api/customers/search", (req, res) -> {
            String query = req.queryParams("q");
            res.type("application/json");

            List<Customer> allCustomers = crm.getCustomers();
            List<Customer> filtered = CustomerFilter.filter(allCustomers, query);

            return gson.toJson(filtered);
        });

    }
    
}
