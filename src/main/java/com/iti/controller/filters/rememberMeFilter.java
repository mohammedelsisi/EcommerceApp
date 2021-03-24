package com.iti.controller.filters;

import com.iti.model.DTO.UserDTO;
import com.iti.model.utils.authentication.SavingUserService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/*")
public class rememberMeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        UserDTO userIfPresent = SavingUserService.getInstance().getUserIfPresent(req);
        if(userIfPresent!=null){
            req.getSession().setAttribute("login", true);
            req.getSession().setAttribute("currentUser",userIfPresent);
            if(!req.getServletPath().contains("/layout"))
                SavingUserService.getInstance().extendLoggingTime(req,resp);
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
