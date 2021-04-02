package com.iti.model.mapper;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.Product;
import com.iti.model.entity.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class OrderMapper {
    private static final OrderMapper orderMapper = new OrderMapper();

    private OrderMapper() {

    }

    public static synchronized OrderMapper getInstance() {
        return orderMapper;
    }

    public OrderDetail getEntity(OrderDTO orderDTO, UserDetails userDetails) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPurchaseDate(orderDTO.getPurchaseDate());
        orderDetail.setSelectedAddress(orderDTO.getSelectedAddress());
        orderDetail.setUserDetails(userDetails);
        return orderDetail;
    }

    public OrderDTO getDTO(OrderDetail orderDetail) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderDetail.getOrderId());
        orderDTO.setEmail(orderDetail.getUserDetails().getEmail());
        orderDTO.setPurchaseDate(orderDetail.getPurchaseDate());
        orderDTO.setSelectedAddress(orderDetail.getSelectedAddress());
        Set<CartItemDTO> products = new HashSet<>();
        orderDetail.getOrderHasProducts()
                .stream()
                .forEach(orderHasProducts -> {
                    CartItemDTO cart = new CartItemDTO();
                    Product prod = orderHasProducts.getProduct();
                    cart.setProductID(prod.getProductId());
                    cart.setItemPrice(prod.getPrice());
                    cart.setItemImg(prod.getFirstImg());
                    cart.setItemQuantity(prod.getQuantity());
                    cart.setItemType(prod.getType());
                    products.add(cart);
                });

        orderDTO.setItems(products);
        return orderDTO;
    }
}
