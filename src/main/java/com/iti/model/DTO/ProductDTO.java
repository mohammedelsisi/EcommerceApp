package com.iti.model.DTO;

public class ProductDTO  {
    private long prodID;
    private String prodType;
    private String prodDescription;
    private long prodQuantity;
    private String firstProdImg;
    private String secondProdImg;
    private double productPrice;
    private String size;
    private String category;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodID=" + prodID +
                ", prodType='" + prodType + '\'' +
                ", prodDesc='" + prodDescription + '\'' +
                ", prodQuantity=" + prodQuantity +
                ", firstProdImg='" + firstProdImg + '\'' +
                ", secondProdImg='" + secondProdImg + '\'' +
                ", productPrice=" + productPrice +
                ", size='" + size + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getFirstProdImg() {
        return firstProdImg;
    }

    public void setFirstProdImg(String firstProdImg) {
        this.firstProdImg = firstProdImg;
    }

    public String getSecondProdImg() {
        return secondProdImg;
    }

    public void setSecondProdImg(String secondProdImg) {
        this.secondProdImg = secondProdImg;
    }

    public ProductDTO(String prodDescription, String firstProdImg, double prodPrice) {
        this.prodDescription = prodDescription;
        this.firstProdImg = firstProdImg;
        this.productPrice = prodPrice;
    }

    public ProductDTO(){}

    public long getProdID() {
        return prodID;
    }

    public void setProdID(long prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodType;
    }

    public void setProdName(String prodName) {
        this.prodType = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public long getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(long prodQuantity) {
        this.prodQuantity = prodQuantity;
    }



    public double getProdPrice() {
        return productPrice;
    }




}
