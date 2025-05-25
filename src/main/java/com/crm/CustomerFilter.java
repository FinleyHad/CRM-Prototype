package com.crm;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFilter {

    // Filters customers by query string matching name, email, or phone
    public static List<Customer> filter(List<Customer> customers, String query) {
        if (query == null || query.isBlank()) {
            return customers;
        }

        String lowerQuery = query.toLowerCase();

        return customers.stream()
            .filter(c -> c.getName().toLowerCase().contains(lowerQuery)
                      || c.getEmail().toLowerCase().contains(lowerQuery)
                      || c.getPhone().toLowerCase().contains(lowerQuery))
            .collect(Collectors.toList());
    }
}
