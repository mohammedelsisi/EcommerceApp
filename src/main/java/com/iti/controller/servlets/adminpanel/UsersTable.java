package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.*;
import com.iti.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/UsersServlet")
public class UsersTable extends HttpServlet {

    Gson json = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersService usersService =(UsersService) request.getServletContext().getAttribute("UsersService");
        List<String> roles =(List<String>) request.getServletContext().getAttribute("UserRoles");


        String action= request.getParameter("action");

        switch (action)
        {
            case "load" : {
                //TODO : make method get products filtered
                UserDTO filter = getUserFromRequest(request);
                List<UserDTO> users =usersService.retrieveFilteredUsers(filter);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String usersJson= json.toJson(users);
                response.getWriter().write(usersJson);
                break;
            }
            case "update":{
                UserDTO updatingUser = getUserFromRequest(request);
                usersService.updatedUserRole(updatingUser);
                break;
            }
            case "getRoles" :{
                List<String> userRoles = usersService.getRoles();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String rolesJson= json.toJson(userRoles);
                response.getWriter().write(rolesJson);
                break;
            }

        }


    }



    private UserDTO getUserFromRequest(HttpServletRequest request){
        UserDTO filter = new UserDTO();

        if (request.getParameter("id") != null)
            filter.setId(Long.parseLong(request.getParameter("id")));
        
        if (request.getParameter("creditLimit") != null)
            filter.setCreditLimit(Double.parseDouble(request.getParameter("creditLimit")));
        
        filter.setUserName(request.getParameter("userName"));

        filter.setPhoneNumber(request.getParameter("phoneNumber"));
        filter.setEmail(request.getParameter("email"));
        if(request.getParameter("Role").equals("Admin_Role"))
            filter.setRole(RoleUser.Admin_Role);
        else if(request.getParameter("Role").equals("CustomerRole"))
            filter.setRole(RoleUser.CustomerRole);

        return filter;


    }
}
