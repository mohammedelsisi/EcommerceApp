package com.iti.model.Dao;

import com.iti.model.DTO.ProductDTO;
import java.util.List;

public interface ProductDao {
    List<ProductDTO> retriveMaxiQuant ();
    List<ProductDTO> retrieveAllProducts();
}
