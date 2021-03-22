package com.iti.controller.filters;

import com.iti.model.DTO.UserDTO;
import com.iti.model.RoleUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserDTO user = (UserDTO) httpRequest.getSession().getAttribute("user");
        if (user != null && user.getRole() == RoleUser.Admin_Role) {
            filterChain.doFilter(request, response);
        } else {
            request.setAttribute("error", "YOU NOT ADMIN >> PLEASE LOGIN BY ADMIN TO SEE THIS PAGE:/");
            ((HttpServletResponse) response).sendRedirect("login");
        }
    }
}
