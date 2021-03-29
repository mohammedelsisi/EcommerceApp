package com.iti.controller.servlets;

import com.iti.model.DTO.CartItemDTO;
import com.iti.service.BuyingService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BuyingService buyingService = (BuyingService) req.getServletContext().getAttribute("BuyingService");
//        List<CartItemDTO> items = buyingService.retrieveAllItems();
        List<CartItemDTO> items= (List<CartItemDTO>) req.getSession().getAttribute("Cart");
        req.setAttribute("CartItems", items);
        RequestDispatcher view = req.getRequestDispatcher("CartJSP");
        view.forward(req, resp);
    }
}
