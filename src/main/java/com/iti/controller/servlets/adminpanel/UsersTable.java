package com.iti.controller.servlets.adminpanel;

import com.google.gson.Gson;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.RoleUser;
import com.iti.service.ProductsService;
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
                //ProductDTO filter = getFilter(request);
                //List<ProductDTO>  filteredProducts =dataTablesService.retriveAllProducts(filter);
                List<UserDTO> users =usersService.retrieveAllUsers();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String usersJson= json.toJson(users);
                response.getWriter().write(usersJson);
                break;
            }
            case "update":{
//                System.out.println(request.getParameter("prodID"));
//                ProductDTO productToInset = getProductFromRequest(request);
//                System.out.println(productToInset);
                break;
            }
            case "getRoles" :{
                List<RoleUser> userRoles = usersService.getRoles();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String rolesJson= json.toJson(userRoles);
                response.getWriter().write(rolesJson);
                break;
            }

            case "delete":{
//                System.out.println(request.getParameter("prodID"));
//                ProductDTO productToInset = getProductFromRequest(request);
//                System.out.println(productToInset);
                break;
            }
        }


    }



    private ProductDTO getProductFromRequest(HttpServletRequest request){

        return null;
    }
}
