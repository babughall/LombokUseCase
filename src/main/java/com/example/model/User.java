package com.example.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Complex User class showing traditional Java pain points
 * - 25+ fields with various types
 * - Multiple constructors with default values
 * - Massive boilerplate code for getters/setters/equals/hashCode/toString
 * - Constructor overloading nightmare for optional parameters
 */
public class User {
    
    // Basic information
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String displayName;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private String preferredLanguage;
    private String timeZone;
    
    // Security and verification
    private String passwordHash;
    private String securityQuestion;
    private String securityAnswer;
    private boolean emailVerified;
    private boolean phoneVerified;
    private boolean twoFactorEnabled;
    private String twoFactorSecret;
    private LocalDateTime lastLoginAt;
    private String lastLoginIp;
    private int failedLoginAttempts;
    private boolean accountLocked;
    private LocalDateTime accountLockedUntil;
    
    // Profile and preferences
    private String profilePictureUrl;
    private String bio;
    private String website;
    private String company;
    private String jobTitle;
    private boolean marketingOptIn;
    private boolean newsletterOptIn;
    private String currencyPreference;
    private String notificationPreference;
    private Map<String, String> customAttributes;
    private List<String> interests;
    private List<String> tags;
    
    // System fields
    private String status; // ACTIVE, INACTIVE, SUSPENDED, DELETED
    private String userType; // CUSTOMER, ADMIN, MODERATOR, PREMIUM
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private Long version;
    
    // Default constructor - all fields null
    public User() {
        this.customAttributes = new HashMap<>();
        this.interests = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.emailVerified = false;
        this.phoneVerified = false;
        this.twoFactorEnabled = false;
        this.failedLoginAttempts = 0;
        this.accountLocked = false;
        this.marketingOptIn = false;
        this.newsletterOptIn = false;
        this.status = "ACTIVE";
        this.userType = "CUSTOMER";
        this.preferredLanguage = "en";
        this.timeZone = "UTC";
        this.currencyPreference = "USD";
        this.notificationPreference = "EMAIL";
        this.version = 1L;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with required fields only
    public User(String username, String email, String firstName, String lastName) {
        this(); // Call default constructor for defaults
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = generateUserId();
        this.displayName = firstName + " " + lastName;
    }
    
    // Constructor with some optional fields
    public User(String username, String email, String firstName, String lastName, 
               String phoneNumber, LocalDate dateOfBirth, String gender) {
        this(username, email, firstName, lastName); // Call previous constructor
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
    // Constructor with more optional fields
    public User(String username, String email, String firstName, String lastName, 
               String phoneNumber, LocalDate dateOfBirth, String gender,
               String nationality, String preferredLanguage, String timeZone) {
        this(username, email, firstName, lastName, phoneNumber, dateOfBirth, gender);
        this.nationality = nationality;
        this.preferredLanguage = preferredLanguage != null ? preferredLanguage : "en";
        this.timeZone = timeZone != null ? timeZone : "UTC";
    }
    
    // Full constructor - nightmare with 20+ parameters!
    public User(String id, String username, String email, String firstName, String lastName,
               String middleName, String displayName, String phoneNumber, String alternatePhoneNumber,
               LocalDate dateOfBirth, String gender, String nationality, String preferredLanguage,
               String timeZone, String passwordHash, boolean emailVerified, boolean phoneVerified,
               boolean twoFactorEnabled, String profilePictureUrl, String bio, String website,
               String company, String jobTitle, boolean marketingOptIn, boolean newsletterOptIn,
               String currencyPreference, String status, String userType, String createdBy) {
        
        // Initialize collections first
        this.customAttributes = new HashMap<>();
        this.interests = new ArrayList<>();
        this.tags = new ArrayList<>();
        
        // Set all the parameters
        this.id = id != null ? id : generateUserId();
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.displayName = displayName != null ? displayName : 
                         (firstName != null && lastName != null ? firstName + " " + lastName : null);
        this.phoneNumber = phoneNumber;
        this.alternatePhoneNumber = alternatePhoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.preferredLanguage = preferredLanguage != null ? preferredLanguage : "en";
        this.timeZone = timeZone != null ? timeZone : "UTC";
        this.passwordHash = passwordHash;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
        this.twoFactorEnabled = twoFactorEnabled;
        this.profilePictureUrl = profilePictureUrl;
        this.bio = bio;
        this.website = website;
        this.company = company;
        this.jobTitle = jobTitle;
        this.marketingOptIn = marketingOptIn;
        this.newsletterOptIn = newsletterOptIn;
        this.currencyPreference = currencyPreference != null ? currencyPreference : "USD";
        this.status = status != null ? status : "ACTIVE";
        this.userType = userType != null ? userType : "CUSTOMER";
        this.createdBy = createdBy;
        
        // Set system defaults
        this.failedLoginAttempts = 0;
        this.accountLocked = false;
        this.notificationPreference = "EMAIL";
        this.version = 1L;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // All the getters and setters - massive boilerplate!
    
    public String getId() { return id; }
    public void setId(String id) { 
        this.id = id; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { 
        this.username = username; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { 
        this.email = email; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
        updateDisplayName();
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
        updateDisplayName();
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { 
        this.middleName = middleName; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { 
        this.displayName = displayName; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getAlternatePhoneNumber() { return alternatePhoneNumber; }
    public void setAlternatePhoneNumber(String alternatePhoneNumber) { 
        this.alternatePhoneNumber = alternatePhoneNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { 
        this.dateOfBirth = dateOfBirth; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { 
        this.gender = gender; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { 
        this.nationality = nationality; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { 
        this.preferredLanguage = preferredLanguage != null ? preferredLanguage : "en"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { 
        this.timeZone = timeZone != null ? timeZone : "UTC"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { 
        this.passwordHash = passwordHash; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSecurityQuestion() { return securityQuestion; }
    public void setSecurityQuestion(String securityQuestion) { 
        this.securityQuestion = securityQuestion; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSecurityAnswer() { return securityAnswer; }
    public void setSecurityAnswer(String securityAnswer) { 
        this.securityAnswer = securityAnswer; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isEmailVerified() { return emailVerified; }
    public void setEmailVerified(boolean emailVerified) { 
        this.emailVerified = emailVerified; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isPhoneVerified() { return phoneVerified; }
    public void setPhoneVerified(boolean phoneVerified) { 
        this.phoneVerified = phoneVerified; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isTwoFactorEnabled() { return twoFactorEnabled; }
    public void setTwoFactorEnabled(boolean twoFactorEnabled) { 
        this.twoFactorEnabled = twoFactorEnabled; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getTwoFactorSecret() { return twoFactorSecret; }
    public void setTwoFactorSecret(String twoFactorSecret) { 
        this.twoFactorSecret = twoFactorSecret; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getLastLoginAt() { return lastLoginAt; }
    public void setLastLoginAt(LocalDateTime lastLoginAt) { 
        this.lastLoginAt = lastLoginAt; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getLastLoginIp() { return lastLoginIp; }
    public void setLastLoginIp(String lastLoginIp) { 
        this.lastLoginIp = lastLoginIp; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public int getFailedLoginAttempts() { return failedLoginAttempts; }
    public void setFailedLoginAttempts(int failedLoginAttempts) { 
        this.failedLoginAttempts = failedLoginAttempts; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isAccountLocked() { return accountLocked; }
    public void setAccountLocked(boolean accountLocked) { 
        this.accountLocked = accountLocked; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getAccountLockedUntil() { return accountLockedUntil; }
    public void setAccountLockedUntil(LocalDateTime accountLockedUntil) { 
        this.accountLockedUntil = accountLockedUntil; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProfilePictureUrl() { return profilePictureUrl; }
    public void setProfilePictureUrl(String profilePictureUrl) { 
        this.profilePictureUrl = profilePictureUrl; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getBio() { return bio; }
    public void setBio(String bio) { 
        this.bio = bio; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { 
        this.website = website; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { 
        this.company = company; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { 
        this.jobTitle = jobTitle; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public void setMarketingOptIn(boolean marketingOptIn) { 
        this.marketingOptIn = marketingOptIn; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isNewsletterOptIn() { return newsletterOptIn; }
    public void setNewsletterOptIn(boolean newsletterOptIn) { 
        this.newsletterOptIn = newsletterOptIn; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCurrencyPreference() { return currencyPreference; }
    public void setCurrencyPreference(String currencyPreference) { 
        this.currencyPreference = currencyPreference != null ? currencyPreference : "USD"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getNotificationPreference() { return notificationPreference; }
    public void setNotificationPreference(String notificationPreference) { 
        this.notificationPreference = notificationPreference != null ? notificationPreference : "EMAIL"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Map<String, String> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(Map<String, String> customAttributes) { 
        this.customAttributes = customAttributes != null ? customAttributes : new HashMap<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<String> getInterests() { return interests; }
    public void setInterests(List<String> interests) { 
        this.interests = interests != null ? interests : new ArrayList<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { 
        this.tags = tags != null ? tags : new ArrayList<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status != null ? status : "ACTIVE"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getUserType() { return userType; }
    public void setUserType(String userType) { 
        this.userType = userType != null ? userType : "CUSTOMER"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { 
        this.createdBy = createdBy; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { 
        this.updatedBy = updatedBy; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
    
    // Helper methods
    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        if (firstName != null) sb.append(firstName);
        if (middleName != null && !middleName.trim().isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(middleName);
        }
        if (lastName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(lastName);
        }
        return sb.toString();
    }
    
    public boolean isVerified() {
        return emailVerified && phoneVerified;
    }
    
    public boolean isSecure() {
        return twoFactorEnabled && passwordHash != null && !passwordHash.isEmpty();
    }
    
    private void updateDisplayName() {
        if (firstName != null && lastName != null) {
            this.displayName = firstName + " " + lastName;
        }
    }
    
    private String generateUserId() {
        return "USER_" + System.currentTimeMillis() + "_" + 
               (int)(Math.random() * 1000);
    }
    
    // Massive equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return emailVerified == user.emailVerified &&
               phoneVerified == user.phoneVerified &&
               twoFactorEnabled == user.twoFactorEnabled &&
               failedLoginAttempts == user.failedLoginAttempts &&
               accountLocked == user.accountLocked &&
               marketingOptIn == user.marketingOptIn &&
               newsletterOptIn == user.newsletterOptIn &&
               Objects.equals(id, user.id) &&
               Objects.equals(username, user.username) &&
               Objects.equals(email, user.email) &&
               Objects.equals(firstName, user.firstName) &&
               Objects.equals(lastName, user.lastName) &&
               Objects.equals(middleName, user.middleName) &&
               Objects.equals(displayName, user.displayName) &&
               Objects.equals(phoneNumber, user.phoneNumber) &&
               Objects.equals(alternatePhoneNumber, user.alternatePhoneNumber) &&
               Objects.equals(dateOfBirth, user.dateOfBirth) &&
               Objects.equals(gender, user.gender) &&
               Objects.equals(nationality, user.nationality) &&
               Objects.equals(preferredLanguage, user.preferredLanguage) &&
               Objects.equals(timeZone, user.timeZone) &&
               Objects.equals(passwordHash, user.passwordHash) &&
               Objects.equals(securityQuestion, user.securityQuestion) &&
               Objects.equals(securityAnswer, user.securityAnswer) &&
               Objects.equals(twoFactorSecret, user.twoFactorSecret) &&
               Objects.equals(lastLoginAt, user.lastLoginAt) &&
               Objects.equals(lastLoginIp, user.lastLoginIp) &&
               Objects.equals(accountLockedUntil, user.accountLockedUntil) &&
               Objects.equals(profilePictureUrl, user.profilePictureUrl) &&
               Objects.equals(bio, user.bio) &&
               Objects.equals(website, user.website) &&
               Objects.equals(company, user.company) &&
               Objects.equals(jobTitle, user.jobTitle) &&
               Objects.equals(currencyPreference, user.currencyPreference) &&
               Objects.equals(notificationPreference, user.notificationPreference) &&
               Objects.equals(customAttributes, user.customAttributes) &&
               Objects.equals(interests, user.interests) &&
               Objects.equals(tags, user.tags) &&
               Objects.equals(status, user.status) &&
               Objects.equals(userType, user.userType) &&
               Objects.equals(createdAt, user.createdAt) &&
               Objects.equals(updatedAt, user.updatedAt) &&
               Objects.equals(createdBy, user.createdBy) &&
               Objects.equals(updatedBy, user.updatedBy) &&
               Objects.equals(version, user.version);
    }
    
    // Massive hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, firstName, lastName, middleName, displayName,
                           phoneNumber, alternatePhoneNumber, dateOfBirth, gender, nationality,
                           preferredLanguage, timeZone, passwordHash, securityQuestion, securityAnswer,
                           emailVerified, phoneVerified, twoFactorEnabled, twoFactorSecret,
                           lastLoginAt, lastLoginIp, failedLoginAttempts, accountLocked,
                           accountLockedUntil, profilePictureUrl, bio, website, company, jobTitle,
                           marketingOptIn, newsletterOptIn, currencyPreference, notificationPreference,
                           customAttributes, interests, tags, status, userType, createdAt, updatedAt,
                           createdBy, updatedBy, version);
    }
    
    // Massive toString method
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", alternatePhoneNumber='" + alternatePhoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", preferredLanguage='" + preferredLanguage + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", securityAnswer='" + securityAnswer + '\'' +
                ", emailVerified=" + emailVerified +
                ", phoneVerified=" + phoneVerified +
                ", twoFactorEnabled=" + twoFactorEnabled +
                ", twoFactorSecret='" + twoFactorSecret + '\'' +
                ", lastLoginAt=" + lastLoginAt +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", accountLocked=" + accountLocked +
                ", accountLockedUntil=" + accountLockedUntil +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", website='" + website + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", marketingOptIn=" + marketingOptIn +
                ", newsletterOptIn=" + newsletterOptIn +
                ", currencyPreference='" + currencyPreference + '\'' +
                ", notificationPreference='" + notificationPreference + '\'' +
                ", customAttributes=" + customAttributes +
                ", interests=" + interests +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                ", userType='" + userType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", version=" + version +
                '}';
    }
}