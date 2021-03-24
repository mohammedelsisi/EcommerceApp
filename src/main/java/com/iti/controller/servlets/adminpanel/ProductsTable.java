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
import java.util.List;

@WebServlet("/ProductsTable")
public class ProductsTable extends HttpServlet {

    Gson json = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsService productsService =(ProductsService) request.getServletContext().getAttribute("ProductsService");

        String action= request.getParameter("action");

        switch (action)
        {
            case "load" : {
                //TODO : make method get products filtered
                //ProductDTO filter = getFilter(request);
                //List<ProductDTO>  filteredProducts =dataTablesService.retriveAllProducts(filter);
                List<ProductDTO> products =productsService.retrieveAllProducts();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String prods= json.toJson(products);
                response.getWriter().write(prods);
                break;
            }
            case "update":{
                System.out.println(request.getParameter("prodID"));
                ProductDTO productToInset = getProductFromRequest(request);
                System.out.println(productToInset);
                break;
            }
            case "insert":{
                System.out.println(request.getParameter("prodID"));
                ProductDTO productToInset = getProductFromRequest(request);
                System.out.println(productToInset);
                break;
            }
            case "delete":{
                System.out.println(request.getParameter("prodID"));
                ProductDTO productToInset = getProductFromRequest(request);
                System.out.println(productToInset);
                break;
            }
        }


    }



    private ProductDTO getProductFromRequest(HttpServletRequest request){
        ProductDTO filter = new ProductDTO();
        filter.setProdID(Integer.parseInt(request.getParameter("prodID")));
        filter.setProdType(request.getParameter("prodType"));
        //filter.setProdDesc();
        filter.setProdQuantity(Integer.parseInt(request.getParameter("prodQuantity")));
        filter.setFirstProdImg(request.getParameter("firstProdImg"));
        filter.setSecondProdImg(request.getParameter("secondProdImg"));
        filter.setProductPrice(Double.parseDouble(request.getParameter("productPrice")));
        filter.setSize(request.getParameter("size"));
        filter.setCategory(request.getParameter("category"));

        return filter;
    }
}
