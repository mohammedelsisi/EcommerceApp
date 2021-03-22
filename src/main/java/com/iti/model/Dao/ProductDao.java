package com.iti.model.Dao;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;

import java.util.List;

public interface ProductDao {
    List<ProductDTO> retriveMaxiQuant ();
    List<ProductDTO> retrieveAllProducts ();
    List<ProductDTO> retrieveFilteredProducts (ProductFilter productFilter);
     List<String> getSizes();
     List<String> getColors();
    ProductDTO retriveItem(int id);

}
