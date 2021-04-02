package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.ProductDTO;
import com.iti.service.ProductsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductsServlet")
public class ProductsTable extends HttpServlet {

    Gson json = new Gson();

    private static ProductDTO getProductFromRequest(HttpServletRequest request) {
        ProductDTO filter = new ProductDTO();


        if (request.getParameter("prodID") != null)
            filter.setProdID(Long.parseLong(request.getParameter("prodID")));
        filter.setProdType(request.getParameter("prodType"));

        filter.setProdDescription(request.getParameter("prodDesc"));

        if (request.getParameter("prodQuantity") != null)
            filter.setProdQuantity(Integer.parseInt(request.getParameter("prodQuantity")));

        filter.setFirstProdImg(request.getParameter("firstProdImg"));
        filter.setSecondProdImg(request.getParameter("secondProdImg"));

        if (request.getParameter("productPrice") != null)
            filter.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));

        filter.setSize(request.getParameter("size"));
        filter.setColor(request.getParameter("color"));
        filter.setCategory(request.getParameter("category"));

        return filter;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsService productsService = (ProductsService) request.getServletContext().getAttribute("ProductsService");

        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                List<ProductDTO> products;
                ProductDTO filter = getProductFromRequest(request);
                products = productsService.retrieveProductswithFilter(filter);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String prods = json.toJson(products);
                response.getWriter().write(prods);
                break;
            }
            case "getMeta": {
                List<List<String>> meta = new ArrayList<>();
                List<String> types = productsService.getTypes();
                types.add(0,"");
                meta.add(types);
                List<String> sizes = productsService.getSizes();
                sizes.add(0,"");
                meta.add(sizes);
                List<String> categories = productsService.getCategories();
                categories.add(0,"");
                meta.add(categories);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String metaJson = json.toJson(meta);
                response.getWriter().write(metaJson);
                break;
            }
            case "update": {
                ProductDTO productToUpdate = getProductFromRequest(request);
                productsService.updateProduct(productToUpdate);
                break;
            }
            case "insert": {
                ProductDTO productToInsert = getProductFromRequest(request);
                Boolean status = productsService.insertProduct(productToInsert);
                System.out.println(status);
                break;
            }
            case "delete": {
                ProductDTO productToDelete = getProductFromRequest(request);
                Boolean status = productsService.deleteProduct(productToDelete);
                System.out.println(status);
                break;
            }
        }


    }
}
