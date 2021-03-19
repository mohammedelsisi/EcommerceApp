package com.iti.model.DTO;

public class ProductDTO  {
    private int prodID;
    private String prodType;
    private String prodDesc;
    private int prodQuantity;
    private String prodImg;
    private double productPrice;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodID=" + prodID +
                ", prodType='" + prodType + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", prodQuantity=" + prodQuantity +
                ", prodImg='" + prodImg + '\'' +
                ", productPrice=" + productPrice +
                '}';
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

    public ProductDTO(String prodDesc, String prodImg, double prodPrice) {
        this.prodDesc = prodDesc;
        this.prodImg = prodImg;
        this.productPrice = prodPrice;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodType;
    }

    public void setProdName(String prodName) {
        this.prodType = prodName;
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

    public String getProdImg() {
        return prodImg;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public double getProdPrice() {
        return productPrice;
    }




}
