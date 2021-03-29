package com.iti.model.Dao;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.entity.Cart;


import java.util.List;

public interface CartItemDao {
    List<Cart> retrieveAllItems (long userID);
    void updateCart(List<Cart>list);
    void removeCartItems(List<Cart>list);
     void close();
}
