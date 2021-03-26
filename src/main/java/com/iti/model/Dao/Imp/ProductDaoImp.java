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
    ProductDTO p1=new ProductDTO(1,"T-Shirt","Good T-shirt",50,"layout/images/men.jpg","layout/images/pass.jpg",300,"Large","Men");
    ProductDTO p2=new ProductDTO(2,"T-Shirt","Good T-shirt",50,"layout/images/men.jpg","layout/images/pass.jpg",300,"Large","Women");
    ProductDTO p3=new ProductDTO(3,"T-Shirt","Good T-shirt",50,"layout/images/men.jpg","layout/images/pass.jpg",300,"Large","Men");
    ProductDTO p4=new ProductDTO(4,"T-Shirt","Good T-shirt",50,"layout/images/men.jpg","layout/images/pass.jpg",300,"Large","Men");
    ProductDTO p5=new ProductDTO(5,"T-Shirt","Good T-shirt",50,"layout/images/men.jpg","layout/images/pass.jpg",300,"Large","Men");



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
        if(productFilter.isEmpty()){
           return retrieveAllProducts();
        }else {

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
    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.add("Men");
        list.add("Women");
        list.add("Children");
        return list;
    }

    @Override
    public List<String> getTypes() {
        List<String> list = new ArrayList<>();
        list.add("T-Shirt");
        list.add("Shirt");
        list.add("Cap");
        return list;
    }


    @Override
    public List<ProductDTO> retrieveAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p2);
        products.add(p5);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p2);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p4);
        products.add(p5);
        products.add(p5);
        products.add(p2);
        return products;
    }

}
