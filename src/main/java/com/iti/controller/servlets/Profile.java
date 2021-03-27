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
        //TODO We can't have a list of raw type to represent the user  + we don't need the image here
//        List Data = fillUserData(req);
//        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
//        profileService.editProfile( (String) Data.get(1),(double) Data.get(2),(Date) Data.get(3),(String) Data.get(4), (String) Data.get(5) );
        // TODO data receive here now we need to use it.

        String userName = req.getParameter("userName");
        double creditLimit = parseDouble(req.getParameter("creditLimit"));
        String birthDate = req.getParameter("birthDate");
        String job = req.getParameter("job");
        System.out.println(userName);
        System.out.println(creditLimit);
        System.out.println(birthDate);
        System.out.println(job);
    }


    private List fillUserData(HttpServletRequest req) {

        //System.out.println(req.getParameterMap());
        String userName = req.getParameter("userName");
        double creditLimit = parseDouble(req.getParameter("creditLimit"));
        String birthDate = req.getParameter("birthDate");
        String job = req.getParameter("job");
        String image = req.getParameter("image");
        List<Object> Data = new ArrayList<>();
        Data.add(userName);
        Data.add(creditLimit);
        Data.add(job);
        Data.add(birthDate);
        Data.add(image);
        return Data;
    }

}

