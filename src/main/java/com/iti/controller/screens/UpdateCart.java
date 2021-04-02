package com.iti.controller.screens;

import com.google.gson.Gson;
import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.Cart;
import com.iti.service.BuyingService;
import com.iti.service.ProductsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDS = req.getParameter("productIds");
        String qts = req.getParameter("productQtn");
        String removedItemarr = req.getParameter("removedItems");

        int[] productID = new Gson().fromJson(IDS, int[].class);
        int[] qunatity = new Gson().fromJson(qts, int[].class);
        int[] removedItems = new Gson().fromJson(removedItemarr, int[].class);
        System.out.println(Arrays.toString(productID));
        System.out.println(Arrays.toString(qunatity));
        System.out.println(Arrays.toString(removedItems));
        List<CartItemDTO>cart = new ArrayList<>();
        for (int i = 0; i < productID.length; i++) {
            ProductDTO productDTO = ProductsService.getInstance().retrieveItem(productID[i]);
            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setProductID(productDTO.getProdID());
            cartItemDTO.setItemImg(productDTO.getFirstProdImg());
            cartItemDTO.setItemPrice(productDTO.getProductPrice());
            cartItemDTO.setItemType(productDTO.getProdType());
            cartItemDTO.setItemQuantity(qunatity[i]);
            cart.add(cartItemDTO);
        }

        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        if (user != null) {
            BuyingService.getInstance().updateCart(user.getId(), cart);
            BuyingService.getInstance().removeCartItems(user.getId(),removedItems);
        }
        System.out.println(cart);
        req.getSession().setAttribute("Cart", cart);

    }
}

