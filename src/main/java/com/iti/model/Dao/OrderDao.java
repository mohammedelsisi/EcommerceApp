package com.iti.model.Dao;

import com.iti.model.DTO.OrderDTO;

import java.util.List;

public interface OrderDao {

    List<OrderDTO> retrieveAllOrders();
    List<OrderDTO> retrieveFilteredOrders();


}
