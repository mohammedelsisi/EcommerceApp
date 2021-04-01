package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.service.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet("/OrderssServlet")
public class OrdersTable extends HttpServlet {

    Gson json = new Gson();
    private static OrderDTO getProductFromRequest(HttpServletRequest request) {
        OrderDTO filter = new OrderDTO();

        if (request.getParameter("id") != null)
            filter.setId(Long.parseLong(request.getParameter("prodID")));
        filter.setSelectedAddress(request.getParameter("selectedAddress"));
        try {
            filter.setPurchaseDate(new SimpleDateFormat("dd/MM/yyyy").parse("purchaseDate"));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        filter.setEmail(request.getParameter("email"));

        return filter;

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersService ordersService = (OrdersService) request.getServletContext().getAttribute("OrdersService");
    }
}
