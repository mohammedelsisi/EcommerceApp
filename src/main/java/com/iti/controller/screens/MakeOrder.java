package com.iti.controller.screens;

import com.google.gson.Gson;
import com.iti.controller.servlets.Profile;
import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Product;
import com.iti.service.BuyingService;
import com.iti.service.ProfileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.*;
import java.io.IOException;

@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String selectedAddress = req.getParameter("address");
        UserDTO userDTO = (UserDTO) req.getSession().getAttribute("currentUser");
        List<CartItemDTO> items = (List<CartItemDTO>) req.getSession().getAttribute("Cart");
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setSelectedAddress(selectedAddress);
        Set<CartItemDTO> itemsSet = new HashSet<>();
        items.forEach((e) -> {
            itemsSet.add(e);
        });
        orderDTO.setItems(itemsSet);
        orderDTO.setPurchaseDate(new Date());
        PrintWriter writer = resp.getWriter();

        if (orderDTO.getTotalAmount() > userDTO.getCreditLimit()) {
            String sorry = "Sorry your credit limit is not enough to proceed in this order";
            resp.setStatus(215);
            writer.write(gson.toJson(sorry));
            writer.close();
            return;
        }
        Map<String, Long> map = new HashMap<>();
        ProductDao productDao = ProductDaoImp.getInstance();
        orderDTO.getItems().stream().forEach(e -> {
            long productID = e.getProductID();
            Product product = productDao.getProductById(productID);
            if (e.getItemQuantity() > product.getQuantity()) {
                map.put(product.getType() + "#" + product.getProductId(), product.getQuantity());
            }
        });
        productDao.close();
        if (map.size() > 0) {
            writer.write(gson.toJson(map));
            resp.setStatus(210);
            writer.close();
            return;
        }

        ProfileService profileService = (ProfileService) req.getServletContext().getAttribute("ProfileService");
        resp.setStatus(200);
        BuyingService.getInstance().makeOrder(userDTO, orderDTO);
        String success = "Your Order has been successfully placed";
        userDTO.getOrders().add(orderDTO);
        BuyingService.getInstance().removeCartItems(userDTO.getId());
        List<CartItemDTO> cart = new ArrayList<>();
        req.getSession().setAttribute("Cart", cart);
        userDTO.setCreditLimit(userDTO.getCreditLimit() - orderDTO.getTotalAmount());
        userDTO = profileService.editProfile(userDTO);
        req.getSession().setAttribute("currentUser", userDTO);
        writer.write(gson.toJson(success));

    }
}
