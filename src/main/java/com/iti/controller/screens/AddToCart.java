package com.iti.controller.screens;


import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.Product;
import com.iti.service.BuyingService;
import com.iti.service.ProductsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long prodId = Long.parseLong(req.getParameter("productID"));
        int Quantity = Integer.parseInt(req.getParameter("Quantity"));
        ProductDTO productDTO = ProductsService.getInstance().retrieveItem(prodId);
        List<CartItemDTO> items = (List<CartItemDTO>) req.getSession().getAttribute("Cart");
        Optional<CartItemDTO> first = items.stream().filter(e -> {
            long x = e.getProductID();
            return x == prodId;
        }).findFirst();
        if (first.isPresent()) {
            first.get().setItemQuantity(first.get().getItemQuantity() + Quantity);
        } else {

            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setProductID(productDTO.getProdID());
            cartItemDTO.setItemImg(productDTO.getFirstProdImg());
            cartItemDTO.setItemPrice(productDTO.getProdPrice());
            cartItemDTO.setItemType(productDTO.getProdType());
            cartItemDTO.setItemQuantity(Quantity);
            items.add(cartItemDTO);
        }
        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        if(user!=null){
            BuyingService.getInstance().updateCart(user.getId(),items);
            System.out.println("######"+user);
        }
        System.out.println(items);
        req.getSession().setAttribute("Cart",items);
        System.out.println(Quantity);


    }

}
