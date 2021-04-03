package com.iti.service;

import com.iti.controller.screens.Addresses;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

import java.util.Date;
import java.util.List;

public class ProfileService {

    private static final ProfileService profileService = new ProfileService();

    public static synchronized ProfileService getInstance() {
        return profileService;
    }

    public UserDTO editProfile(UserDTO user) {
        UserDao userDao = UserDAOImp.getInstance();
        UserDetails userEntity = UserMapper.getInstance().getUserEntity(user);
        UserDetails userDetails = userDao.EditProfile(userEntity);
        UserDTO userDTO = UserMapper.getInstance().getUserDTO(userDetails);
        userDao.close();
        return userDTO;
    }

    public boolean changePassword(UserDTO user, String oldpassword, String newpassword) {
        UserDao userDao = UserDAOImp.getInstance();
        UserDetails userEntity = UserMapper.getInstance().getUserEntity(user);
        boolean b = userDao.changePassword(userEntity, oldpassword, newpassword);
        userDao.close();
        return b;

    }


}
