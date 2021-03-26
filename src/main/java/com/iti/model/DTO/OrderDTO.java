package com.iti.model.DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class OrderDTO {
    private long id;
    private String email;
    private String selectedAddress;
    private Date purchaseDate;
    private double totalAmount;
    Set<CartItemDTO> cart;


}
