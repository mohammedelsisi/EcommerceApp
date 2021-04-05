package com.iti.model.DTO;

import java.util.Date;
import java.util.Set;

public class OrderDTO {
    Set<CartItemDTO> items;
    private long id;
    private String email;
    private String selectedAddress;
    private Date purchaseDate;
    private double totalAmount;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", selectedAddress='" + selectedAddress + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(String selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalAmount() {
        System.out.println("#### ITems" + items);
        System.out.println("#### ITems" + totalAmount);
        return items.stream().mapToDouble(e -> e.getItemPrice() * e.getItemQuantity()).sum() + 100;

    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<CartItemDTO> items) {
        this.items = items;
    }
}
