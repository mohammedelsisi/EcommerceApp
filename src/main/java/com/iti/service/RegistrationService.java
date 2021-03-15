package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;

import java.util.List;

public class RegistrationService {
    public static boolean register (UserDTO userDTO){
        UserDao userDao = new UserDAOImp();
       return userDao.insertUser(userDTO);

    }
    public static List<UserDTO> getUsers (){
        UserDao userDao = new UserDAOImp();
        return userDao.retriveall();
    }
}
