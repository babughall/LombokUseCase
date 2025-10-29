package com.example.integration;

import com.example.model.User;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.Address;
import com.example.service.UserService;
import com.example.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Enterprise Integration Business Logic Demo
 * 
 * This demo focuses on real business workflows and their results
 * that should remain consistent before and after Lombok transformation.
 */
public class SimplifiedIntegrationDemo {

    private UserService userService = new UserService();
    private OrderService orderService = new OrderService();

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("                    ENTERPRISE INTEGRATION BUSINESS DEMO                      ");
        System.out.println("================================================================================");
        
        SimplifiedIntegrationDemo demo = new SimplifiedIntegrationDemo();
        
        demo.ecommerceRegistrationFlow();
        demo.orderProcessingWorkflow();
        demo.customerServiceWorkflow();
        
        System.out.println("================================================================================");
        System.out.println("Enterprise integration workflows completed successfully");
        System.out.println("================================================================================");
    }

    private void ecommerceRegistrationFlow() {
        System.out.println("\n1. E-COMMERCE REGISTRATION FLOW");
        System.out.println("Processing new customer registration...");
        
        try {
            // Step 1: User registration
            User newUser = userService.registerUser(
                "sarah.wilson.2024",
                "sarah.wilson@shopexample.com",
                "SecurePass2024!",
                "Sarah",
                "Wilson",
                "Elizabeth",
                "+1-555-234-5678",
                null,
                LocalDate.of(1985, 3, 22),
                "FEMALE",
                "Canadian",
                "en",
                "America/Toronto",
                "CAD",
                true,
                true,
                "FRIEND2024",
                "STANDARD",
                null,
                null,
                null,
                null,
                Map.of("signup_source", "mobile_app",
                       "marketing_campaign", "spring_sale_2024",
                       "device_type", "iPhone"),
                Arrays.asList("fashion", "electronics",
                             "home_decor", "books"),
                "MOBILE_APP",
                "REGISTRATION_SERVICE"
            );
            
            // Step 2: Default shipping address
            Address shippingAddress = new Address(
                "ADDR_SHIP_" + System.currentTimeMillis(), 
                "SHIPPING",
                "789 Maple Street",
                "Unit 12",
                "Toronto",
                "ON",
                "M5V 3A8",
                "Canada",
                "CA",
                "Ontario",
                "Downtown",
                "CN Tower area",
                "+1-555-234-5678",
                "Sarah Wilson",
                null,
                true,
                false,
                "PENDING",
                43.6426,
                -79.3871,
                "America/Toronto",
                "Apartment building, buzz unit 12",
                "Building code: 5589",
                false,
                false,
                null,
                "REGISTRATION_SERVICE"
            );
            
            // Step 3: Billing address
            Address billingAddress = new Address(
                "ADDR_BILL_" + System.currentTimeMillis(),
                "BILLING", 
                "789 Maple Street",
                "Unit 12",
                "Toronto",
                "ON", 
                "M5V 3A8",
                "Canada",
                "CA",
                "Ontario",
                "Downtown",
                "CN Tower area",
                "+1-555-234-5678",
                "Sarah Wilson",
                null,
                false,
                false,
                "PENDING", 
                43.6426,
                -79.3871,
                "America/Toronto",
                "Same as shipping address",
                "Building code: 5589",
                false,
                false,
                null,
                "REGISTRATION_SERVICE"
            );
            
            System.out.println("Registration flow completed successfully");
            System.out.println("New user: " + newUser.getDisplayName());
            System.out.println("Email: " + newUser.getEmail());
            System.out.println("Shipping address: " + shippingAddress.getFullAddress());
            System.out.println("Billing address: " + billingAddress.getFullAddress());
            
        } catch (Exception e) {
            System.out.println("Registration flow failed: " + e.getMessage());
        }
    }

    private void orderProcessingWorkflow() {
        System.out.println("\n2. ORDER PROCESSING WORKFLOW");
        System.out.println("Processing complete order lifecycle...");
        
        try {
            Address shipping = new Address("123 Customer St", "Customer City", "CA", "90210", "US");
            Address billing = new Address("456 Billing Ave", "Billing City", "CA", "90211", "US");
            
            // Create order items
            OrderItem laptop = new OrderItem(
                "ITEM_LAPTOP_" + System.currentTimeMillis(),
                "PROD_LAPTOP_001",
                "MacBook Pro 16-inch M3",
                "MBP-16-M3-SILVER",
                "Computers",
                "Apple", 
                "16-inch MacBook Pro with M3 chip, 18GB RAM, 512GB SSD",
                "https://store.apple.com/macbook-pro-16.jpg",
                new BigDecimal("2799.00"),
                1,
                "USD",
                new BigDecimal("2.1"),
                "35.57 x 24.81 x 1.68 cm",
                false,
                false,
                null,
                null,
                "VAR_SILVER_18GB_512GB",
                "Silver, 18GB RAM, 512GB SSD",
                "SUPPLIER_APPLE",
                "WAREHOUSE_WEST_COAST",
                false,
                LocalDateTime.now().plusDays(2)
            );
            
            OrderItem mouse = new OrderItem(
                "ITEM_MOUSE_" + System.currentTimeMillis(),
                "PROD_MOUSE_001", 
                "Magic Mouse",
                "MAGIC-MOUSE-WHITE",
                "Accessories",
                "Apple",
                "Magic Mouse with Multi-Touch surface",
                "https://store.apple.com/magic-mouse.jpg",
                new BigDecimal("99.00"),
                1,
                "USD",
                new BigDecimal("0.099"),
                "11.35 x 5.71 x 2.16 cm",
                false,
                false,
                null,
                null,
                "VAR_WHITE",
                "White",
                "SUPPLIER_APPLE",
                "WAREHOUSE_WEST_COAST", 
                false,
                LocalDateTime.now().plusDays(1)
            );
            
            List<OrderItem> orderItems = Arrays.asList(laptop, mouse);
            
            // Create order
            Order order = orderService.createOrder(
                "CUSTOMER_SARAH_001",
                "sarah.wilson@shopexample.com",
                "+1-555-234-5678",
                "CREDIT_CARD",
                null,
                shipping,
                billing,
                "STANDARD", 
                "NORMAL",
                false,
                null,
                null,
                "NEWCUSTOMER10",
                null,
                "WEB",
                orderItems,
                "Please handle with care - electronics",
                "ORDER_PROCESSOR"
            );
            
            // Process payment
            boolean paymentSuccess = orderService.processPayment(
                order.getOrderId(),
                "CREDIT_CARD",
                new BigDecimal("2902.39"),
                "USD",
                "4532015112830366",
                "12",
                "2026",
                "123",
                "Sarah Wilson",
                null,
                null,
                null,
                true,
                "Apple products purchase - MacBook Pro + accessories",
                Map.of("ip_address", "192.168.1.50",
                       "browser", "Safari 17.0",
                       "device", "iPhone 15"),
                "PAYMENT_GATEWAY"
            );
            
            // Update order status
            Order finalOrder = orderService.updateOrder(
                order.getOrderId(),
                "CONFIRMED",
                "HIGH",
                "PAID",
                "EXPEDITED",
                "UPS",
                null,
                LocalDateTime.now().plusDays(3),
                null, 
                new BigDecimal("15.99"),
                new BigDecimal("232.19"),
                new BigDecimal("293.70"),
                "NEWCUSTOMER10",
                false,
                false,
                null,
                null,
                null,
                null,
                "Handle with care - high value electronics order",
                Map.of("expedited_reason", "new_customer_priority",
                       "special_handling", "fragile_electronics"),
                Arrays.asList("new-customer", "high-value", "electronics"),
                "ORDER_FULFILLMENT_SYSTEM"
            );
            
            System.out.println("Order processing workflow completed successfully");
            System.out.println("Order ID: " + finalOrder.getOrderId());
            System.out.println("Order total: $" + finalOrder.getTotalAmount());
            System.out.println("Payment status: " + (paymentSuccess ? "SUCCESS" : "FAILED"));
            System.out.println("Order status: " + finalOrder.getOrderStatus());
            System.out.println("Priority: " + finalOrder.getPriority());
            
        } catch (Exception e) {
            System.out.println("Order workflow failed: " + e.getMessage());
        }
    }

    private void customerServiceWorkflow() {
        System.out.println("\n3. CUSTOMER SERVICE WORKFLOW");
        System.out.println("Processing customer support request...");
        
        try {
            // Customer lookup
            List<User> searchResults = userService.searchUsers(
                "sarah",
                null,
                "Sarah",
                null,
                "STANDARD",
                "ACTIVE",
                true,
                null,
                null,
                null,
                "en",
                null,
                null,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(1990, 12, 31),
                LocalDateTime.now().minusMonths(6),
                null,
                Arrays.asList("customer"),
                Map.of("signup_source", "mobile_app"),
                "firstName",
                "ASC",
                10,
                1,
                "CUSTOMER_SERVICE"
            );
            
            System.out.println("Customer lookup completed");
            System.out.println("Customers found: " + searchResults.size());
            
            // Address change simulation
            if (!searchResults.isEmpty()) {
                User customer = searchResults.get(0);
                
                // Update customer profile with new address preferences
                User updatedCustomer = userService.updateUserProfile(
                    customer.getId(),
                    null, // firstName - no change
                    null, // lastName - no change  
                    null, // middleName - no change
                    null, // displayName - no change
                    null, // email - no change
                    "+1-555-999-0000", // new phone number
                    null, // alternatePhoneNumber - no change
                    null, // dateOfBirth - no change
                    null, // gender - no change
                    null, // nationality - no change
                    null, // preferredLanguage - no change
                    "America/Vancouver", // new timezone
                    null, // currencyPreference - no change
                    null, // profilePictureUrl - no change
                    "Updated profile via customer service", // new bio
                    null, // website - no change
                    null, // company - no change
                    null, // jobTitle - no change
                    null, // marketingOptIn - no change
                    null, // newsletterOptIn - no change
                    Map.of("last_update_reason", "customer_service",
                           "service_rep", "REP_001"), // add custom attributes
                    null, // interests - no change
                    Arrays.asList("customer", "updated"), // new tags
                    null, // securityQuestion - no change
                    null, // securityAnswer - no change
                    null, // twoFactorEnabled - no change
                    "EMAIL", // new notification preference
                    "CUSTOMER_SERVICE_REP"
                );
                
                System.out.println("Customer profile updated successfully");
                System.out.println("Customer: " + updatedCustomer.getDisplayName());
                System.out.println("New phone: " + updatedCustomer.getPhoneNumber());
                System.out.println("New timezone: " + updatedCustomer.getTimeZone());
            }
            
            System.out.println("Customer service workflow completed successfully");
            
        } catch (Exception e) {
            System.out.println("Customer service workflow failed: " + e.getMessage());
        }
    }
}