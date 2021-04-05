package com.iti.controller.servlets;

import com.iti.model.DTO.ProductDTO;

import com.iti.model.DTO.RoleUser;
import com.iti.model.DTO.UserDTO;
import com.iti.service.ProductsService;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsService productsService =(ProductsService) req.getServletContext().getAttribute("ProductsService");
        products= productsService.retrieveMaxQuant();
        req.setAttribute("data",products);
      UserDTO userDTO= (UserDTO) req.getSession().getAttribute("currentUser");
        if(userDTO!=null && userDTO.getRole()== RoleUser.Admin_Role){
            RequestDispatcher view = req.getRequestDispatcher("proddata");
            view.forward(req, resp);

        }else {
            RequestDispatcher view = req.getRequestDispatcher("HomeJsp");
            view.forward(req, resp);

        }

    }

}
