package com.iti.controller.filters;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.utils.authentication.SavingUserService;
import com.iti.service.BuyingService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebFilter("/*")
public class rememberMeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(req.getSession().getAttribute("currentUser")==null){
            UserDTO userIfPresent = SavingUserService.getInstance().getUserIfPresent(req);
            if(userIfPresent!=null){
                req.getSession().setAttribute("login", true);
                req.getSession().setAttribute("currentUser",userIfPresent);
                List<CartItemDTO> list= (List<CartItemDTO>) req.getSession().getAttribute("Cart");
                BuyingService buyingService=(BuyingService)req.getServletContext().getAttribute("BuyingService");

                if(list.size()==0)
                {
                    list=buyingService.retrieveAllItems(userIfPresent.getId());
                    req.getSession().setAttribute("Cart",list);
                } else{
                    buyingService.removeCartItems(userIfPresent.getId());
                    buyingService.updateCart(userIfPresent.getId(),list);
                }
                if(!req.getServletPath().contains("/layout"))
                    SavingUserService.getInstance().extendLoggingTime(req,resp);
            }
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
