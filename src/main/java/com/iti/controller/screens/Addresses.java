package com.iti.controller.screens;

import com.google.gson.Gson;
import com.iti.model.DTO.UserDTO;
import com.iti.service.ProfileService;
import com.iti.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;

@WebServlet("/Addresses")
public class Addresses extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");

        String newaddress = req.getParameter("newAddress");
        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        user.getAddresses().add(newaddress);
        profileService.editProfile(user);
        Gson gson = new Gson();
        List<String> results = user.getAddresses();
        resp.setCharacterEncoding("UTF-8");
        String resOrders = gson.toJson(results);
        PrintWriter writer = resp.getWriter();
        writer.write(resOrders);
        writer.close();



    }


}