package com.iti.model.DTO;

public class ProductDTO  {
    private String prodID;
    private String prodName;
    private String prodDesc;
    private int prodQuan;
    private String prodImg;

    public ProductDTO(String prodID, String prodName, String prodDesc, int prodQuan, String prodImg) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodQuan = prodQuan;
        this.prodImg = prodImg;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
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
