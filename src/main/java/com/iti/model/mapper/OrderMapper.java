package com.iti.model.mapper;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.UserDetails;

import java.util.Date;

public class OrderMapper {
    private OrderMapper(){

    }
    private static final OrderMapper orderMapper= new OrderMapper();
    public static synchronized OrderMapper getInstance(){
        return orderMapper;
    }

    public OrderDetail getEntity(OrderDTO orderDTO, UserDetails userDetails){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPurchaseDate(orderDTO.getPurchaseDate());
        orderDetail.setSelectedAddress(orderDTO.getSelectedAddress());
        orderDetail.setUserDetails(userDetails);
        return orderDetail;
    }
}
