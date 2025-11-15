package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantName;
    private String cuisineType;
    private String menuItemName;
    private String menuItemDescription;
    private Double menuItemPrice;
    private Integer quantity;
    private String orderStatus;

    public FoodOrder() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public String getCuisineType() { return cuisineType; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

    public String getMenuItemName() { return menuItemName; }
    public void setMenuItemName(String menuItemName) { this.menuItemName = menuItemName; }

    public String getMenuItemDescription() { return menuItemDescription; }
    public void setMenuItemDescription(String menuItemDescription) { this.menuItemDescription = menuItemDescription; }

    public Double getMenuItemPrice() { return menuItemPrice; }
    public void setMenuItemPrice(Double menuItemPrice) { this.menuItemPrice = menuItemPrice; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
}
