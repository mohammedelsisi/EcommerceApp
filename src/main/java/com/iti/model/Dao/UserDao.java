package com.iti.model.Dao;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import java.util.List;

public interface UserDao {
   boolean insertUser (UserDTO u);
   boolean isUserEmail(String email);
   UserDTO getUser(String email,String password);
   List<UserDTO> retriveall ();
}
