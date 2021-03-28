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
        //TODO Done : no image, no row date list (used DTO instead)
        UserDTO user = fillUserData(req);
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
        profileService.editProfile( user );
        // TODO data receive here now we need to use it.

     /*   String userName = req.getParameter("userName");
        double creditLimit = parseDouble(req.getParameter("creditLimit"));
        String birthDate = req.getParameter("birthDate");
        String job = req.getParameter("job");
        System.out.println(userName);
        System.out.println(creditLimit);
        System.out.println(birthDate);
        System.out.println(job);*/


    }


    private UserDTO fillUserData(HttpServletRequest req) {

        Date birthDate;
        String userName = req.getParameter("userName");
        double creditLimit = parseDouble(req.getParameter("creditLimit"));
        String birthDateString = req.getParameter("birthDate");
        try {
            birthDate= new SimpleDateFormat("dd/MM/yyyy").parse(birthDateString);
        }catch (Exception e){birthDate = new Date(2001, 11, 26);}
        String job = req.getParameter("job");
        String PhoneNumber = req.getParameter("phoneNumber");
        UserDTO user = new UserDTO(userName ,creditLimit,job,birthDate,PhoneNumber);
        return user;
    }

}

