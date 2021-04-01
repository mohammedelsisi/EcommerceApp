package com.iti.service;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.Imp.OrderDaoImp;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.OrderDao;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.OrderDetail;

import java.util.List;

public class OrdersService {

    private static final OrdersService ORDERS_SERVICE = new OrdersService();

    public static synchronized OrdersService getInstance(){return ORDERS_SERVICE;}

    public List<OrderDTO> retrieveOrdersWithFilter(OrderDTO filter){
        OrderDao orderDao = OrderDaoImp.getInstance();
        OrderDetail order = OrderMapper
    }
}
