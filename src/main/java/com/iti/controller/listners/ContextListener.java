package com.iti.controller.listners;

import com.iti.controller.servlets.Profile;
import com.iti.persistence.DatabaseManager;
import com.iti.service.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener.contextInitialized");
        RegistrationService registrationService = RegistrationService.getInstance();
        ProfileService profileService = ProfileService.getInstance();
        LoginService loginService = LoginService.getInstance();
        ProductsService productsService = ProductsService.getInstance();
        UsersService usersService = UsersService.getInstance();
        OrdersService ordersService = OrdersService.getInstance();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("RegistrationService",registrationService);
        servletContext.setAttribute("ProfileService",profileService);
        servletContext.setAttribute("LoginService",loginService);
        servletContext.setAttribute("ProductsService", productsService);
        servletContext.setAttribute("Colors",productsService.getColors());
        servletContext.setAttribute("Sizes",productsService.getSizes());
        servletContext.setAttribute("UsersService",usersService);
        servletContext.setAttribute("OrdersService",ordersService);
        servletContext.setAttribute("UserRoles",usersService.getRoles());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseManager.closeConnection();
        System.out.println("ContextListener.contextDestroyed");
    }
}
