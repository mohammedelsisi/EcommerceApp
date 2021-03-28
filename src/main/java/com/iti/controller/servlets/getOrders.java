package com.iti.controller.servlets;

import com.iti.model.DTO.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Orders")
public class getOrders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       UserDTO userDTO= (UserDTO) req.getSession().getAttribute("currentUser");
       req.setAttribute("orders",userDTO.getOrders());
       req.getRequestDispatcher("OrderJSP").forward(req,resp);
    }
}
