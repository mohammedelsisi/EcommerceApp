package com.iti.model.mapper;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.Cart;
import com.iti.model.entity.CartId;
import com.iti.model.entity.Product;
import com.iti.model.entity.UserDetails;

import java.util.Objects;

public class CartMapper {

    private static final CartMapper cartMapper = new CartMapper();

    private CartMapper() {

    }

    public static synchronized CartMapper getInstance() {
        return cartMapper;
    }

    public Cart getEntity(CartItemDTO cartDTO,long userId) {
        Cart cart = new Cart();
        CartId cartId = new CartId();
        cartId.setProductId(cartDTO.getProductID());
        cartId.setUserId(userId);
        cart.setId(cartId);
        cart.setQuantity(cartDTO.getItemQuantity());
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
