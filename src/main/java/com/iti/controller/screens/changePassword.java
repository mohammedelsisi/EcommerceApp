package com.iti.controller.screens;

import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.UserDetails;
import com.iti.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        UserDTO user = (UserDTO) req.getSession().getAttribute("currentUser");
        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
        PrintWriter writer = resp.getWriter();
        if(profileService.changePassword(user,currentPassword,newPassword)){
           user.setPassword(newPassword);
           writer.write("Password Changed Successfully");
        }else {
            writer.write("Sorry old password is not correct");
        }
        writer.close();
    }
}
