package com.iti.controller.screens;

import com.iti.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckEmail")
public class UserEmail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        RegistrationService registrationService = (RegistrationService) req.getServletContext().getAttribute("RegistrationService");
        PrintWriter writer = resp.getWriter();
        if(registrationService.isUserEmail(email)){
            writer.write("Not-Valid");
        }else {
            writer.write("Valid");
        }
        writer.flush();
        writer.close();
    }
}
