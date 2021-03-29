package com.iti.model.DTO;

public class CartItemDTO {
    private String itemType;
    private double itemPrice;
    private long itemQuantity;
    private String itemImg;
    private long productID;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public long getProductID() {
        return productID;
    }

    public CartItemDTO() {
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public CartItemDTO(String itemType, double itemPrice, long itemQuantity, String itemImg, long productID) {
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemImg = itemImg;
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "itemType='" + itemType + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ", itemImg='" + itemImg + '\'' +
                ", productID=" + productID +
                '}';
    }
}