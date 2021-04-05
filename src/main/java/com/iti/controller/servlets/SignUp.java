package com.iti.controller.servlets;

import com.iti.model.DTO.UserDTO;
import com.iti.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO userDTO = fillUserData(req);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserDTO>> validate = validator.validate(userDTO);
        if(validate.size()==0){
        RegistrationService registrationService = (RegistrationService) req.getServletContext().getAttribute("RegistrationService");
        registrationService.register(userDTO);
        resp.sendRedirect("Login?email="+userDTO.getEmail());
        }else {
            resp.sendRedirect("404");
        }


    }


    private UserDTO fillUserData(HttpServletRequest req) {
        try {
        System.out.println(req.getParameterMap());
            String userName = req.getParameter("userName");
            double creditLimit = req.getParameter("creditLimit").equals("") ? 0:Double.parseDouble(req.getParameter("creditLimit"));
            String email = req.getParameter("email").toLowerCase();
            String password = req.getParameter("password");
            String phoneNumber = req.getParameter("phoneNumber");
            String job = req.getParameter("job");
            String birthDate = req.getParameter("birthDate");
            List<String> interests = new ArrayList<>();
            Collections.addAll(interests,req.getParameterValues("interests")==null?new String[0]:req.getParameterValues("interests"));
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
            return new UserDTO( userName, creditLimit, email, job, parsedDate, password, interests,phoneNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

