package com.iti.controller.filters;
import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.DTO.RoleUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebFilter({"/Checkout","/Address","/Orders","/Profile"})
public class userFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserDTO user = (UserDTO) httpRequest.getSession().getAttribute("currentUser");
        List<CartItemDTO> items = (List<CartItemDTO>) httpRequest.getSession().getAttribute("Cart");

        if (user != null && user.getRole() == RoleUser.CustomerRole) {
            if(httpRequest.getServletPath().contains("Checkout") && items.size()==0)
                ((HttpServletResponse) response).sendRedirect("Cart");
            else
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("404");
        }
    }
}
