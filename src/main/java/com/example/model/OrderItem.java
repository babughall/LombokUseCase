package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/**
 * OrderItem class - another nightmare of traditional Java
 * Demonstrates nested object complexity in traditional Java
 */
public class OrderItem {
    
    private String orderItemId;
    private String productId;
    private String productName;
    private String productSku;
    private String productCategory;
    private String productBrand;
    private String productDescription;
    private String productImageUrl;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal totalPrice;
    private String currency;
    private BigDecimal weight;
    private String dimensions;
    private boolean isDigital;
    private boolean isGiftCard;
    private String giftCardRecipientEmail;
    private String giftCardMessage;
    private String variantId;
    private String variantName;
    private Map<String, String> productAttributes;
    private String supplierCode;
    private String warehouseLocation;
    private boolean isPreOrder;
    private LocalDateTime estimatedShipDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Default constructor with defaults hell
    public OrderItem() {
        this.productAttributes = new HashMap<>();
        this.unitPrice = BigDecimal.ZERO;
        this.quantity = 1;
        this.totalPrice = BigDecimal.ZERO;
        this.currency = "USD";
        this.weight = BigDecimal.ZERO;
        this.isDigital = false;
        this.isGiftCard = false;
        this.isPreOrder = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with required fields
    public OrderItem(String productId, String productName, BigDecimal unitPrice, int quantity) {
        this();
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice != null ? unitPrice : BigDecimal.ZERO;
        this.quantity = quantity > 0 ? quantity : 1;
        this.totalPrice = calculateTotalPrice();
        this.orderItemId = generateOrderItemId();
    }
    
    // Constructor with more parameters
    public OrderItem(String productId, String productName, String productSku, BigDecimal unitPrice, 
                    int quantity, String currency, String productCategory, String productBrand) {
        this(productId, productName, unitPrice, quantity);
        this.productSku = productSku;
        this.currency = currency != null ? currency : "USD";
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.totalPrice = calculateTotalPrice();
    }
    
    // Full constructor nightmare
    public OrderItem(String orderItemId, String productId, String productName, String productSku,
                    String productCategory, String productBrand, String productDescription,
                    String productImageUrl, BigDecimal unitPrice, int quantity, String currency,
                    BigDecimal weight, String dimensions, boolean isDigital, boolean isGiftCard,
                    String giftCardRecipientEmail, String giftCardMessage, String variantId,
                    String variantName, String supplierCode, String warehouseLocation,
                    boolean isPreOrder, LocalDateTime estimatedShipDate) {
        
        this.productAttributes = new HashMap<>();
        this.orderItemId = orderItemId != null ? orderItemId : generateOrderItemId();
        this.productId = productId;
        this.productName = productName;
        this.productSku = productSku;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.unitPrice = unitPrice != null ? unitPrice : BigDecimal.ZERO;
        this.quantity = quantity > 0 ? quantity : 1;
        this.currency = currency != null ? currency : "USD";
        this.weight = weight != null ? weight : BigDecimal.ZERO;
        this.dimensions = dimensions;
        this.isDigital = isDigital;
        this.isGiftCard = isGiftCard;
        this.giftCardRecipientEmail = giftCardRecipientEmail;
        this.giftCardMessage = giftCardMessage;
        this.variantId = variantId;
        this.variantName = variantName;
        this.supplierCode = supplierCode;
        this.warehouseLocation = warehouseLocation;
        this.isPreOrder = isPreOrder;
        this.estimatedShipDate = estimatedShipDate;
        this.totalPrice = calculateTotalPrice();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // All the getters and setters - massive boilerplate!
    
    public String getOrderItemId() { return orderItemId; }
    public void setOrderItemId(String orderItemId) { 
        this.orderItemId = orderItemId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductId() { return productId; }
    public void setProductId(String productId) { 
        this.productId = productId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { 
        this.productName = productName; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductSku() { return productSku; }
    public void setProductSku(String productSku) { 
        this.productSku = productSku; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductCategory() { return productCategory; }
    public void setProductCategory(String productCategory) { 
        this.productCategory = productCategory; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductBrand() { return productBrand; }
    public void setProductBrand(String productBrand) { 
        this.productBrand = productBrand; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { 
        this.productDescription = productDescription; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getProductImageUrl() { return productImageUrl; }
    public void setProductImageUrl(String productImageUrl) { 
        this.productImageUrl = productImageUrl; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { 
        this.unitPrice = unitPrice != null ? unitPrice : BigDecimal.ZERO; 
        this.totalPrice = calculateTotalPrice();
        this.updatedAt = LocalDateTime.now();
    }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity > 0 ? quantity : 1; 
        this.totalPrice = calculateTotalPrice();
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { 
        this.totalPrice = totalPrice != null ? totalPrice : BigDecimal.ZERO; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { 
        this.currency = currency != null ? currency : "USD"; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { 
        this.weight = weight != null ? weight : BigDecimal.ZERO; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { 
        this.dimensions = dimensions; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isDigital() { return isDigital; }
    public void setDigital(boolean digital) { 
        isDigital = digital; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isGiftCard() { return isGiftCard; }
    public void setGiftCard(boolean giftCard) { 
        isGiftCard = giftCard; 
        if (!giftCard) {
            this.giftCardRecipientEmail = null;
            this.giftCardMessage = null;
        }
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getGiftCardRecipientEmail() { return giftCardRecipientEmail; }
    public void setGiftCardRecipientEmail(String giftCardRecipientEmail) { 
        this.giftCardRecipientEmail = giftCardRecipientEmail; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getGiftCardMessage() { return giftCardMessage; }
    public void setGiftCardMessage(String giftCardMessage) { 
        this.giftCardMessage = giftCardMessage; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getVariantId() { return variantId; }
    public void setVariantId(String variantId) { 
        this.variantId = variantId; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getVariantName() { return variantName; }
    public void setVariantName(String variantName) { 
        this.variantName = variantName; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Map<String, String> getProductAttributes() { return productAttributes; }
    public void setProductAttributes(Map<String, String> productAttributes) { 
        this.productAttributes = productAttributes != null ? productAttributes : new HashMap<>(); 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { 
        this.supplierCode = supplierCode; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { 
        this.warehouseLocation = warehouseLocation; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isPreOrder() { return isPreOrder; }
    public void setPreOrder(boolean preOrder) { 
        isPreOrder = preOrder; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getEstimatedShipDate() { return estimatedShipDate; }
    public void setEstimatedShipDate(LocalDateTime estimatedShipDate) { 
        this.estimatedShipDate = estimatedShipDate; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    // Helper methods
    public boolean isPhysicalProduct() {
        return !isDigital && !isGiftCard;
    }
    
    public boolean requiresShipping() {
        return isPhysicalProduct();
    }
    
    private BigDecimal calculateTotalPrice() {
        if (unitPrice == null) return BigDecimal.ZERO;
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
    
    private String generateOrderItemId() {
        return "ITEM_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1000);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
               isDigital == orderItem.isDigital &&
               isGiftCard == orderItem.isGiftCard &&
               isPreOrder == orderItem.isPreOrder &&
               Objects.equals(orderItemId, orderItem.orderItemId) &&
               Objects.equals(productId, orderItem.productId) &&
               Objects.equals(productName, orderItem.productName) &&
               Objects.equals(productSku, orderItem.productSku) &&
               Objects.equals(productCategory, orderItem.productCategory) &&
               Objects.equals(productBrand, orderItem.productBrand) &&
               Objects.equals(productDescription, orderItem.productDescription) &&
               Objects.equals(productImageUrl, orderItem.productImageUrl) &&
               Objects.equals(unitPrice, orderItem.unitPrice) &&
               Objects.equals(totalPrice, orderItem.totalPrice) &&
               Objects.equals(currency, orderItem.currency) &&
               Objects.equals(weight, orderItem.weight) &&
               Objects.equals(dimensions, orderItem.dimensions) &&
               Objects.equals(giftCardRecipientEmail, orderItem.giftCardRecipientEmail) &&
               Objects.equals(giftCardMessage, orderItem.giftCardMessage) &&
               Objects.equals(variantId, orderItem.variantId) &&
               Objects.equals(variantName, orderItem.variantName) &&
               Objects.equals(productAttributes, orderItem.productAttributes) &&
               Objects.equals(supplierCode, orderItem.supplierCode) &&
               Objects.equals(warehouseLocation, orderItem.warehouseLocation) &&
               Objects.equals(estimatedShipDate, orderItem.estimatedShipDate) &&
               Objects.equals(createdAt, orderItem.createdAt) &&
               Objects.equals(updatedAt, orderItem.updatedAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, productId, productName, productSku, productCategory,
                           productBrand, productDescription, productImageUrl, unitPrice, quantity,
                           totalPrice, currency, weight, dimensions, isDigital, isGiftCard,
                           giftCardRecipientEmail, giftCardMessage, variantId, variantName,
                           productAttributes, supplierCode, warehouseLocation, isPreOrder,
                           estimatedShipDate, createdAt, updatedAt);
    }
    
    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productSku='" + productSku + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", currency='" + currency + '\'' +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                ", isDigital=" + isDigital +
                ", isGiftCard=" + isGiftCard +
                ", giftCardRecipientEmail='" + giftCardRecipientEmail + '\'' +
                ", giftCardMessage='" + giftCardMessage + '\'' +
                ", variantId='" + variantId + '\'' +
                ", variantName='" + variantName + '\'' +
                ", productAttributes=" + productAttributes +
                ", supplierCode='" + supplierCode + '\'' +
                ", warehouseLocation='" + warehouseLocation + '\'' +
                ", isPreOrder=" + isPreOrder +
                ", estimatedShipDate=" + estimatedShipDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}