package com.iti.model.mapper;

import com.iti.model.DTO.CartItemDTOM;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.Cart;
import com.iti.model.entity.Product;
import com.iti.model.entity.UserDetails;

import java.util.Objects;

public class CartMapper {

    private static com.iti.model.mapper.CartMapper cartMapper;

    private CartMapper() {

    }

    public static synchronized CartMapper getInstance() {
        return Objects.requireNonNullElseGet(cartMapper, com.iti.model.mapper.CartMapper::getInstance);
    }

    public Cart getEntity(CartItemDTOM cartDTO) {
        Cart cart = new Cart();
//Todo the ID is composite between user and product ,need some decisions.
//        cart.setProductId(cartDTO.getCArtId());
//        cart.setType(productDTO.getProdName());
//        cart.setDescription(productDTO.getProdDescription());
//        cart.setQuantity(productDTO.getProdQuantity());
//        product.setSize(productDTO.getSize());
//        product.setCategory(productDTO.getCategory());
//        product.setFirstImg(productDTO.getFirstProdImg());
//        product.setSecondImg(productDTO.getSecondProdImg());
//        product.setPrice(productDTO.getProdPrice());

        return cart;
    }

//    public ProductDTO getDTO(Product product) {
//        ProductDTO productdto = new ProductDTO();
//
//        productdto.setProdID(product.getProductId());
//        productdto.setProdName(product.getType());
//        productdto.setProdDescription(product.getDescription());
//        productdto.setProdQuantity(product.getQuantity());
//        productdto.setSize(product.getSize());
//        productdto.setCategory(product.getCategory());
//        productdto.setFirstProdImg(product.getFirstImg());
//        productdto.setSecondProdImg(product.getSecondImg());
//        productdto.setProductPrice(product.getPrice());
//
//        return productdto;
//    }
}
