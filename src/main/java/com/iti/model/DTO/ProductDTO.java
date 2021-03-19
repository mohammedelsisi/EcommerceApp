package com.iti.model.DTO;

public class ProductDTO  {
    private int prodID;
    private String prodName;
    private String prodDesc;
    private int prodQuan;
    private String prodImg;

    public ProductDTO(int prodID, String prodName, String prodDesc, int prodQuan, String prodImg) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodQuan = prodQuan;
        this.prodImg = prodImg;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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
    //private String prodSize;
    //private String prodCateg;


}
