package com.iti.model.Dao;

import com.iti.model.DTO.UserDTO;
import java.util.List;

public interface UserDao {
   boolean insertUser (UserDTO u);
   List<UserDTO> retriveall ();
}
