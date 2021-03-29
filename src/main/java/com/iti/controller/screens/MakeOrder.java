package com.iti.controller.screens;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.service.BuyingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;

@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedAddress = req.getParameter("address");
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("currentUser");
        List<CartItemDTO>items = (List<CartItemDTO>) req.getSession().getAttribute( "Cart");
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setSelectedAddress(selectedAddress);
        Set<CartItemDTO>itemsSet= new HashSet<>();
        items.forEach((e)->{
            itemsSet.add(e);
        });
        orderDTO.setItems(itemsSet);
        orderDTO.setPurchaseDate(new Date());

        BuyingService.getInstance().makeOrder(userDTO,orderDTO);
    }
}
