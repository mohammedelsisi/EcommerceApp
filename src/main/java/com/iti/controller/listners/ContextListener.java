package com.iti.controller.listners;

import com.iti.controller.servlets.Profile;
import com.iti.persistence.DatabaseManager;
import com.iti.service.ProductsService;
import com.iti.service.LoginService;
import com.iti.service.ProfileService;
import com.iti.service.RegistrationService;
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
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("RegistrationService",registrationService);
        servletContext.setAttribute("ProfileService",profileService);
        servletContext.setAttribute("LoginService",loginService);
        servletContext.setAttribute("ProductsService", productsService);
        servletContext.setAttribute("Colors",productsService.getColors());
        servletContext.setAttribute("Sizes",productsService.getSizes());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseManager.closeConnection();
        System.out.println("ContextListener.contextDestroyed");
    }
}
