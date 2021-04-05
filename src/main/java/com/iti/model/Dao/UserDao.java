package com.iti.model.Dao;


import com.iti.model.DTO.*;


import com.iti.model.entity.UserDetails;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface UserDao {
   boolean insertUser(UserDetails u);

   boolean isUserEmail(String email);
   List<UserDetails> retrieveFilteredUsers(UserDetails userFilter);
   List<String> getRoles();

   UserDetails getUser(String userEmail, String userPassword);
   void close();



   boolean changePassword(UserDetails user, String oldpassword, String newpassword);



   UserDetails EditProfile(UserDetails user);

   boolean updateUserRole(UserDetails userToUpdate);
}