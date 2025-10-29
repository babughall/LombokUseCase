package com.example.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Address class - showing more traditional Java pain
 * This gets used by both User and Order classes, showing reusability issues
 */
public class Address {
    
    private String addressId;
    private String addressType; // HOME, WORK, BILLING, SHIPPING, OTHER
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String countryCode;
    private String region;
    private String district;
    private String landmark;
    private String phoneNumber;
    private String contactName;
    private String company;
    private boolean isDefault;
    private boolean isVerified;
    private String verificationStatus; // VERIFIED, UNVERIFIED, INVALID
    private Double latitude;
    private Double longitude;
    private String timeZone;
    private String deliveryInstructions;
    private String accessCodes;
    private boolean isCommercial;
    private boolean hasLoadingDock;
    private String businessHours;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    
    // Default constructor with defaults nightmare
    public Address() {
        this.addressType = "OTHER";
        this.isDefault = false;
        this.isVerified = false;
        this.verificationStatus = "UNVERIFIED";
        this.isCommercial = false;
        this.hasLoadingDock = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with required fields
    public Address(String streetAddress, String city, String state, String postalCode, String country) {
        this();
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.addressId = generateAddressId();
    }
    
    // Constructor with more fields
    public Address(String streetAddress, String streetAddress2, String city, String state, 
                  String postalCode, String country, String addressType, String contactName, 
                  String phoneNumber) {
        this(streetAddress, city, state, postalCode, country);
        this.streetAddress2 = streetAddress2;
        this.addressType = addressType != null ? addressType : "OTHER";
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }
    
    // Full constructor nightmare with 20+ parameters
    public Address(String addressId, String addressType, String streetAddress, String streetAddress2,
                  String city, String state, String postalCode, String country, String countryCode,
                  String region, String district, String landmark, String phoneNumber, String contactName,
                  String company, boolean isDefault, boolean isVerified, String verificationStatus,
                  Double latitude, Double longitude, String timeZone, String deliveryInstructions,
                  String accessCodes, boolean isCommercial, boolean hasLoadingDock, String businessHours,
                  String createdBy) {
        
        this.addressId = addressId != null ? addressId : generateAddressId();
        this.addressType = addressType != null ? addressType : "OTHER";
        this.streetAddress = streetAddress;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.countryCode = countryCode;
        this.region = region;
        this.district = district;
        this.landmark = landmark;
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
        this.company = company;
        this.isDefault = isDefault;
        this.isVerified = isVerified;
        this.verificationStatus = verificationStatus != null ? verificationStatus : "UNVERIFIED";
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.deliveryInstructions = deliveryInstructions;
        this.accessCodes = accessCodes;
        this.isCommercial = isCommercial;
        this.hasLoadingDock = hasLoadingDock;
        this.businessHours = businessHours;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Massive getters and setters
    
    public String getAddressId() { return addressId; }
    public void setAddressId(String addressId) { 
        this.addressId = addressId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getAddressType() { return addressType; }
    public void setAddressType(String addressType) { 
        this.addressType = addressType != null ? addressType : "OTHER"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { 
        this.streetAddress = streetAddress; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getStreetAddress2() { return streetAddress2; }
    public void setStreetAddress2(String streetAddress2) { 
        this.streetAddress2 = streetAddress2; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCity() { return city; }
    public void setCity(String city) { 
        this.city = city; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getState() { return state; }
    public void setState(String state) { 
        this.state = state; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { 
        this.postalCode = postalCode; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { 
        this.country = country; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { 
        this.countryCode = countryCode; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getRegion() { return region; }
    public void setRegion(String region) { 
        this.region = region; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDistrict() { return district; }
    public void setDistrict(String district) { 
        this.district = district; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { 
        this.landmark = landmark; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { 
        this.contactName = contactName; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { 
        this.company = company; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean aDefault) { 
        isDefault = aDefault; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isVerified() { return isVerified; }
    public void setVerified(boolean verified) { 
        isVerified = verified; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(String verificationStatus) { 
        this.verificationStatus = verificationStatus != null ? verificationStatus : "UNVERIFIED"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { 
        this.latitude = latitude; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { 
        this.longitude = longitude; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String timeZone) { 
        this.timeZone = timeZone; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDeliveryInstructions() { return deliveryInstructions; }
    public void setDeliveryInstructions(String deliveryInstructions) { 
        this.deliveryInstructions = deliveryInstructions; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getAccessCodes() { return accessCodes; }
    public void setAccessCodes(String accessCodes) { 
        this.accessCodes = accessCodes; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isCommercial() { return isCommercial; }
    public void setCommercial(boolean commercial) { 
        isCommercial = commercial; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isHasLoadingDock() { return hasLoadingDock; }
    public void setHasLoadingDock(boolean hasLoadingDock) { 
        this.hasLoadingDock = hasLoadingDock; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getBusinessHours() { return businessHours; }
    public void setBusinessHours(String businessHours) { 
        this.businessHours = businessHours; 
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
    
    // Helper methods
    public String getFullAddress() {
        StringBuilder sb = new StringBuilder();
        if (streetAddress != null) sb.append(streetAddress);
        if (streetAddress2 != null && !streetAddress2.trim().isEmpty()) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(streetAddress2);
        }
        if (city != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(city);
        }
        if (state != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(state);
        }
        if (postalCode != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(postalCode);
        }
        if (country != null) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(country);
        }
        return sb.toString();
    }
    
    public boolean isComplete() {
        return streetAddress != null && !streetAddress.trim().isEmpty() &&
               city != null && !city.trim().isEmpty() &&
               state != null && !state.trim().isEmpty() &&
               postalCode != null && !postalCode.trim().isEmpty() &&
               country != null && !country.trim().isEmpty();
    }
    
    public boolean hasGeoLocation() {
        return latitude != null && longitude != null;
    }
    
    private String generateAddressId() {
        return "ADDR_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return isDefault == address.isDefault &&
               isVerified == address.isVerified &&
               isCommercial == address.isCommercial &&
               hasLoadingDock == address.hasLoadingDock &&
               Objects.equals(addressId, address.addressId) &&
               Objects.equals(addressType, address.addressType) &&
               Objects.equals(streetAddress, address.streetAddress) &&
               Objects.equals(streetAddress2, address.streetAddress2) &&
               Objects.equals(city, address.city) &&
               Objects.equals(state, address.state) &&
               Objects.equals(postalCode, address.postalCode) &&
               Objects.equals(country, address.country) &&
               Objects.equals(countryCode, address.countryCode) &&
               Objects.equals(region, address.region) &&
               Objects.equals(district, address.district) &&
               Objects.equals(landmark, address.landmark) &&
               Objects.equals(phoneNumber, address.phoneNumber) &&
               Objects.equals(contactName, address.contactName) &&
               Objects.equals(company, address.company) &&
               Objects.equals(verificationStatus, address.verificationStatus) &&
               Objects.equals(latitude, address.latitude) &&
               Objects.equals(longitude, address.longitude) &&
               Objects.equals(timeZone, address.timeZone) &&
               Objects.equals(deliveryInstructions, address.deliveryInstructions) &&
               Objects.equals(accessCodes, address.accessCodes) &&
               Objects.equals(businessHours, address.businessHours) &&
               Objects.equals(createdAt, address.createdAt) &&
               Objects.equals(updatedAt, address.updatedAt) &&
               Objects.equals(createdBy, address.createdBy) &&
               Objects.equals(updatedBy, address.updatedBy);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(addressId, addressType, streetAddress, streetAddress2, city, state,
                           postalCode, country, countryCode, region, district, landmark, phoneNumber,
                           contactName, company, isDefault, isVerified, verificationStatus, latitude,
                           longitude, timeZone, deliveryInstructions, accessCodes, isCommercial,
                           hasLoadingDock, businessHours, createdAt, updatedAt, createdBy, updatedBy);
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", addressType='" + addressType + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", streetAddress2='" + streetAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", landmark='" + landmark + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactName='" + contactName + '\'' +
                ", company='" + company + '\'' +
                ", isDefault=" + isDefault +
                ", isVerified=" + isVerified +
                ", verificationStatus='" + verificationStatus + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timeZone='" + timeZone + '\'' +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                ", accessCodes='" + accessCodes + '\'' +
                ", isCommercial=" + isCommercial +
                ", hasLoadingDock=" + hasLoadingDock +
                ", businessHours='" + businessHours + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}