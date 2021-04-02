package com.iti.controller.servlets;

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

@WebServlet("/EditingUser")
public class Profile extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        fillUserData(req, user);
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
        profileService.editProfile(user);

    }


    private UserDTO fillUserData(HttpServletRequest req, UserDTO user) {

        Date birthDate;
        user.setUserName(req.getParameter("userName"));
        double creditLimit = req.getParameter("creditLimit").equals("") ? 0 : Double.parseDouble(req.getParameter("creditLimit"));
        user.setCreditLimit(creditLimit);
        String birthDateString = req.getParameter("birthDate");
        Date parsedDate=null;
        try {
            parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString);

        } catch (Exception e) {
           e.printStackTrace();
        }
        user.setBirthday(parsedDate);
        user.setJob(req.getParameter("job"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        return user;
    }

}

