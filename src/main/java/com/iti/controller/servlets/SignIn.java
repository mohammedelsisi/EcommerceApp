package com.iti.controller.servlets;

import com.iti.model.DTO.UserDTO;
import com.iti.model.utils.authentication.SavingUserService;
import com.iti.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("userEmail");
        String password = req.getParameter("userPassword");
        LoginService loginService = (LoginService) req.getServletContext().getAttribute("LoginService");
        UserDTO userDTO = loginService.getUser(email,password);
        if(userDTO==null){
            resp.sendRedirect("Login?invalid=-");
        }else {
            req.getSession().setAttribute("login", true);
            req.getSession().setAttribute("currentUser",userDTO);
            String rememberMe = req.getParameter("rememberMe");
            if(rememberMe!=null){
                SavingUserService.getInstance().saveUserCredentials(req,resp);
            }
            resp.sendRedirect("Home");
        }

    }
}
