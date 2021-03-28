package com.iti.model.Dao.Imp;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.ProductDao;

import java.util.ArrayList;
import java.util.List;

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
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//        products.add(p4);
//        products.add(p5);

        return null;

    }

    @Override
    public List<ProductDTO> retrieveAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        return products;
    }
}
