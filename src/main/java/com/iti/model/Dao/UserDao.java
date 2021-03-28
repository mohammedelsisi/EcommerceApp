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

   boolean changePassword(String oldpassword, String newpassword);

//   boolean editName(String name);
//
//   boolean editCreditLimit(Double credit);
//
//   boolean editBirthDate(Date birthdate);
//
//   boolean editJob(String job);
//
//   String selectAddress(int selectedAddress);

   boolean addAddress(String Address);

   boolean editImage (String image);

   boolean EditProfile (UserDTO user);

}