package com.iti.model.mapper;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.RoleUser;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.*;

import java.util.Objects;
import java.util.stream.Collectors;

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
    public CartItemDTO getCartDTO(Cart cart){
        CartItemDTO cartItemDTO=new CartItemDTO();
        cartItemDTO.setItemQuantity(cart.getQuantity());
        Product product1 = cart.getProduct();
        cartItemDTO.setProductID(product1.getProductId());
        cartItemDTO.setItemImg(product1.getFirstImg());
        cartItemDTO.setItemType(product1.getType());
        cartItemDTO.setItemPrice(product1.getPrice());
        return cartItemDTO;
    }


}
