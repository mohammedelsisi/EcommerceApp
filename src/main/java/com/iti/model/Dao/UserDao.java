package com.iti.model.Dao;


import com.iti.model.DTO.*;


import com.iti.model.entity.UserDetails;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface UserDao {
   boolean insertUser(UserDetails u);

   boolean isUserEmail(String email);
   List<UserDTO> retriveall();
   List<UserDetails> retrieveFilteredUsers(UserDetails userFilter);
   List<String> getRoles();

   UserDetails getUser(String userEmail, String userPassword);
   void close();



   boolean changePassword(String oldpassword, String newpassword);

   boolean editImage (String image);

   boolean EditProfile (UserDTO user);

   boolean updateUserRole(UserDetails userToUpdate);
}