package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Complex Order class demonstrating traditional Java nightmare with:
 * - Nested objects (OrderItem, ShippingAddress, BillingAddress)
 * - Collections with null safety issues
 * - Multiple constructors with overlapping parameters
 * - Complex validation logic scattered everywhere
 * - Massive boilerplate for equals/hashCode/toString
 */
public class Order {
    
    // Core order information
    private String orderId;
    private String orderNumber;
    private String customerId;
    private String customerEmail;
    private String customerPhoneNumber;
    private LocalDateTime orderDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime actualDeliveryDate;
    private String orderStatus; // PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED, REFUNDED
    private String priority; // LOW, NORMAL, HIGH, URGENT
    
    // Financial information
    private BigDecimal subtotalAmount;
    private BigDecimal taxAmount;
    private BigDecimal shippingAmount;
    private BigDecimal discountAmount;
    private BigDecimal totalAmount;
    private String currency;
    private String paymentStatus; // PENDING, PAID, FAILED, REFUNDED, PARTIALLY_REFUNDED
    private String paymentMethod; // CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER, PAYPAL, APPLE_PAY, etc.
    private String paymentTransactionId;
    
    // Shipping information
    private String shippingMethod; // STANDARD, EXPRESS, OVERNIGHT, PICKUP
    private String shippingCarrier; // UPS, FEDEX, DHL, USPS
    private String trackingNumber;
    private BigDecimal shippingWeight;
    private String shippingDimensions;
    private boolean requiresSignature;
    private boolean isGift;
    private String giftMessage;
    private String giftWrapType;
    
    // Business logic fields
    private String salesChannel; // ONLINE, MOBILE_APP, PHONE, STORE, MARKETPLACE
    private String promotionCode;
    private String referralCode;
    private boolean isInternational;
    private String sourceCountry;
    private String destinationCountry;
    private boolean requiresCustomsClearance;
    private String customsDeclarationNumber;
    
    // Collections - nightmare for null safety!
    private List<OrderItem> orderItems;
    private List<String> appliedDiscountCodes;
    private Map<String, String> orderNotes;
    private Map<String, Object> customAttributes;
    private List<String> tags;
    
    // Nested objects - more constructor hell!
    private Address shippingAddress;
    private Address billingAddress;
    
    // System fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private Long version;
    
    // Default constructor with terrible defaults handling
    public Order() {
        this.orderItems = new ArrayList<>();
        this.appliedDiscountCodes = new ArrayList<>();
        this.orderNotes = new HashMap<>();
        this.customAttributes = new HashMap<>();
        this.tags = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
        this.orderStatus = "PENDING";
        this.priority = "NORMAL";
        this.paymentStatus = "PENDING";
        this.currency = "USD";
        this.subtotalAmount = BigDecimal.ZERO;
        this.taxAmount = BigDecimal.ZERO;
        this.shippingAmount = BigDecimal.ZERO;
        this.discountAmount = BigDecimal.ZERO;
        this.totalAmount = BigDecimal.ZERO;
        this.shippingWeight = BigDecimal.ZERO;
        this.requiresSignature = false;
        this.isGift = false;
        this.isInternational = false;
        this.requiresCustomsClearance = false;
        this.salesChannel = "ONLINE";
        this.version = 1L;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with minimal required fields
    public Order(String customerId, String customerEmail) {
        this();
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.orderId = generateOrderId();
        this.orderNumber = generateOrderNumber();
    }
    
    // Constructor with some optional fields - parameter order nightmare!
    public Order(String customerId, String customerEmail, String customerPhoneNumber,
                String paymentMethod, Address shippingAddress, Address billingAddress) {
        this(customerId, customerEmail);
        this.customerPhoneNumber = customerPhoneNumber;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        
        // Determine if international based on addresses
        if (shippingAddress != null && billingAddress != null) {
            this.isInternational = !Objects.equals(shippingAddress.getCountry(), billingAddress.getCountry());
            this.sourceCountry = billingAddress.getCountry();
            this.destinationCountry = shippingAddress.getCountry();
        }
    }
    
    // Constructor with more parameters - getting ridiculous!
    public Order(String customerId, String customerEmail, String customerPhoneNumber,
                String paymentMethod, Address shippingAddress, Address billingAddress,
                String shippingMethod, String priority, boolean isGift, String giftMessage,
                String promotionCode, String salesChannel) {
        this(customerId, customerEmail, customerPhoneNumber, paymentMethod, shippingAddress, billingAddress);
        this.shippingMethod = shippingMethod != null ? shippingMethod : "STANDARD";
        this.priority = priority != null ? priority : "NORMAL";
        this.isGift = isGift;
        this.giftMessage = giftMessage;
        this.promotionCode = promotionCode;
        this.salesChannel = salesChannel != null ? salesChannel : "ONLINE";
        
        // Gift logic
        if (isGift && giftMessage != null && !giftMessage.trim().isEmpty()) {
            this.giftWrapType = "STANDARD";
        }
    }
    
    // NIGHTMARE CONSTRUCTOR with 25+ parameters!!!
    public Order(String orderId, String orderNumber, String customerId, String customerEmail,
                String customerPhoneNumber, LocalDateTime orderDate, String orderStatus, String priority,
                BigDecimal subtotalAmount, BigDecimal taxAmount, BigDecimal shippingAmount,
                BigDecimal discountAmount, String currency, String paymentMethod, String paymentTransactionId,
                String shippingMethod, String shippingCarrier, String trackingNumber,
                boolean requiresSignature, boolean isGift, String giftMessage, String giftWrapType,
                String salesChannel, String promotionCode, String referralCode, boolean isInternational,
                Address shippingAddress, Address billingAddress, List<OrderItem> orderItems,
                String createdBy) {
        
        // Initialize collections first
        this.orderItems = orderItems != null ? new ArrayList<>(orderItems) : new ArrayList<>();
        this.appliedDiscountCodes = new ArrayList<>();
        this.orderNotes = new HashMap<>();
        this.customAttributes = new HashMap<>();
        this.tags = new ArrayList<>();
        
        // Set all parameters with null checks and defaults
        this.orderId = orderId != null ? orderId : generateOrderId();
        this.orderNumber = orderNumber != null ? orderNumber : generateOrderNumber();
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderDate = orderDate != null ? orderDate : LocalDateTime.now();
        this.orderStatus = orderStatus != null ? orderStatus : "PENDING";
        this.priority = priority != null ? priority : "NORMAL";
        this.subtotalAmount = subtotalAmount != null ? subtotalAmount : BigDecimal.ZERO;
        this.taxAmount = taxAmount != null ? taxAmount : BigDecimal.ZERO;
        this.shippingAmount = shippingAmount != null ? shippingAmount : BigDecimal.ZERO;
        this.discountAmount = discountAmount != null ? discountAmount : BigDecimal.ZERO;
        this.currency = currency != null ? currency : "USD";
        this.paymentMethod = paymentMethod;
        this.paymentTransactionId = paymentTransactionId;
        this.shippingMethod = shippingMethod != null ? shippingMethod : "STANDARD";
        this.shippingCarrier = shippingCarrier;
        this.trackingNumber = trackingNumber;
        this.requiresSignature = requiresSignature;
        this.isGift = isGift;
        this.giftMessage = giftMessage;
        this.giftWrapType = giftWrapType;
        this.salesChannel = salesChannel != null ? salesChannel : "ONLINE";
        this.promotionCode = promotionCode;
        this.referralCode = referralCode;
        this.isInternational = isInternational;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.createdBy = createdBy;
        
        // Calculate totals
        this.totalAmount = calculateTotalAmount();
        
        // Set defaults for other fields
        this.paymentStatus = "PENDING";
        this.shippingWeight = BigDecimal.ZERO;
        this.requiresCustomsClearance = isInternational;
        
        // Determine countries from addresses
        if (shippingAddress != null) {
            this.destinationCountry = shippingAddress.getCountry();
        }
        if (billingAddress != null) {
            this.sourceCountry = billingAddress.getCountry();
        }
        
        // System fields
        this.version = 1L;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Massive amount of getters and setters with business logic scattered everywhere!
    
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { 
        this.orderId = orderId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { 
        this.orderNumber = orderNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { 
        this.customerId = customerId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { 
        this.customerEmail = customerEmail; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { 
        this.customerPhoneNumber = customerPhoneNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { 
        this.orderDate = orderDate; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getEstimatedDeliveryDate() { return estimatedDeliveryDate; }
    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) { 
        this.estimatedDeliveryDate = estimatedDeliveryDate; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getActualDeliveryDate() { return actualDeliveryDate; }
    public void setActualDeliveryDate(LocalDateTime actualDeliveryDate) { 
        this.actualDeliveryDate = actualDeliveryDate; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { 
        this.orderStatus = orderStatus != null ? orderStatus : "PENDING"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPriority() { return priority; }
    public void setPriority(String priority) { 
        this.priority = priority != null ? priority : "NORMAL"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getSubtotalAmount() { return subtotalAmount; }
    public void setSubtotalAmount(BigDecimal subtotalAmount) { 
        this.subtotalAmount = subtotalAmount != null ? subtotalAmount : BigDecimal.ZERO; 
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getTaxAmount() { return taxAmount; }
    public void setTaxAmount(BigDecimal taxAmount) { 
        this.taxAmount = taxAmount != null ? taxAmount : BigDecimal.ZERO; 
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getShippingAmount() { return shippingAmount; }
    public void setShippingAmount(BigDecimal shippingAmount) { 
        this.shippingAmount = shippingAmount != null ? shippingAmount : BigDecimal.ZERO; 
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(BigDecimal discountAmount) { 
        this.discountAmount = discountAmount != null ? discountAmount : BigDecimal.ZERO; 
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { 
        this.totalAmount = totalAmount != null ? totalAmount : BigDecimal.ZERO; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { 
        this.currency = currency != null ? currency : "USD"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { 
        this.paymentStatus = paymentStatus != null ? paymentStatus : "PENDING"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { 
        this.paymentMethod = paymentMethod; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPaymentTransactionId() { return paymentTransactionId; }
    public void setPaymentTransactionId(String paymentTransactionId) { 
        this.paymentTransactionId = paymentTransactionId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getShippingMethod() { return shippingMethod; }
    public void setShippingMethod(String shippingMethod) { 
        this.shippingMethod = shippingMethod != null ? shippingMethod : "STANDARD"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getShippingCarrier() { return shippingCarrier; }
    public void setShippingCarrier(String shippingCarrier) { 
        this.shippingCarrier = shippingCarrier; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { 
        this.trackingNumber = trackingNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getShippingWeight() { return shippingWeight; }
    public void setShippingWeight(BigDecimal shippingWeight) { 
        this.shippingWeight = shippingWeight != null ? shippingWeight : BigDecimal.ZERO; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getShippingDimensions() { return shippingDimensions; }
    public void setShippingDimensions(String shippingDimensions) { 
        this.shippingDimensions = shippingDimensions; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isRequiresSignature() { return requiresSignature; }
    public void setRequiresSignature(boolean requiresSignature) { 
        this.requiresSignature = requiresSignature; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isGift() { return isGift; }
    public void setGift(boolean gift) { 
        isGift = gift; 
        if (!gift) {
            this.giftMessage = null;
            this.giftWrapType = null;
        }
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getGiftMessage() { return giftMessage; }
    public void setGiftMessage(String giftMessage) { 
        this.giftMessage = giftMessage; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getGiftWrapType() { return giftWrapType; }
    public void setGiftWrapType(String giftWrapType) { 
        this.giftWrapType = giftWrapType; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSalesChannel() { return salesChannel; }
    public void setSalesChannel(String salesChannel) { 
        this.salesChannel = salesChannel != null ? salesChannel : "ONLINE"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getPromotionCode() { return promotionCode; }
    public void setPromotionCode(String promotionCode) { 
        this.promotionCode = promotionCode; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getReferralCode() { return referralCode; }
    public void setReferralCode(String referralCode) { 
        this.referralCode = referralCode; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isInternational() { return isInternational; }
    public void setInternational(boolean international) { 
        isInternational = international; 
        this.requiresCustomsClearance = international;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSourceCountry() { return sourceCountry; }
    public void setSourceCountry(String sourceCountry) { 
        this.sourceCountry = sourceCountry; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDestinationCountry() { return destinationCountry; }
    public void setDestinationCountry(String destinationCountry) { 
        this.destinationCountry = destinationCountry; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isRequiresCustomsClearance() { return requiresCustomsClearance; }
    public void setRequiresCustomsClearance(boolean requiresCustomsClearance) { 
        this.requiresCustomsClearance = requiresCustomsClearance; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCustomsDeclarationNumber() { return customsDeclarationNumber; }
    public void setCustomsDeclarationNumber(String customsDeclarationNumber) { 
        this.customsDeclarationNumber = customsDeclarationNumber; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { 
        this.orderItems = orderItems != null ? orderItems : new ArrayList<>(); 
        this.subtotalAmount = calculateSubtotal();
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<String> getAppliedDiscountCodes() { return appliedDiscountCodes; }
    public void setAppliedDiscountCodes(List<String> appliedDiscountCodes) { 
        this.appliedDiscountCodes = appliedDiscountCodes != null ? appliedDiscountCodes : new ArrayList<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Map<String, String> getOrderNotes() { return orderNotes; }
    public void setOrderNotes(Map<String, String> orderNotes) { 
        this.orderNotes = orderNotes != null ? orderNotes : new HashMap<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Map<String, Object> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(Map<String, Object> customAttributes) { 
        this.customAttributes = customAttributes != null ? customAttributes : new HashMap<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { 
        this.tags = tags != null ? tags : new ArrayList<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Address getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(Address shippingAddress) { 
        this.shippingAddress = shippingAddress; 
        updateInternationalStatus();
        this.updatedAt = LocalDateTime.now();
    }
    
    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { 
        this.billingAddress = billingAddress; 
        updateInternationalStatus();
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
    
    // Helper methods with business logic scattered everywhere
    public void addOrderItem(OrderItem item) {
        if (item != null) {
            this.orderItems.add(item);
            this.subtotalAmount = calculateSubtotal();
            this.totalAmount = calculateTotalAmount();
            this.updatedAt = LocalDateTime.now();
        }
    }
    
    public void removeOrderItem(String productId) {
        this.orderItems.removeIf(item -> Objects.equals(item.getProductId(), productId));
        this.subtotalAmount = calculateSubtotal();
        this.totalAmount = calculateTotalAmount();
        this.updatedAt = LocalDateTime.now();
    }
    
    public void applyDiscountCode(String discountCode) {
        if (discountCode != null && !discountCode.trim().isEmpty() && 
            !this.appliedDiscountCodes.contains(discountCode)) {
            this.appliedDiscountCodes.add(discountCode);
            this.updatedAt = LocalDateTime.now();
        }
    }
    
    public boolean hasOrderItems() {
        return this.orderItems != null && !this.orderItems.isEmpty();
    }
    
    public int getItemCount() {
        return this.orderItems != null ? this.orderItems.size() : 0;
    }
    
    public boolean isHighValue() {
        return this.totalAmount != null && this.totalAmount.compareTo(new BigDecimal("1000")) > 0;
    }
    
    public boolean isExpedited() {
        return "HIGH".equals(this.priority) || "URGENT".equals(this.priority) ||
               "EXPRESS".equals(this.shippingMethod) || "OVERNIGHT".equals(this.shippingMethod);
    }
    
    public boolean isPaid() {
        return "PAID".equals(this.paymentStatus);
    }
    
    public boolean canBeCancelled() {
        return "PENDING".equals(this.orderStatus) || "CONFIRMED".equals(this.orderStatus);
    }
    
    private BigDecimal calculateSubtotal() {
        if (this.orderItems == null || this.orderItems.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return this.orderItems.stream()
                .map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    private BigDecimal calculateTotalAmount() {
        BigDecimal subtotal = this.subtotalAmount != null ? this.subtotalAmount : BigDecimal.ZERO;
        BigDecimal tax = this.taxAmount != null ? this.taxAmount : BigDecimal.ZERO;
        BigDecimal shipping = this.shippingAmount != null ? this.shippingAmount : BigDecimal.ZERO;
        BigDecimal discount = this.discountAmount != null ? this.discountAmount : BigDecimal.ZERO;
        
        return subtotal.add(tax).add(shipping).subtract(discount);
    }
    
    private void updateInternationalStatus() {
        if (this.shippingAddress != null && this.billingAddress != null) {
            this.isInternational = !Objects.equals(
                this.shippingAddress.getCountry(), 
                this.billingAddress.getCountry()
            );
            this.sourceCountry = this.billingAddress.getCountry();
            this.destinationCountry = this.shippingAddress.getCountry();
            this.requiresCustomsClearance = this.isInternational;
        }
    }
    
    private String generateOrderId() {
        return "ORD_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }
    
    private String generateOrderNumber() {
        return "ON" + System.currentTimeMillis();
    }
    
    // MASSIVE equals method - impossible to maintain!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return requiresSignature == order.requiresSignature &&
               isGift == order.isGift &&
               isInternational == order.isInternational &&
               requiresCustomsClearance == order.requiresCustomsClearance &&
               Objects.equals(orderId, order.orderId) &&
               Objects.equals(orderNumber, order.orderNumber) &&
               Objects.equals(customerId, order.customerId) &&
               Objects.equals(customerEmail, order.customerEmail) &&
               Objects.equals(customerPhoneNumber, order.customerPhoneNumber) &&
               Objects.equals(orderDate, order.orderDate) &&
               Objects.equals(estimatedDeliveryDate, order.estimatedDeliveryDate) &&
               Objects.equals(actualDeliveryDate, order.actualDeliveryDate) &&
               Objects.equals(orderStatus, order.orderStatus) &&
               Objects.equals(priority, order.priority) &&
               Objects.equals(subtotalAmount, order.subtotalAmount) &&
               Objects.equals(taxAmount, order.taxAmount) &&
               Objects.equals(shippingAmount, order.shippingAmount) &&
               Objects.equals(discountAmount, order.discountAmount) &&
               Objects.equals(totalAmount, order.totalAmount) &&
               Objects.equals(currency, order.currency) &&
               Objects.equals(paymentStatus, order.paymentStatus) &&
               Objects.equals(paymentMethod, order.paymentMethod) &&
               Objects.equals(paymentTransactionId, order.paymentTransactionId) &&
               Objects.equals(shippingMethod, order.shippingMethod) &&
               Objects.equals(shippingCarrier, order.shippingCarrier) &&
               Objects.equals(trackingNumber, order.trackingNumber) &&
               Objects.equals(shippingWeight, order.shippingWeight) &&
               Objects.equals(shippingDimensions, order.shippingDimensions) &&
               Objects.equals(giftMessage, order.giftMessage) &&
               Objects.equals(giftWrapType, order.giftWrapType) &&
               Objects.equals(salesChannel, order.salesChannel) &&
               Objects.equals(promotionCode, order.promotionCode) &&
               Objects.equals(referralCode, order.referralCode) &&
               Objects.equals(sourceCountry, order.sourceCountry) &&
               Objects.equals(destinationCountry, order.destinationCountry) &&
               Objects.equals(customsDeclarationNumber, order.customsDeclarationNumber) &&
               Objects.equals(orderItems, order.orderItems) &&
               Objects.equals(appliedDiscountCodes, order.appliedDiscountCodes) &&
               Objects.equals(orderNotes, order.orderNotes) &&
               Objects.equals(customAttributes, order.customAttributes) &&
               Objects.equals(tags, order.tags) &&
               Objects.equals(shippingAddress, order.shippingAddress) &&
               Objects.equals(billingAddress, order.billingAddress) &&
               Objects.equals(createdAt, order.createdAt) &&
               Objects.equals(updatedAt, order.updatedAt) &&
               Objects.equals(createdBy, order.createdBy) &&
               Objects.equals(updatedBy, order.updatedBy) &&
               Objects.equals(version, order.version);
    }
    
    // MASSIVE hashCode method - copy/paste error prone!
    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderNumber, customerId, customerEmail, customerPhoneNumber,
                           orderDate, estimatedDeliveryDate, actualDeliveryDate, orderStatus, priority,
                           subtotalAmount, taxAmount, shippingAmount, discountAmount, totalAmount, currency,
                           paymentStatus, paymentMethod, paymentTransactionId, shippingMethod, shippingCarrier,
                           trackingNumber, shippingWeight, shippingDimensions, requiresSignature, isGift,
                           giftMessage, giftWrapType, salesChannel, promotionCode, referralCode, isInternational,
                           sourceCountry, destinationCountry, requiresCustomsClearance, customsDeclarationNumber,
                           orderItems, appliedDiscountCodes, orderNotes, customAttributes, tags,
                           shippingAddress, billingAddress, createdAt, updatedAt, createdBy, updatedBy, version);
    }
    
    // MASSIVE toString method - nightmare to maintain!
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", orderDate=" + orderDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", actualDeliveryDate=" + actualDeliveryDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", priority='" + priority + '\'' +
                ", subtotalAmount=" + subtotalAmount +
                ", taxAmount=" + taxAmount +
                ", shippingAmount=" + shippingAmount +
                ", discountAmount=" + discountAmount +
                ", totalAmount=" + totalAmount +
                ", currency='" + currency + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentTransactionId='" + paymentTransactionId + '\'' +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", shippingCarrier='" + shippingCarrier + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", shippingWeight=" + shippingWeight +
                ", shippingDimensions='" + shippingDimensions + '\'' +
                ", requiresSignature=" + requiresSignature +
                ", isGift=" + isGift +
                ", giftMessage='" + giftMessage + '\'' +
                ", giftWrapType='" + giftWrapType + '\'' +
                ", salesChannel='" + salesChannel + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", referralCode='" + referralCode + '\'' +
                ", isInternational=" + isInternational +
                ", sourceCountry='" + sourceCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", requiresCustomsClearance=" + requiresCustomsClearance +
                ", customsDeclarationNumber='" + customsDeclarationNumber + '\'' +
                ", orderItems=" + orderItems +
                ", appliedDiscountCodes=" + appliedDiscountCodes +
                ", orderNotes=" + orderNotes +
                ", customAttributes=" + customAttributes +
                ", tags=" + tags +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", version=" + version +
                '}';
    }
}