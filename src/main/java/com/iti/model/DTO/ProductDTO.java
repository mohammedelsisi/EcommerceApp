package com.iti.model.DTO;

public class ProductDTO  {
    private int prodID;
    private String prodType;
    private String prodDesc;
    private int prodQuan;
    private String prodImg;
    private String prodPrice;

    public ProductDTO(int prodID, String prodName, String prodDesc, int prodQuan, String prodImg, String prodPrice) {
        this.prodID = prodID;
        this.prodType = prodName;
        this.prodDesc = prodDesc;
        this.prodQuan = prodQuan;
        this.prodImg = prodImg;

        this.prodPrice = prodPrice;
    }

    public ProductDTO(String prodDesc, String prodImg, String prodPrice) {
        this.prodDesc = prodDesc;
        this.prodImg = prodImg;
        this.prodPrice = prodPrice;
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

    public int getProdQuan() {
        return prodQuan;
    }

    public void setProdQuan(int prodQuan) {
        this.prodQuan = prodQuan;
    }

    public String getProdImg() {
        return prodImg;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }
    //private String prodSize;
    //private String prodCateg;


}
