package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

import java.util.List;

public class RegistrationService {
    private final UserDao userDao= UserDAOImp.getInstance();
    private static final RegistrationService registrationService = new RegistrationService();

    public static synchronized RegistrationService getInstance(){
        return registrationService;
    }

    public boolean register (UserDTO userDTO){
        UserDetails userEntity = UserMapper.getInstance().getUserEntity(userDTO);
        return userDao.insertUser(userEntity);

    }
    public boolean isUserEmail (String email){
      return   userDao.isUserEmail(email);
    }
}
