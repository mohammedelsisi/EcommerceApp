package com.iti.model.Dao;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product>  reteriveMaxProducts ();
    List<ProductDTO> retrieveAllProducts ();
    List<Product> retrieveFilteredProducts (ProductFilter productFilter);
    List<String> getSizes();
    List<String> getColors();
    void close();
    List<String> getCategories();

    List<String> getTypes();
    Product retrieveItem(long id);
    Product getProductById(long id);
    List<Product> retrieveProductswithFilter(Product filteredProduct);

    Boolean updateProduct(Product updatingProduct);

    Boolean insertProduct(Product insertingProduct);

    Boolean deleteProduct(Product deletingProduct);

}
