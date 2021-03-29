package com.iti.service;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.CartItemDao;
import com.iti.model.Dao.Imp.CartItemDaoImp;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;

import java.util.List;

public class BuyingService {
    private static final BuyingService BUYING_SERVICE = new BuyingService();
    private final CartItemDao cartItemDao=CartItemDaoImp.getInstance();

    public static synchronized BuyingService getInstance() {
        return BUYING_SERVICE;
    }
    public List<CartItemDTO> retrieveAllItems() {
        return cartItemDao.retrieveAllItems();
    }
}
