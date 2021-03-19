package com.iti.controller.servlets;

import com.iti.model.DTO.ProductDTO;

import com.iti.service.HomeService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/Home")
public class Home extends HttpServlet {
    List<ProductDTO> products = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeService homeService=(HomeService) req.getServletContext().getAttribute("HomeService");
        products=homeService.retriveMaxiQuant();
        req.setAttribute("data",products);
        RequestDispatcher view = req.getRequestDispatcher("Home.jsp");
        view.forward(req, resp);

    }

}
