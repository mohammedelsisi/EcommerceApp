package com.iti.model.Dao;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.entity.OrderDetail;

import java.util.List;

public interface OrderDao {


    List<OrderDetail> retrieveFilteredOrders();
    OrderDetail retrieveOrderByID();


}
