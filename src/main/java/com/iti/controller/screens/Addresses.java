package com.iti.controller.screens;

import com.google.gson.Gson;
import com.iti.model.DTO.UserDTO;
import com.iti.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Addresses")
public class Addresses extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        String newaddress = req.getParameter("newAddress");

        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        user.getAddresses().add(newaddress);
        profileService.editProfile(user);
        //*******************************************//
        Gson gson = new Gson();
        List<String> results = user.getAddresses();
        resp.setCharacterEncoding("UTF-8");
        String resOrders = gson.toJson(results);
        resp.getWriter().write(resOrders);
        out.close();
        //*********************************************//
    }


}