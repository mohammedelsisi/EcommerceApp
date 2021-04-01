package com.iti.service;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.CartItemDao;
import com.iti.model.Dao.Imp.CartItemDaoImp;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.ProductDao;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.Cart;
import com.iti.model.entity.CartId;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.CartMapper;
import com.iti.model.mapper.OrderMapper;
import com.iti.model.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class BuyingService {
    private static final BuyingService BUYING_SERVICE = new BuyingService();

    public static synchronized BuyingService getInstance() {
        return BUYING_SERVICE;
    }

    public List<CartItemDTO> retrieveAllItems(long id) {
        CartItemDao cartItemDao = CartItemDaoImp.getInstance();
        List<Cart> carts = cartItemDao.retrieveAllItems(id);

        cartItemDao.close();
        return null;
    }

    public void updateCart(long userId, List<CartItemDTO> items) {
        CartItemDao cartItemDao = CartItemDaoImp.getInstance();
        List<Cart> cartList = new ArrayList<>();
        items.stream().forEach((e) -> {
            Cart entity = CartMapper.getInstance().getEntity(e, userId);
            cartList.add(entity);
        });
        cartItemDao.updateCart(cartList);
        cartItemDao.close();
    }
    public void removeCartItems(long userId, int [] items) {
        CartItemDao cartItemDao = CartItemDaoImp.getInstance();
        List<Cart> cartList = new ArrayList<>();
        for(int i:items){
            Cart cart = new Cart();
            CartId cartId = new CartId();
            cartId.setUserId(userId);
            cartId.setProductId(i);
            cart.setId(cartId);
            cartList.add(cart);
        }
        cartItemDao.removeCartItems(cartList);
        cartItemDao.close();
    }
    public void makeOrder(UserDTO userDTO, OrderDTO orderDTO) {
        CartItemDao cartItemDao = CartItemDaoImp.getInstance();
        UserDetails userDetails = UserMapper.getInstance().getUserEntity(userDTO);
        OrderDetail entity = OrderMapper.getInstance().getEntity(orderDTO, userDetails);
        cartItemDao.makeOrder(entity,orderDTO.getItems());
        cartItemDao.close();
        //TODO Update User Here to minus his credit and return user with orders
//        UserDao userDao = UserDAOImp.getInstance();

    }

}
