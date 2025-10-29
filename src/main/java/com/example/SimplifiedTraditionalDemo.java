package com.example;

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
 * Traditional Java Enterprise Demonstration
 * 
 * This demo focuses on the actual business logic results that should
 * remain consistent before and after Lombok transformation.
 */
public class SimplifiedTraditionalDemo {

    private UserService userService = new UserService();
    private OrderService orderService = new OrderService();
    
    // Store created entities for use in subsequent operations
    private User createdUser;
    private Order createdOrder;

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("                    TRADITIONAL JAVA BUSINESS LOGIC DEMO                      ");
        System.out.println("================================================================================");
        
        SimplifiedTraditionalDemo demo = new SimplifiedTraditionalDemo();
        
        demo.createUser();
        demo.createAddresses(); 
        demo.createOrder();
        demo.processPayment();
        demo.updateUser();
        demo.searchUsers();
        
        System.out.println("================================================================================");
        System.out.println("Demo completed - business logic executed successfully");
        System.out.println("================================================================================");
    }

    private void createUser() {
        System.out.println("\n1. USER CREATION");
        System.out.println("Creating user with comprehensive profile...");
        
        try {
            createdUser = userService.registerUser(
                "johndoe2024",                          // username
                "john.doe@example.com",                 // email  
                "SecurePassword123!",                   // password
                "John",                                 // firstName
                "Doe",                                  // lastName
                "Michael",                              // middleName
                "+1-555-123-4567",                      // phoneNumber
                "+1-555-987-6543",                      // alternatePhoneNumber
                LocalDate.of(1990, 5, 15),             // dateOfBirth
                "MALE",                                 // gender
                "American",                             // nationality
                "en",                                   // preferredLanguage
                "America/New_York",                     // timeZone
                "USD",                                  // currencyPreference
                true,                                   // marketingOptIn
                false,                                  // newsletterOptIn
                "REFER123",                             // referralCode
                "PREMIUM",                              // userType
                "https://example.com/profile.jpg",      // profilePictureUrl
                "https://johndoe.com",                  // website
                "Acme Corporation",                     // company
                "Senior Developer",                     // jobTitle
                Map.of("department", "Engineering",     // customAttributes
                       "team", "Backend",
                       "startDate", "2020-01-15"),
                Arrays.asList("Java", "Spring",         // interests
                             "Microservices", "AI"),
                "WEB_REGISTRATION",                     // registrationSource
                "SYSTEM"                                // createdBy
            );
            
            System.out.println("User created successfully: " + createdUser.getDisplayName());
            System.out.println("Username: " + createdUser.getUsername());
            System.out.println("Email: " + createdUser.getEmail());
            System.out.println("User type: " + createdUser.getUserType());
            System.out.println("User ID: " + createdUser.getId());
            
        } catch (Exception e) {
            System.out.println("User creation failed: " + e.getMessage());
        }
    }

    private void createAddresses() {
        System.out.println("\n2. ADDRESS CREATION");
        System.out.println("Creating shipping and billing addresses...");
        
        try {
            Address shippingAddress = new Address(
                "ADDR_SHIP_" + System.currentTimeMillis(),
                "SHIPPING",
                "123 Main Street",
                "Apartment 4B",
                "New York",
                "NY",
                "10001",
                "United States",
                "US",
                "Northeast",
                "Manhattan",
                "Near Central Park",
                "+1-555-123-4567",
                "John Doe",
                null,
                true,
                true,
                "VERIFIED",
                40.7831,
                -73.9712,
                "America/New_York",
                "Leave at front desk",
                "Building code: 1234",
                false,
                false,
                null,
                "SYSTEM"
            );
            
            Address billingAddress = new Address(
                "ADDR_BILL_" + System.currentTimeMillis(),
                "BILLING",
                "456 Oak Avenue",
                "Suite 200",
                "Boston",
                "MA",
                "02101",
                "United States",
                "US",
                "Northeast",
                "Downtown",
                "Financial District",
                "+1-555-987-6543",
                "John Doe",
                "Acme Corporation",
                false,
                true,
                "VERIFIED",
                42.3601,
                -71.0589,
                "America/New_York",
                "Business address - accounting dept",
                null,
                true,
                true,
                "9 AM - 5 PM EST",
                "SYSTEM"
            );
            
            System.out.println("Addresses created successfully:");
            System.out.println("Shipping: " + shippingAddress.getFullAddress());
            System.out.println("Billing: " + billingAddress.getFullAddress());
            
        } catch (Exception e) {
            System.out.println("Address creation failed: " + e.getMessage());
        }
    }

    private void createOrder() {
        System.out.println("\n3. ORDER CREATION");
        System.out.println("Creating order with multiple items...");
        
        try {
            Address shipping = new Address("123 Ship St", "Ship City", "CA", "90210", "US");
            Address billing = new Address("456 Bill Ave", "Bill City", "CA", "90211", "US");
            
            OrderItem item1 = new OrderItem(
                "ITEM_1_" + System.currentTimeMillis(),
                "PROD_001",
                "Premium Laptop",
                "LAP-PREM-001",
                "Electronics",
                "TechBrand",
                "High-performance laptop for professionals",
                "https://example.com/laptop.jpg",
                new BigDecimal("1299.99"),
                2,
                "USD",
                new BigDecimal("3.5"),
                "14x10x1 inches",
                false,
                false,
                null,
                null,
                "VAR_001",
                "Space Gray",
                "SUPPLIER_TECH",
                "WAREHOUSE_WEST",
                false,
                LocalDateTime.now().plusDays(1)
            );
            
            OrderItem item2 = new OrderItem(
                "ITEM_2_" + System.currentTimeMillis(),
                "PROD_002",
                "Wireless Mouse",
                "MOUSE-WIRE-002",
                "Electronics",
                "TechBrand",
                "Ergonomic wireless mouse",
                "https://example.com/mouse.jpg",
                new BigDecimal("79.99"),
                1,
                "USD",
                new BigDecimal("0.3"),
                "5x3x2 inches",
                false,
                false,
                null,
                null,
                "VAR_002",
                "Black",
                "SUPPLIER_TECH",
                "WAREHOUSE_WEST",
                false,
                LocalDateTime.now().plusDays(1)
            );
            
            List<OrderItem> orderItems = Arrays.asList(item1, item2);
            
            // Use the created user's ID if available, otherwise use demo customer ID
            String customerId = (createdUser != null) ? createdUser.getId() : "CUSTOMER_12345";
            String customerEmail = (createdUser != null) ? createdUser.getEmail() : "customer@example.com";
            
            createdOrder = orderService.createOrder(
                customerId,
                customerEmail,
                "+1-555-123-4567",
                "CREDIT_CARD",
                null,
                shipping,
                billing,
                "EXPRESS",
                "HIGH",
                true,
                "Happy Birthday! Hope you love this!",
                "PREMIUM",
                "SAVE20",
                "FRIEND_REF_789",
                "MOBILE_APP",
                orderItems,
                "Please ring doorbell twice",
                "ORDER_SYSTEM"
            );
            
            System.out.println("Order created successfully: " + createdOrder.getOrderId());
            System.out.println("Order total: $" + createdOrder.getTotalAmount());
            System.out.println("Number of items: " + createdOrder.getItemCount());
            System.out.println("Gift order: " + createdOrder.isGift());
            System.out.println("Customer ID: " + customerId);
            
        } catch (Exception e) {
            System.out.println("Order creation failed: " + e.getMessage());
        }
    }

    private void processPayment() {
        System.out.println("\n4. PAYMENT PROCESSING");
        System.out.println("Processing payment for order...");
        
        try {
            // Use the created order's ID if available, otherwise use demo order ID
            String orderId = (createdOrder != null) ? createdOrder.getOrderId() : "ORDER_12345";
            BigDecimal amount = (createdOrder != null) ? createdOrder.getTotalAmount() : new BigDecimal("1459.97");
            
            boolean paymentResult = orderService.processPayment(
                orderId,
                "CREDIT_CARD",
                amount,
                "USD",
                "4111111111111111",
                "12",
                "2025",
                "123",
                "John Doe",
                null,
                null,
                null,
                true,
                "Premium laptop and mouse purchase",
                Map.of("ip_address", "192.168.1.100",
                       "user_agent", "Mozilla/5.0...",
                       "session_id", "sess_12345"),
                "PAYMENT_PROCESSOR"
            );
            
            System.out.println("Payment processed successfully: " + paymentResult);
            System.out.println("Order ID: " + orderId);
            System.out.println("Amount: $" + amount);
            
        } catch (Exception e) {
            System.out.println("Payment processing failed: " + e.getMessage());
        }
    }

    private void updateUser() {
        System.out.println("\n5. USER UPDATE");
        System.out.println("Updating user profile...");
        
        try {
            // Use the created user's ID if available, otherwise use demo user ID
            String userId = (createdUser != null) ? createdUser.getId() : "USER_12345";
            
            User updatedUser = userService.updateUserProfile(
                userId,
                "Jonathan",
                null,
                "Robert",
                null,
                "jonathan.doe@newemail.com",
                null,
                "+1-555-999-8888",
                null,
                null,
                null,
                "es",
                null,
                null,
                "https://newavatar.com/john.jpg",
                "Senior Software Engineer passionate about AI",
                null,
                "New Tech Corp",
                "Lead Developer",
                true,
                null,
                Map.of("skills", "Java,Spring,AI",
                       "certification", "AWS Solutions Architect",
                       "experience_years", "8"),
                Arrays.asList("AI", "Machine Learning",
                             "Spring Boot", "Microservices"),
                Arrays.asList("senior", "ai-expert"),
                "What city were you born in?",
                "Boston",
                null,
                "EMAIL_SMS",
                "PROFILE_MANAGER"
            );
            
            System.out.println("User profile updated successfully: " + updatedUser.getDisplayName());
            System.out.println("New email: " + updatedUser.getEmail());
            System.out.println("Company: " + updatedUser.getCompany());
            System.out.println("Updated user ID: " + userId);
            
        } catch (Exception e) {
            System.out.println("User update failed: " + e.getMessage());
        }
    }

    private void searchUsers() {
        System.out.println("\n6. USER SEARCH");
        System.out.println("Searching for users with filters...");
        
        try {
            List<User> searchResults = userService.searchUsers(
                "john",
                null,
                "John",
                null,
                "PREMIUM",
                "ACTIVE",
                true,
                null,
                null,
                null,
                "en",
                null,
                null,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(2000, 12, 31),
                LocalDateTime.now().minusYears(1),
                null,
                Arrays.asList("premium", "verified"),
                Map.of("department", "Engineering"),
                "firstName",
                "ASC",
                25,
                1,
                "SEARCH_SERVICE"
            );
            
            System.out.println("Search completed successfully");
            System.out.println("Results found: " + searchResults.size());
            
        } catch (Exception e) {
            System.out.println("Search operation failed: " + e.getMessage());
        }
    }
}