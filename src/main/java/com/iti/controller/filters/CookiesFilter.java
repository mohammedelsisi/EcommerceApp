package com.iti.controller.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "CookiesFilter", urlPatterns = "/*")
public class CookiesFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        Cookie[] cookies = httpServletRequest.getCookies();
        String url = httpServletRequest.getServletPath().substring(1);
        if (url.equals("Home") && request.getParameter("error") != null||url.contains("layout")) {
            chain.doFilter(request, response);
        } else {
            System.out.println(httpServletRequest.getServletPath());
            if (cookies == null) {
                //if cookies not open and not parameter
                if (request.getParameter("open") == null) {
                    Cookie c1 = new Cookie("Name", "Value");
                    c1.setMaxAge(60 * 60 * 24);

                    httpServletResponse.addCookie(c1);
                    httpServletResponse.sendRedirect(url + "?open");
                } else {
                    ((HttpServletResponse) response).sendRedirect("Home?error=-");
                }

            } else {
                chain.doFilter(request, response);
            }
        }
    }
}




