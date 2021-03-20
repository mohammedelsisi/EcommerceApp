package com.iti.model.DTO;

public class ProductDTO  {

    private int prodID;
    private String prodType;
    private String prodDesc;
    private int prodQuantity;
    private String firstProdImg;
    private String secondProdImg;
    private double productPrice;
    private String size;
    private String category;

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodID=" + prodID +
                ", prodType='" + prodType + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", prodQuantity=" + prodQuantity +
                ", firstProdImg='" + firstProdImg + '\'' +
                ", secondProdImg='" + secondProdImg + '\'' +
                ", productPrice=" + productPrice +
                ", size='" + size + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


    public ProductDTO(int prodID, String prodType, String prodDesc, int prodQuantity, String firstProdImg, String secondProdImg, double productPrice, String size, String category) {
        this.prodID = prodID;
        this.prodType = prodType;
        this.prodDesc = prodDesc;
        this.prodQuantity = prodQuantity;
        this.firstProdImg = firstProdImg;
        this.secondProdImg = secondProdImg;
        this.productPrice = productPrice;
        this.size = size;
        this.category = category;
    }
}
