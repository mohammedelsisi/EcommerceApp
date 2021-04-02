package com.iti.controller.servlets;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.utils.authentication.SavingUserService;
import com.iti.service.ProductsService;
import jakarta.servlet.RequestDispatcher;
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
import java.util.stream.Collectors;

@WebServlet("/Shop")
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ProductFilter productFilter = (ProductFilter) httpSession.getAttribute("Filters");
        System.out.println(productFilter);
        String page = req.getParameter("page");
        int n;
        if (page == null) n = 0;else n = Integer.parseInt(page)-1;
        ProductsService productsService = (ProductsService) req.getServletContext().getAttribute("ProductsService");
        List<ProductDTO> allProduct = productsService.retrieveFilteredProducts(productFilter);
        int pages= allProduct.size()/12+1;
        List<ProductDTO> collectedProducts = allProduct.stream().skip(n* 12L).limit(12).collect(Collectors.toList());
        req.setAttribute("Products", collectedProducts);
        req.setAttribute("Pages", pages);
        RequestDispatcher view = req.getRequestDispatcher("ShopJsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ProductFilter filters = fillFilter(req);
        System.out.println(filters);
        System.out.println(filters);
        session.setAttribute("Filters", filters);
        resp.sendRedirect("Shop");
    }

    ProductFilter fillFilter(HttpServletRequest request) {
        String[] sizes =request.getParameterValues("Size")==null?new String[0]:request.getParameterValues("Size");
        String[] colors =request.getParameterValues("Color")==null?new String[0]:request.getParameterValues("Color");
        String[] cates =request.getParameterValues("Category")==null?new String[0]:request.getParameterValues("Category");
        System.out.println(Arrays.toString(sizes));
        System.out.println(Arrays.toString(colors));
        String searchParameter = request.getParameter("Search");
        List<String> colorsList = new ArrayList<>();
        List<String> sizesList = new ArrayList<>();
        List<String> catesList = new ArrayList<>();
        double minPrice = request.getParameter("minPrice").equals("") ? 0 : Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = request.getParameter("maxPrice").equals("") ? 0 : Double.parseDouble(request.getParameter("maxPrice"));
        Collections.addAll(colorsList,colors);
        Collections.addAll(sizesList,sizes);
        Collections.addAll(catesList,cates);
        return ProductFilter.createFilledFilter(colorsList, sizesList,catesList, searchParameter, minPrice, maxPrice);
    }

}
