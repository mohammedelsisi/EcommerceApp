package com.iti.service;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;


import java.util.List;

public class ProductsService {

    private static final ProductsService PRODUCTS_SERVICE = new ProductsService();
    private final ProductDao productDao = ProductDaoImp.getInstance();

    public static synchronized ProductsService getInstance() {
        return PRODUCTS_SERVICE;
    }

    public List<ProductDTO> retriveMaxiQuant() {
        return productDao.retriveMaxiQuant();
    }

    public List<ProductDTO> retrieveAllProducts() {
        return productDao.retrieveAllProducts();
    }

    public List<ProductDTO> retrieveFilteredProducts(ProductFilter productFilter) {

        return productDao.retrieveFilteredProducts(productFilter);
    }


    public List<String> getSizes() {

        return productDao.getSizes();
    }
    public List<String> getCategories(){
        return productDao.getCategories();
    }
    public List<String> getTypes(){
        return productDao.getTypes();
    }
    public List<String> getColors( ) {

        return productDao.getColors();
    }
}
