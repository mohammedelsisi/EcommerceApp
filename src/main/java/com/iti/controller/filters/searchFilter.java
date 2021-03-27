package com.iti.controller.filters;

import com.iti.model.DTO.ProductFilter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/*"})
public class searchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String servletPath = httpServletRequest.getServletPath();
        Object filters = httpServletRequest.getSession().getAttribute("Filters");
        if(filters==null||(!servletPath.contains("Shop"))&&!servletPath.contains("layout")) {
            ProductFilter emptyFilter = ProductFilter.getEmptyFilter();
            httpServletRequest.getSession().setAttribute("Filters", emptyFilter);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
