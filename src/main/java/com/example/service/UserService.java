package com.example.service;

import com.example.model.User;
import com.example.model.Address;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * UserService - MORE PARAMETER HELL in traditional Java
 * 
 * This service demonstrates the absolute nightmare of having methods
 * with 20+ parameters for user management operations.
 */
public class UserService {
    
    /**
     * Register user method with 22 parameters - ABSOLUTE NIGHTMARE!
     * Mix of required and optional parameters with complex default handling
     */
    public User registerUser(
            String username,                 // Required
            String email,                    // Required
            String password,                 // Required
            String firstName,                // Required
            String lastName,                 // Required
            String middleName,               // Optional, can be null
            String phoneNumber,              // Optional, can be null
            String alternatePhoneNumber,     // Optional, can be null
            LocalDate dateOfBirth,           // Optional, can be null
            String gender,                   // Optional, can be null
            String nationality,              // Optional, can be null
            String preferredLanguage,        // Optional, defaults to "en"
            String timeZone,                 // Optional, defaults to "UTC"
            String currencyPreference,       // Optional, defaults to "USD"
            boolean marketingOptIn,          // Optional, defaults to false
            boolean newsletterOptIn,         // Optional, defaults to false
            String referralCode,             // Optional, can be null
            String userType,                 // Optional, defaults to "CUSTOMER"
            String profilePictureUrl,        // Optional, can be null
            String website,                  // Optional, can be null
            String company,                  // Optional, can be null
            String jobTitle,                 // Optional, can be null
            Map<String, String> customAttributes, // Optional, can be null
            List<String> interests,          // Optional, can be null
            String registrationSource,       // Optional, defaults to "WEB"
            String createdBy                 // Required
    ) {
        // Massive parameter validation nightmare
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (createdBy == null || createdBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Created by is required");
        }
        
        // Validation logic scattered everywhere
        if (username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        // Handle defaults - error-prone and repetitive
        if (preferredLanguage == null || preferredLanguage.trim().isEmpty()) {
            preferredLanguage = "en";
        }
        if (timeZone == null || timeZone.trim().isEmpty()) {
            timeZone = "UTC";
        }
        if (currencyPreference == null || currencyPreference.trim().isEmpty()) {
            currencyPreference = "USD";
        }
        if (userType == null || userType.trim().isEmpty()) {
            userType = "CUSTOMER";
        }
        if (customAttributes == null) {
            customAttributes = new HashMap<>();
        }
        if (interests == null) {
            interests = new ArrayList<>();
        }
        
        // Add registration metadata
        customAttributes.put("registrationSource", registrationSource != null ? registrationSource : "WEB");
        customAttributes.put("registrationTimestamp", LocalDateTime.now().toString());
        
        // Hash password (simplified for demo)
        String passwordHash = "HASHED_" + password.hashCode();
        
        // Create user with massive constructor call - NIGHTMARE!
        User user = new User(
            null,                    // id - will be generated
            username,
            email,
            firstName,
            lastName,
            middleName,
            null,                    // displayName - will be set automatically
            phoneNumber,
            alternatePhoneNumber,
            dateOfBirth,
            gender,
            nationality,
            preferredLanguage,
            timeZone,
            passwordHash,
            false,                   // emailVerified - default
            false,                   // phoneVerified - default  
            false,                   // twoFactorEnabled - default
            profilePictureUrl,
            null,                    // bio - not provided in registration
            website,
            company,
            jobTitle,
            marketingOptIn,
            newsletterOptIn,
            currencyPreference,
            "ACTIVE",               // status - default for new users
            userType,
            createdBy
        );
        
        // Set additional fields that couldn't fit in constructor
        user.setCustomAttributes(customAttributes);
        user.setInterests(interests);
        
        // Handle referral logic - more scattered business rules
        if (referralCode != null && !referralCode.trim().isEmpty()) {
            // In real app, this would validate referral and give rewards
            user.getCustomAttributes().put("referralCode", referralCode);
            user.getTags().add("REFERRED_USER");
        }
        
        return user;
    }
    
    /**
     * Update user profile with 25+ parameters - EVEN MORE NIGHTMARE!
     * Almost all parameters are optional (null = no change)
     */
    public User updateUserProfile(
            String userId,                   // Required
            String firstName,                // Optional, null = no change
            String lastName,                 // Optional, null = no change
            String middleName,               // Optional, null = no change
            String displayName,              // Optional, null = no change
            String email,                    // Optional, null = no change
            String phoneNumber,              // Optional, null = no change
            String alternatePhoneNumber,     // Optional, null = no change
            LocalDate dateOfBirth,           // Optional, null = no change
            String gender,                   // Optional, null = no change
            String nationality,              // Optional, null = no change
            String preferredLanguage,        // Optional, null = no change
            String timeZone,                 // Optional, null = no change
            String currencyPreference,       // Optional, null = no change
            String profilePictureUrl,        // Optional, null = no change
            String bio,                      // Optional, null = no change
            String website,                  // Optional, null = no change
            String company,                  // Optional, null = no change
            String jobTitle,                 // Optional, null = no change
            Boolean marketingOptIn,          // Optional, null = no change
            Boolean newsletterOptIn,         // Optional, null = no change
            Map<String, String> customAttributes, // Optional, null = no change
            List<String> interests,          // Optional, null = no change
            List<String> tags,               // Optional, null = no change
            String securityQuestion,         // Optional, null = no change
            String securityAnswer,           // Optional, null = no change
            Boolean twoFactorEnabled,        // Optional, null = no change
            String notificationPreference,   // Optional, null = no change
            String updatedBy                 // Required
    ) {
        // Parameter validation
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (updatedBy == null || updatedBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Updated by is required");
        }
        
        // Find user (simulate database lookup)
        User user = findUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        // Update only non-null values - MASSIVE conditional logic nightmare!
        if (firstName != null) {
            if (firstName.trim().isEmpty()) {
                throw new IllegalArgumentException("First name cannot be empty");
            }
            user.setFirstName(firstName);
        }
        
        if (lastName != null) {
            if (lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be empty");
            }
            user.setLastName(lastName);
        }
        
        if (middleName != null) {
            user.setMiddleName(middleName);
        }
        
        if (displayName != null) {
            user.setDisplayName(displayName);
        }
        
        if (email != null) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email format");
            }
            // In real app, would check for email uniqueness
            user.setEmail(email);
            user.setEmailVerified(false); // Reset verification status
        }
        
        if (phoneNumber != null) {
            user.setPhoneNumber(phoneNumber);
            if (!phoneNumber.trim().isEmpty()) {
                user.setPhoneVerified(false); // Reset verification status
            }
        }
        
        if (alternatePhoneNumber != null) {
            user.setAlternatePhoneNumber(alternatePhoneNumber);
        }
        
        if (dateOfBirth != null) {
            // Validate age (must be at least 13)
            if (dateOfBirth.isAfter(LocalDate.now().minusYears(13))) {
                throw new IllegalArgumentException("User must be at least 13 years old");
            }
            user.setDateOfBirth(dateOfBirth);
        }
        
        if (gender != null) {
            user.setGender(gender);
        }
        
        if (nationality != null) {
            user.setNationality(nationality);
        }
        
        if (preferredLanguage != null) {
            user.setPreferredLanguage(preferredLanguage);
        }
        
        if (timeZone != null) {
            user.setTimeZone(timeZone);
        }
        
        if (currencyPreference != null) {
            user.setCurrencyPreference(currencyPreference);
        }
        
        if (profilePictureUrl != null) {
            user.setProfilePictureUrl(profilePictureUrl);
        }
        
        if (bio != null) {
            if (bio.length() > 500) {
                throw new IllegalArgumentException("Bio cannot exceed 500 characters");
            }
            user.setBio(bio);
        }
        
        if (website != null) {
            user.setWebsite(website);
        }
        
        if (company != null) {
            user.setCompany(company);
        }
        
        if (jobTitle != null) {
            user.setJobTitle(jobTitle);
        }
        
        if (marketingOptIn != null) {
            user.setMarketingOptIn(marketingOptIn);
        }
        
        if (newsletterOptIn != null) {
            user.setNewsletterOptIn(newsletterOptIn);
        }
        
        if (customAttributes != null) {
            // Merge with existing attributes
            Map<String, String> existing = user.getCustomAttributes();
            if (existing == null) {
                existing = new HashMap<>();
            }
            existing.putAll(customAttributes);
            user.setCustomAttributes(existing);
        }
        
        if (interests != null) {
            user.setInterests(interests);
        }
        
        if (tags != null) {
            user.setTags(tags);
        }
        
        if (securityQuestion != null) {
            user.setSecurityQuestion(securityQuestion);
        }
        
        if (securityAnswer != null) {
            user.setSecurityAnswer(securityAnswer);
        }
        
        if (twoFactorEnabled != null) {
            user.setTwoFactorEnabled(twoFactorEnabled);
            if (twoFactorEnabled && user.getTwoFactorSecret() == null) {
                // Generate 2FA secret
                user.setTwoFactorSecret("2FA_SECRET_" + System.currentTimeMillis());
            }
        }
        
        if (notificationPreference != null) {
            user.setNotificationPreference(notificationPreference);
        }
        
        user.setUpdatedBy(updatedBy);
        user.setUpdatedAt(LocalDateTime.now());
        
        return user;
    }
    
    /**
     * Change password method with 8 parameters - PASSWORD NIGHTMARE!
     */
    public boolean changePassword(
            String userId,               // Required
            String currentPassword,      // Required
            String newPassword,          // Required
            String confirmPassword,      // Required
            boolean forceLogout,         // Required
            boolean sendNotification,    // Required
            String changeReason,         // Optional, can be null
            String changedBy            // Required
    ) {
        // Parameter validation hell
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (currentPassword == null || currentPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Current password is required");
        }
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("New password is required");
        }
        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Confirm password is required");
        }
        if (changedBy == null || changedBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Changed by is required");
        }
        
        // Password validation - scattered business rules
        if (newPassword.length() < 8) {
            throw new IllegalArgumentException("New password must be at least 8 characters");
        }
        if (!newPassword.equals(confirmPassword)) {
            throw new IllegalArgumentException("New password and confirm password do not match");
        }
        if (newPassword.equals(currentPassword)) {
            throw new IllegalArgumentException("New password must be different from current password");
        }
        
        // Complex password strength validation
        boolean hasUpper = newPassword.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = newPassword.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = newPassword.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = newPassword.chars().anyMatch(ch -> "!@#$%^&*()".indexOf(ch) >= 0);
        
        if (!hasUpper || !hasLower || !hasDigit || !hasSpecial) {
            throw new IllegalArgumentException("Password must contain uppercase, lowercase, digit, and special character");
        }
        
        User user = findUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        // Verify current password
        String currentPasswordHash = "HASHED_" + currentPassword.hashCode();
        if (!currentPasswordHash.equals(user.getPasswordHash())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
        
        // Update password
        String newPasswordHash = "HASHED_" + newPassword.hashCode();
        user.setPasswordHash(newPasswordHash);
        user.setUpdatedBy(changedBy);
        user.setUpdatedAt(LocalDateTime.now());
        
        // Add to custom attributes for audit trail
        user.getCustomAttributes().put("lastPasswordChange", LocalDateTime.now().toString());
        if (changeReason != null) {
            user.getCustomAttributes().put("passwordChangeReason", changeReason);
        }
        
        // Business logic for post-password change
        if (forceLogout) {
            // In real app, would invalidate all sessions
            user.getCustomAttributes().put("forceLogoutAfterPasswordChange", "true");
        }
        
        if (sendNotification) {
            // In real app, would send email notification
            System.out.println("Password change notification sent to: " + user.getEmail());
        }
        
        return true;
    }
    
    /**
     * Update user security settings with 15 parameters - SECURITY NIGHTMARE!
     */
    public User updateSecuritySettings(
            String userId,                   // Required
            Boolean twoFactorEnabled,        // Optional, null = no change
            String twoFactorMethod,          // Optional, null = no change (SMS, EMAIL, APP)
            Boolean emailVerified,           // Optional, null = no change
            Boolean phoneVerified,           // Optional, null = no change
            String securityQuestion,         // Optional, null = no change
            String securityAnswer,           // Optional, null = no change
            Boolean accountLocked,           // Optional, null = no change
            LocalDateTime accountLockedUntil, // Optional, null = no change
            Integer failedLoginAttempts,     // Optional, null = no change
            String lastLoginIp,              // Optional, null = no change
            LocalDateTime lastLoginAt,       // Optional, null = no change
            List<String> trustedDevices,     // Optional, null = no change
            Map<String, String> securityFlags, // Optional, null = no change
            String updatedBy                 // Required
    ) {
        // Parameter validation
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (updatedBy == null || updatedBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Updated by is required");
        }
        
        User user = findUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        // Update security settings - more conditional hell!
        if (twoFactorEnabled != null) {
            user.setTwoFactorEnabled(twoFactorEnabled);
            if (twoFactorEnabled && user.getTwoFactorSecret() == null) {
                user.setTwoFactorSecret("2FA_SECRET_" + System.currentTimeMillis());
            }
            if (!twoFactorEnabled) {
                user.setTwoFactorSecret(null);
            }
        }
        
        if (twoFactorMethod != null) {
            user.getCustomAttributes().put("twoFactorMethod", twoFactorMethod);
        }
        
        if (emailVerified != null) {
            user.setEmailVerified(emailVerified);
            if (emailVerified) {
                user.getCustomAttributes().put("emailVerifiedAt", LocalDateTime.now().toString());
            }
        }
        
        if (phoneVerified != null) {
            user.setPhoneVerified(phoneVerified);
            if (phoneVerified) {
                user.getCustomAttributes().put("phoneVerifiedAt", LocalDateTime.now().toString());
            }
        }
        
        if (securityQuestion != null) {
            user.setSecurityQuestion(securityQuestion);
        }
        
        if (securityAnswer != null) {
            user.setSecurityAnswer(securityAnswer);
        }
        
        if (accountLocked != null) {
            user.setAccountLocked(accountLocked);
            if (!accountLocked) {
                user.setAccountLockedUntil(null);
                user.setFailedLoginAttempts(0);
            }
        }
        
        if (accountLockedUntil != null) {
            user.setAccountLockedUntil(accountLockedUntil);
        }
        
        if (failedLoginAttempts != null) {
            user.setFailedLoginAttempts(failedLoginAttempts);
        }
        
        if (lastLoginIp != null) {
            user.setLastLoginIp(lastLoginIp);
        }
        
        if (lastLoginAt != null) {
            user.setLastLoginAt(lastLoginAt);
        }
        
        if (trustedDevices != null) {
            user.getCustomAttributes().put("trustedDevices", String.join(",", trustedDevices));
        }
        
        if (securityFlags != null) {
            for (Map.Entry<String, String> flag : securityFlags.entrySet()) {
                user.getCustomAttributes().put("security_" + flag.getKey(), flag.getValue());
            }
        }
        
        user.setUpdatedBy(updatedBy);
        user.setUpdatedAt(LocalDateTime.now());
        
        return user;
    }
    
    // Helper method - simulating database lookup
    private User findUserById(String userId) {
        // In real app, this would query the database
        // For demo, just return a sample user
        return new User("johndoe", "john@example.com", "John", "Doe");
    }
    
    /**
     * Search users method with 20+ parameters - SEARCH PARAMETER HELL!
     */
    public List<User> searchUsers(
            String query,                    // Optional, null = no text search
            String email,                    // Optional, null = no email filter
            String firstName,                // Optional, null = no first name filter
            String lastName,                 // Optional, null = no last name filter
            String userType,                 // Optional, null = no user type filter
            String status,                   // Optional, null = no status filter
            Boolean emailVerified,           // Optional, null = no email verification filter
            Boolean phoneVerified,           // Optional, null = no phone verification filter
            Boolean twoFactorEnabled,        // Optional, null = no 2FA filter
            Boolean marketingOptIn,          // Optional, null = no marketing filter
            String preferredLanguage,        // Optional, null = no language filter
            String timeZone,                 // Optional, null = no timezone filter
            String nationality,              // Optional, null = no nationality filter
            LocalDate dateOfBirthFrom,       // Optional, null = no DOB range start
            LocalDate dateOfBirthTo,         // Optional, null = no DOB range end
            LocalDateTime createdFrom,       // Optional, null = no creation date range start
            LocalDateTime createdTo,         // Optional, null = no creation date range end
            List<String> tags,               // Optional, null = no tag filter
            Map<String, String> customAttributes, // Optional, null = no custom attribute filter
            String sortField,                // Optional, defaults to "createdAt"
            String sortDirection,            // Optional, defaults to "DESC"
            Integer pageSize,                // Optional, defaults to 50
            Integer pageNumber,              // Optional, defaults to 1
            String searchedBy                // Required
    ) {
        // Parameter validation for search
        if (searchedBy == null || searchedBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Searched by is required");
        }
        
        // Handle defaults for pagination and sorting
        if (sortField == null || sortField.trim().isEmpty()) {
            sortField = "createdAt";
        }
        if (sortDirection == null || sortDirection.trim().isEmpty()) {
            sortDirection = "DESC";
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 50;
        }
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        
        // Validate sort direction
        if (!"ASC".equals(sortDirection) && !"DESC".equals(sortDirection)) {
            throw new IllegalArgumentException("Sort direction must be ASC or DESC");
        }
        
        // Validate page size limits
        if (pageSize > 1000) {
            throw new IllegalArgumentException("Page size cannot exceed 1000");
        }
        
        // Build search criteria - complex conditional logic nightmare!
        List<String> searchCriteria = new ArrayList<>();
        
        if (query != null && !query.trim().isEmpty()) {
            searchCriteria.add("Text search: " + query);
        }
        if (email != null && !email.trim().isEmpty()) {
            searchCriteria.add("Email: " + email);
        }
        if (firstName != null && !firstName.trim().isEmpty()) {
            searchCriteria.add("First name: " + firstName);
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            searchCriteria.add("Last name: " + lastName);
        }
        if (userType != null && !userType.trim().isEmpty()) {
            searchCriteria.add("User type: " + userType);
        }
        if (status != null && !status.trim().isEmpty()) {
            searchCriteria.add("Status: " + status);
        }
        if (emailVerified != null) {
            searchCriteria.add("Email verified: " + emailVerified);
        }
        if (phoneVerified != null) {
            searchCriteria.add("Phone verified: " + phoneVerified);
        }
        if (twoFactorEnabled != null) {
            searchCriteria.add("2FA enabled: " + twoFactorEnabled);
        }
        if (marketingOptIn != null) {
            searchCriteria.add("Marketing opt-in: " + marketingOptIn);
        }
        if (preferredLanguage != null && !preferredLanguage.trim().isEmpty()) {
            searchCriteria.add("Language: " + preferredLanguage);
        }
        if (timeZone != null && !timeZone.trim().isEmpty()) {
            searchCriteria.add("Time zone: " + timeZone);
        }
        if (nationality != null && !nationality.trim().isEmpty()) {
            searchCriteria.add("Nationality: " + nationality);
        }
        if (dateOfBirthFrom != null) {
            searchCriteria.add("DOB from: " + dateOfBirthFrom);
        }
        if (dateOfBirthTo != null) {
            searchCriteria.add("DOB to: " + dateOfBirthTo);
        }
        if (createdFrom != null) {
            searchCriteria.add("Created from: " + createdFrom);
        }
        if (createdTo != null) {
            searchCriteria.add("Created to: " + createdTo);
        }
        if (tags != null && !tags.isEmpty()) {
            searchCriteria.add("Tags: " + String.join(", ", tags));
        }
        if (customAttributes != null && !customAttributes.isEmpty()) {
            searchCriteria.add("Custom attributes: " + customAttributes.size() + " filters");
        }
        
        // Log search operation
        System.out.println("User search executed by: " + searchedBy);
        System.out.println("Search criteria: " + String.join("; ", searchCriteria));
        System.out.println("Sort: " + sortField + " " + sortDirection);
        System.out.println("Pagination: Page " + pageNumber + ", Size " + pageSize);
        
        // In real app, this would execute complex database query
        // For demo, return empty list
        return new ArrayList<>();
    }
}