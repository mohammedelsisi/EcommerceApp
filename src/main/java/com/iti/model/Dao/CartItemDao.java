package com.iti.model.Dao;

import com.iti.model.DTO.CartItemDTO;


import java.util.List;

public interface CartItemDao {
    List<CartItemDTO> retrieveAllItems ();
}
