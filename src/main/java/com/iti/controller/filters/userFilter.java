package com.iti.controller.filters;
import com.iti.model.DTO.UserDTO;
import com.iti.model.DTO.RoleUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter({"/Checkout","/AddressesJsp","/Orders","/Profile"})
public class userFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserDTO user = (UserDTO) httpRequest.getSession().getAttribute("currentUser");

        if (user != null && user.getRole() == RoleUser.CustomerRole) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("404");
        }
    }
}
