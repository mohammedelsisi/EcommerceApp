package com.iti.service;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Product;
import com.iti.model.mapper.ProductMapper;


import java.util.ArrayList;
import java.util.List;

public class ProductsService {

    private static final ProductsService PRODUCTS_SERVICE = new ProductsService();

    public static synchronized ProductsService getInstance() {
        return PRODUCTS_SERVICE;
    }

    public List<ProductDTO> retrieveMaxQuant() {
        ProductDao productDao = ProductDaoImp.getInstance();
        List<Product> products = productDao.reteriveMaxProducts();
        List<ProductDTO> list = new ArrayList<>();
        products.forEach((e) -> {
            list.add(ProductMapper.getInstance().getDTO(e));
        });
        productDao.close();
        return list;
    }

    public List<ProductDTO> retrieveAllProducts() {
//        return productDao.retrieveAllProducts();
        return null;
    }

    public List<ProductDTO> retrieveFilteredProducts(ProductFilter productFilter) {

//        return productDao.retrieveFilteredProducts(productFilter);
        return null;

    }


    public List<String> getSizes() {

//        return productDao.getSizes();
        return null;
    }

    public List<String> getColors() {
    public List<String> getCategories(){
        return productDao.getCategories();
    }
    public List<String> getTypes(){
        return productDao.getTypes();
    }
    public List<String> getColors( ) {

//        return productDao.getColors();
        return null;
    }
}
