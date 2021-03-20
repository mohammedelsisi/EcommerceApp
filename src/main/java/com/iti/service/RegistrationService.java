package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;

import java.util.List;

public class RegistrationService {
    private final UserDao userDao= UserDAOImp.getInstance();
    private static final RegistrationService registrationService = new RegistrationService();

    public static synchronized RegistrationService getInstance(){
        return registrationService;
    }

    public boolean register (UserDTO userDTO){
       return userDao.insertUser(userDTO);
    }
    public boolean isUserEmail (String email){
      return   userDao.isUserEmail(email);
    }
}
