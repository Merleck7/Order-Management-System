package com.meli.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Order Management System application.
 * 
 * Developed as part of Challenge 5 - Sprint 1
 * Author: [Tu Nombre]
 */
@SpringBootApplication
public class OrderManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
        System.out.println("🚀 Order Management System is running...");
    }
}
