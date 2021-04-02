package com.iti.controller.filters;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.DTO.UserDTO;
import com.iti.service.BuyingService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.*;

import java.io.IOException;
import java.util.ArrayList;

@WebFilter("/*")
public class searchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String servletPath = httpServletRequest.getServletPath();
        HttpSession session = httpServletRequest.getSession();
        List<CartItemDTO> cart=null;
        Object filters = session.getAttribute("Filters");
        if (session.getAttribute("Cart") == null) {
            cart = new ArrayList<>();
            session.setAttribute("Cart", cart);
        }
        UserDTO userDTO = (UserDTO) session.getAttribute("currentUser");

        if(userDTO!=null) {
            BuyingService buyingService=(BuyingService)request.getServletContext().getAttribute("BuyingService");
            cart=buyingService.retrieveAllItems(userDTO.getId());
        }
        else {

        }
        if (filters == null || (!servletPath.contains("Shop")) && !servletPath.contains("layout")) {
            ProductFilter emptyFilter = ProductFilter.getEmptyFilter();
            httpServletRequest.getSession().setAttribute("Filters", emptyFilter);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
