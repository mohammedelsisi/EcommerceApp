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
        ProductDao productDao = ProductDaoImp.getInstance();
        return productDao.getSizes();
    }

    public List<String> getColors() {
        ProductDao productDao = ProductDaoImp.getInstance();

        List<String> colors = productDao.getColors();
        productDao.close();
        return colors;
    }
    public List<String> getCategories(){
        ProductDao productDao = ProductDaoImp.getInstance();

        List<String> categories = productDao.getCategories();
        productDao.close();
        return categories;
    }
    public List<String> getTypes(){
        ProductDao productDao = ProductDaoImp.getInstance();
        List<String> types = productDao.getTypes();
        productDao.close();
        return types;
    }

    public List<ProductDTO> retrieveProductswithFilter(ProductDTO filter) {
        ProductDao productDao = ProductDaoImp.getInstance();
        Product filteringProduct = ProductMapper.getInstance().getEntity(filter);
        List<Product> products = productDao.retrieveProductswithFilter(filteringProduct);
        List<ProductDTO> list = new ArrayList<>();
        products.forEach(e->{
            list.add(ProductMapper.getInstance().getDTO(e));
        });
        productDao.close();
        return list;
    }
    public Boolean updateProduct(ProductDTO productToUpdate) {

        ProductDao productDao = ProductDaoImp.getInstance();
        Product updatingProduct = ProductMapper.getInstance().getEntity(productToUpdate);
        Boolean status = productDao.updateProduct(updatingProduct);
        productDao.close();

        return status;
    }

    public Boolean insertProduct(ProductDTO productToInsert) {
        ProductDao productDao = ProductDaoImp.getInstance();
        Product insertingProduct = ProductMapper.getInstance().getEntity(productToInsert);
        Boolean status = productDao.insertProduct(insertingProduct);
        productDao.close();

        return status;

    }

    public Boolean deleteProduct(ProductDTO productToDelete) {
        ProductDao productDao = ProductDaoImp.getInstance();
        Product deletingProduct = ProductMapper.getInstance().getEntity(productToDelete);
        Boolean status = productDao.deleteProduct(deletingProduct);
        productDao.close();

        return status;

    }
}
