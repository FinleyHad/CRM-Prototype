package com.crm;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IntegrationTest {

    static final String BASE_URL = "http://localhost:4567";

    @BeforeAll
    static void setup() 
    {
        // Assumes the server is running already (via Main.main())
        // Or start it in a thread if needed
    }

    @Test
    void testAddCustomerAndFetch() throws Exception 
    {
        HttpClient client = HttpClient.newHttpClient();

        // Step 1: POST a new customer
        String json = "{\"name\":\"Test User\",\"email\":\"test@example.com\",\"phone\":\"123456789\"}";
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/api/customers"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, postResponse.statusCode(), "Customer creation failed");

        // Step 2: GET customers
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/api/customers"))
                .GET()
                .build();

        HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        assertTrue(getResponse.body().contains("Test User"), "Customer not found in list");
    }
}
