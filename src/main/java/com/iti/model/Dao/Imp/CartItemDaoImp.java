package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.CartItemDao;

import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImp implements CartItemDao {
    private static final CartItemDaoImp cartItemDaoImp = new CartItemDaoImp();

    public static synchronized CartItemDaoImp getInstance() {
        return cartItemDaoImp;
    }
    CartItemDTO c1=new CartItemDTO("shirt",50.0,1,"images/cloth_1.jpg");
    CartItemDTO c2=new CartItemDTO("shirt",50.0,1,"images/cloth_2.jpg");


    @Override
    public List<CartItemDTO> retrieveAllItems() {
        List<CartItemDTO> cart = new ArrayList<>();
        cart.add(c1);
        cart.add(c2);
        return cart;
    }
}
