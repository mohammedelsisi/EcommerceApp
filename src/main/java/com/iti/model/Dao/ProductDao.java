package com.iti.model.Dao;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product>  reteriveMaxProducts ();
    List<ProductDTO> retrieveAllProducts ();
    List<ProductDTO> retrieveFilteredProducts (ProductFilter productFilter);
     List<String> getSizes();
     List<String> getColors();
    void close();
    List<ProductDTO> retriveMaxiQuant();

    List<ProductDTO> retrieveAllProducts();

    List<ProductDTO> retrieveFilteredProducts(ProductFilter productFilter);

    List<String> getSizes();

    List<String> getColors();

    List<String> getCategories();

    List<String> getTypes();

}
