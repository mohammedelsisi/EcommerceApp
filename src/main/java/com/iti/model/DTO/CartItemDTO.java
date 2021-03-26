package com.iti.model.DTO;

public class CartItemDTO {
    private String ItemType;
    private double ItemPrice;
    private int ItemQuantity;
    private String ItemImg;

    public CartItemDTO(String itemType, double itemPrice, int itemQuantity, String itemImg) {
        ItemType = itemType;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
        ItemImg = itemImg;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    public String getItemImg() {
        return ItemImg;
    }

    public void setItemImg(String itemImg) {
        ItemImg = itemImg;
    }
}
