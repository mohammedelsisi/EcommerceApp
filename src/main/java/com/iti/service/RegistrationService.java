package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

import java.util.List;

public class RegistrationService {
    private static final RegistrationService registrationService = new RegistrationService();

    public static synchronized RegistrationService getInstance() {
        return registrationService;
    }

    public boolean register(UserDTO userDTO) {
        UserDao userDao = UserDAOImp.getInstance();
        System.out.println("###DTO"+userDTO);
        UserDetails userDetails = UserMapper.getInstance().getUserEntity(userDTO);
        System.out.println("###DETAILS"+userDetails);
        userDao.insertUser(userDetails);
        userDao.close();
        return true;
    }

    public boolean isUserEmail(String email) {
//      return   userDao.isUserEmail(email);
        return false;
    }
}
