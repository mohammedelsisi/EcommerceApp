package com.iti.controller.listners;

import com.iti.service.DataTablesService;
//import com.iti.service.HomeService;
import com.iti.service.ProductsService;
import com.iti.service.LoginService;
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
        LoginService loginService = LoginService.getInstance();
//        HomeService homeService=HomeService.getInstance();
        DataTablesService dataTablesService = DataTablesService.getInstance();
        ProductsService productsService = ProductsService.getInstance();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("RegistrationService",registrationService);
        servletContext.setAttribute("LoginService",loginService);
//        servletContext.setAttribute("HomeService",homeService);
        servletContext.setAttribute("DataTablesService",dataTablesService);
        servletContext.setAttribute("ProductsService", productsService);
        servletContext.setAttribute("Colors",productsService.getColors());
        servletContext.setAttribute("Sizes",productsService.getSizes());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener.contextDestroyed");
    }
}
