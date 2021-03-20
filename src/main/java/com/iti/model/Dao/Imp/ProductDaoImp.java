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

    ProductDTO p1=new ProductDTO("Finding perfect t-shirt","images/cloth_1.jpg",50);
    ProductDTO p2=new ProductDTO("Finding perfect t-shirt","images/cloth_2.jpg",50);
    ProductDTO p3=new ProductDTO("Finding perfect t-shirt","images/cloth_3.jpg",50);
    ProductDTO p4=new ProductDTO("Finding perfect t-shirt","images/cloth_1.jpg",50);
    ProductDTO p5=new ProductDTO("Finding perfect t-shirt","images/cloth_2.jpg",50);
    List<ProductDTO> products = new ArrayList<>();

    @Override
    public List<ProductDTO> retriveMaxiQuant() {
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        return products;
    }
}
