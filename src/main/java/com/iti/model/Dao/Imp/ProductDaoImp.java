package com.iti.model.Dao.Imp;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.ProductDao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProductDaoImp implements ProductDao {
    private static final ProductDaoImp productDAOImp = new ProductDaoImp();

    public static synchronized ProductDaoImp getInstance() {
        return productDAOImp;
    }

    ProductDTO p1=new ProductDTO("Finding perfect t-shirt","images/cloth_1.jpg",50);
    ProductDTO p2=new ProductDTO("Finding perfect t-shirt","images/cloth_2.jpg",50);
    ProductDTO p3=new ProductDTO("Finding perfect t-shirt","images/cloth_3.jpg",50);
    ProductDTO p4=new ProductDTO("Finding perfect t-shirt","images/cloth_1.jpg",50);
    ProductDTO p5=new ProductDTO("Finding perfect t-shirt","images/cloth_2.jpg",50);


    @Override
    public List<ProductDTO> retriveMaxiQuant() {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        return products;
    }

    @Override
    public List<ProductDTO> retrieveFilteredProducts(ProductFilter productFilter) {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        return products;
    }

    @Override
    public List<String> getSizes() {
        List<String> list = new ArrayList<>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        return list;
    }

    @Override
    public List<String> getColors() {
        List<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        return list;
    }

    @Override
    public  ProductDTO retriveItem(int id) {

        ProductDTO productDTO=new ProductDTO("Get ready to hum, strum, and succumb to officially licensed Fender styles! If you've always wanted your very own Stratocaster guitar, now is your chance to get one! Or... at least get one on a rockin' tee! America's favorite guitar brand is the perfect way to show your rock and roll fashion with tees that celebrate the coolest guitars, amps, and more. As Fender says, you won't part with your Fender tees either"
        ,"images/cloth_1.jpg","images/cloth_2.jpg",50);

        return productDTO;
    }

    @Override
    public List<ProductDTO> retrieveAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5); products.add(p1);
        products.add(p2);        products.add(p5); products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);  products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p5); products.add(p1);
        products.add(p2);

        return products;
    }

}
