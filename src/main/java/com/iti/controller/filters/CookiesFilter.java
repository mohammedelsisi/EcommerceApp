package com.iti.controller.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CookiesFilter", urlPatterns = "/*")
public class CookiesFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies =((HttpServletRequest) request).getCookies();
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        if (cookies == null) {
            //if cookies not open and not parameter
            if (request.getParameter("open") == null) {
                Cookie c1 = new Cookie("Name", "Value");
                c1.setMaxAge(60*60*24);
                ((HttpServletResponse) response).addCookie(c1);
                ((HttpServletResponse) response).sendRedirect(url + "?open=parameter");
            }
            else {
                System.out.println("cookies are Disabled");
                ((HttpServletResponse) response).sendRedirect("404.jsp");
            }

        } else {
            System.out.println("cookies are Enabled");
            chain.doFilter(request, response);
        }
    }
}




