package com.iti.model.mapper;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.Product;
import com.iti.model.entity.UserDetails;

import java.util.Objects;

public class ProductMapper {

    private static final ProductMapper productMapper = new ProductMapper();

    private ProductMapper() {

    }

    public static synchronized ProductMapper getInstance() {
        return productMapper;
    }

    public Product getEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setProductId(productDTO.getProdID());
        product.setType(productDTO.getProdName());
        product.setDescription(productDTO.getProdDescription());
        product.setQuantity(productDTO.getProdQuantity());
        product.setSize(productDTO.getSize());
        product.setCategory(productDTO.getCategory());
        product.setFirstImg(productDTO.getFirstProdImg());
        product.setSecondImg(productDTO.getSecondProdImg());
        product.setPrice(productDTO.getProductPrice());
        product.setColor(productDTO.getColor());

        return product;
    }

    public ProductDTO getDTO(Product product) {
        ProductDTO productdto = new ProductDTO();

        productdto.setProdID(product.getProductId());
        productdto.setProdName(product.getType());
        productdto.setProdDescription(product.getDescription());
        productdto.setProdQuantity(product.getQuantity());
        productdto.setSize(product.getSize());
        productdto.setCategory(product.getCategory());
        productdto.setFirstProdImg(product.getFirstImg());
        productdto.setSecondProdImg(product.getSecondImg());
        productdto.setProductPrice(product.getPrice());
        productdto.setColor(product.getColor());

        return productdto;
    }
}
