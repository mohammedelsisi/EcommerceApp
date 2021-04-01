package com.iti.model.Dao.Imp;

import com.iti.model.Dao.OrderDao;
import com.iti.model.entity.OrderDetail;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDaoImp implements OrderDao {
    EntityManager entityManager;

    private OrderDaoImp(){
       entityManager=  DatabaseManager.getFactory().createEntityManager();
    }
    public static OrderDaoImp getInstance(){
        return new OrderDaoImp();
    }
    @Override
    public List<OrderDetail> retrieveFilteredOrders() {
        return null;
    }

    @Override
    public OrderDetail retrieveOrderByID() {
        return null;
    }
}
