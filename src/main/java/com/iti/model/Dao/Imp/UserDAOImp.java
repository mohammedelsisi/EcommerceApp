package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTOM;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;

public class UserDAOImp implements UserDao {
    private static final UserDAOImp userDAOImp = new UserDAOImp();

    public static synchronized UserDAOImp getInstance() {
        return userDAOImp;
    }

    @Override
    public boolean insertUser(UserDTO u) {
        return true;
    }

    @Override
    public boolean isUserEmail(String email) {
        if (email.equals("true@true.com"))
            return true;
        else return false;
    }

    @Override
    public UserDTO getUser(String email, String password) {
        if (email.equals("true@true.com") && password.equals("123456")) {
            LocalDate localDate = LocalDate.of(1994, 11, 26);
            UserDTO userDTO = new UserDTO("ahmed", email, password);
            userDTO.setBirthday(java.sql.Date.valueOf(localDate));
            userDTO.setPhoneNumber("+201027579113");
            String add1 ="ss st";
            String add3 ="ss st";
            String add2 ="ss st";
            List<String> adds =new ArrayList<>();
            adds.add(add1);
            adds.add(add2);
            adds.add(add3);
            userDTO.setAddresses(adds);
            userDTO.setCreditLimit(12.0);
            CartItemDTOM cartItemDTOM = new CartItemDTOM();
            cartItemDTOM.setItemType("Shirt");
            cartItemDTOM.setItemPrice(1200);
            cartItemDTOM.setItemQuantity(2);
            CartItemDTOM cartItemDTOM2 = new CartItemDTOM();
            cartItemDTOM2.setItemType("Pants");
            cartItemDTOM2.setItemPrice(1500);
            cartItemDTOM2.setItemQuantity(2);
            Set<CartItemDTOM> items = new HashSet<>();
            items.add(cartItemDTOM);
            items.add(cartItemDTOM2);
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(123456L);
            orderDTO.setPurchaseDate(new Date());
            orderDTO.setItems(items);
            OrderDTO orderDTO2 = new OrderDTO();
            orderDTO2.setId(123456L);
            orderDTO2.setPurchaseDate(new Date());
            orderDTO2.setItems(items);
            ArrayList<OrderDTO> objects = new ArrayList<>();
            objects.add(orderDTO);
            objects.add(orderDTO2);
            userDTO.setOrders(objects);
            return userDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> retriveall() {
        return null;
    }


    @Override
    public boolean editName(String name) {
        UserDTO user = new UserDTO();
        user.setUserName(name);
        return true;
    }

    @Override
    public boolean changePassword(String oldpassword, String newpassword) {
        if (oldpassword.equals("hello")) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean editCreditLimit(Double credit) {
        UserDTO user = new UserDTO();
        user.setCreditLimit(credit);
        return true;
    }

    @Override
    public boolean editBirthDate(Date birthdate) {
        UserDTO user = new UserDTO();
        user.setBirthday(birthdate);
        return true;
    }

    @Override
    public boolean editJob(String job) {
        UserDTO user = new UserDTO();
        user.setJob(job);
        return true;
    }

    @Override
    public boolean addAddress(String address) {
        UserDTO user = new UserDTO();
        List<String> Addresses = new ArrayList<>();
        Addresses.add("221B Barker St.");
        user.setAddresses(Addresses);
        user.getAddresses().add(address);
        return true;
    }


    @Override
    public String selectAddress(int selectedAddress) {
        UserDTO user = new UserDTO();
        List<String> Addresses = new ArrayList<>();
        Addresses.add("221B Barker St.");
        user.setAddresses(Addresses);
        return user.getAddresses().get(selectedAddress);
    }

    @Override
    public boolean editImage(String image) {
        UserDTO user = new UserDTO();
        user.setImage(image);
        return true;
    }
}
