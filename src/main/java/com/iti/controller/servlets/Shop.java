package com.iti.controller.servlets;

import com.iti.model.DTO.ProductDTO;
import com.iti.service.ProductsService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/Shop")
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("Page");
        int n;
        if (page == null) n = 0;else n = Integer.parseInt(page)-1;
        ProductsService productsService = (ProductsService) req.getServletContext().getAttribute("ProductsService");
        List<ProductDTO> collectedProducts = productsService.retrieveAllProducts().stream().skip(n).limit(15).collect(Collectors.toList());
        req.setAttribute("Products", collectedProducts);
        System.out.println(collectedProducts);
        RequestDispatcher view = req.getRequestDispatcher("ShopJsp");
        view.forward(req, resp);
    }

}
