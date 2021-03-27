package com.iti.model.Dao;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.UserDetails;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface UserDao {
   boolean insertUser(UserDetails u);

   boolean isUserEmail(String email);

   UserDetails getUser(String email, String password);

   List<UserDTO> retriveall();

   boolean editName(String name);

   boolean changePassword(String oldpassword, String newpassword);

   boolean editCreditLimit(Double credit);

   boolean editBirthDate(Date birthdate);

   boolean editJob(String job);

   boolean addAddress(String Address);

   String selectAddress(int selectedAddress);

   boolean editImage (String image);

}