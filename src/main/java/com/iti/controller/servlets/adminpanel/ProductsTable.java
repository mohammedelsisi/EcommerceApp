package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.ProductDTO;
import com.iti.service.DataTablesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductsTable")
public class ProductsTable extends HttpServlet {
    List<ProductDTO> products = new ArrayList<>();
    Gson json = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataTablesService dataTablesService =(DataTablesService) request.getServletContext().getAttribute("DataTablesService");
        products= dataTablesService.retriveAllProducts();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String prods= json.toJson(products);

        response.getWriter().write(prods);


    }
}
