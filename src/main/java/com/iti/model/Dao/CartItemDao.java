package com.iti.model.Dao;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.entity.Cart;
import com.iti.model.entity.OrderDetail;


import java.util.List;
import java.util.Set;

public interface CartItemDao {
    List<Cart> retrieveAllItems (long userID);
    void updateCart(List<Cart>list);
    void removeCartItems(List<Cart>list);
     void close();
     void makeOrder(OrderDetail orderDetail, Set<CartItemDTO> list);
}
