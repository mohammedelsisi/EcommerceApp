package com.iti.controller.screens;

import com.google.gson.Gson;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.service.ProductsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/Filter")
public class HomeFilters extends HttpServlet {
    Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);


        //TODO     this session has to be false
        ProductFilter filters = fillFilter(req);
        System.out.println(filters);
        session.setAttribute("Filters", filters);
        ProductsService productsService = (ProductsService) req.getServletContext().getAttribute("ProductsService");
        List<ProductDTO> productDTOS = productsService.retrieveFilteredProducts(filters);
        String productsList = gson.toJson(productDTOS);
        PrintWriter writer = resp.getWriter();
        writer.write("Done Received Filters");
        writer.flush();
        writer.close();
    }

    ProductFilter fillFilter(HttpServletRequest request) {
        String[] sizes = gson.fromJson(request.getParameter("sizes"), String[].class);
        System.out.println(Arrays.toString(sizes));
        String[] colors = gson.fromJson(request.getParameter("colors"), String[].class);
        System.out.println(Arrays.toString(colors));
        String searchParameter = request.getParameter("search");
        List<String> colorsList = new ArrayList<>();
        List<String> sizesList = new ArrayList<>();
        double minPrice = request.getParameter("minPrice").equals("") ? 0 : Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = request.getParameter("maxPrice").equals("") ? 0 : Double.parseDouble(request.getParameter("maxPrice"));
        Collections.addAll(colorsList,colors);
        Collections.addAll(sizesList,sizes);
        return new ProductFilter(colorsList,sizesList, searchParameter, minPrice, maxPrice);
    }

}
