package com.iti.controller.screens;

import com.iti.model.DTO.UserDTO;
import com.iti.service.ProfileService;
import com.iti.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.lang.Double.parseDouble;

@WebServlet("/ChangePassword")
public class UserPassword extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List Data = changePassword(req);
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
        profileService.changePassword( (String) Data.get(1),(String) Data.get(2));
    }


    private List changePassword(HttpServletRequest req) {

        //System.out.println(req.getParameterMap());
        String currentPassword = req.getParameter("CurrentPassowrd");
        double newPassword = parseDouble(req.getParameter("NewPassword"));
        List<Object> Data = new ArrayList<>();
        Data.add(currentPassword);
        Data.add(newPassword);
        return Data;
    }

}

