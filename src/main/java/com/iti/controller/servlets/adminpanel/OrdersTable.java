package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.OrderDTO;
import com.iti.service.OrdersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/OrdersServlet")
public class OrdersTable extends HttpServlet {

    Gson json = new Gson();

    private static OrderDTO getOrderFromRequest(HttpServletRequest request) {
        OrderDTO filter = new OrderDTO();
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("selectedAddress"));
        System.out.println(request.getParameter("purchaseDate"));
        System.out.println(request.getParameter("email"));

        if (request.getParameter("id") != null)
            filter.setId(Long.parseLong(request.getParameter("id")));

            filter.setSelectedAddress(request.getParameter("selectedAddress"));

        if (request.getParameter("purchaseDate").length() > 0) {
            System.out.println(request.getParameter("purchaseDate"));
            try {
                filter.setPurchaseDate(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("purchaseDate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(filter.getPurchaseDate());
        }


            filter.setEmail(request.getParameter("email"));
        System.out.println(filter);

        return filter;

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersService ordersService = (OrdersService) request.getServletContext().getAttribute("OrdersService");
        OrderDTO filter = getOrderFromRequest(request);
        List<OrderDTO> result = ordersService.retrieveOrdersWithFilter(filter);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String resOrders = json.toJson(result);
        response.getWriter().write(resOrders);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
