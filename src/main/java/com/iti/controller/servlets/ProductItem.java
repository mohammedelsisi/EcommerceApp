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

@WebServlet("/ProductItem")
public class ProductItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            long id = Long.parseLong(req.getParameter("id"));
            ProductsService productsService=(ProductsService) req.getServletContext().getAttribute("ProductsService");
            ProductDTO productDTO = productsService.retriveItem((int) id);
//        req.setAttribute("ProductItem",  productsService.retriveItem(id));
            RequestDispatcher view = req.getRequestDispatcher("ProductItemJsp");
            view.forward(req, resp);
        }catch (NumberFormatException e){
            System.out.println("Bad request");
        }

    }
}
