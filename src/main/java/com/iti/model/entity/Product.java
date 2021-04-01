// default package
// Generated Mar 27, 2021, 4:05:51 PM by Hibernate Tools 6.0.0.Alpha2
package com.iti.model.entity;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name="products"
        ,catalog="naseejstore"
)
public class Product implements java.io.Serializable {


    private long productId;
    private String type;
    private String description;
    private long quantity;
    private String size;
    private String color;

    @Column(name="color", nullable=false, length=45)
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", firstImg='" + firstImg + '\'' +
                ", secondImg='" + secondImg + '\'' +
                ", price=" + price +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String category;
    private String firstImg;
    private String secondImg;
    private double price;

    public Product() {
    }


    public Product(long productId, String type, long quantity, String size, String category, String firstImg, double price) {
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.size = size;
        this.category = category;
        this.firstImg = firstImg;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name="product_id", unique=true, nullable=false)
    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }


    @Column(name="type", nullable=false, length=60)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Column(name="description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="quantity", nullable=false)
    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    @Column(name="size", nullable=false, length=45)
    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Column(name="category", nullable=false, length=45)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Column(name="first_img", nullable=false, length=45)
    public String getFirstImg() {
        return this.firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }


    @Column(name="second_img", length=45)
    public String getSecondImg() {
        return this.secondImg;
    }

    public void setSecondImg(String secondImg) {
        this.secondImg = secondImg;
    }


    @Column(name="price", nullable=false, precision=10, scale=3)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}


