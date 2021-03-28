package com.iti.service;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Product;
import com.iti.model.mapper.ProductMapper;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        ProductDao productDao = ProductDaoImp.getInstance();
        List<Product> products = productDao.retrieveFilteredProducts(productFilter);
        List<ProductDTO> list = products.stream().map(ProductMapper.getInstance()::getDTO).collect(Collectors.toList());
        productDao.close();
        return list;

    }

    public ProductDTO retrieveItem(long id) {
        ProductDao productDao = ProductDaoImp.getInstance();
        ProductDTO dto = null;
        Product product = productDao.retrieveItem(id);
        if (product != null) {
            dto = ProductMapper.getInstance().getDTO(product);
        }
        productDao.close();
        return dto;
    }


    public List<String> getSizes() {
        List<String> list = new ArrayList<>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        return list;
    }

    public List<String> getColors() {
        List<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        return list;
    }

    public List<String> getCategories() {
//        return productDao.getCategories();
        return null;
    }

    public List<String> getTypes() {
//        return productDao.getTypes();
        return null;
    }

}
