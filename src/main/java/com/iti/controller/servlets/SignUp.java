package com.iti.controller.servlets;

import com.iti.model.DTO.UserDTO;
import com.iti.service.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/SignUP")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = new UserDTO(req.getParameter("email"), req.getParameter("id"), (req.getParameter("email")), req.getParameter("id"));
        req.getServletContext().getAttribute("register");
       boolean isValid= RegistrationService.register(userDTO);
//       req.getSession().setAttribute("login",true);
       if(isValid){
           req.getRequestDispatcher("Login.jsp");
       }else {

       }


       List<UserDTO>list =RegistrationService.getUsers();

//       resp.getWriter().print(  gson.parse(list));
    }
}

