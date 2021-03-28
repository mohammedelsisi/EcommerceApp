package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

public class LoginService {
    private static final LoginService loginService = new LoginService();

    public static synchronized LoginService getInstance() {
        return loginService;
    }


    public UserDTO getUser(String email, String password) {
        UserDao userDao = UserDAOImp.getInstance();
        UserDetails user = userDao.getUser(email, password);
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = UserMapper.getInstance().getUserDTO(user);
        }
        userDao.close();
        return userDTO;
    }
}
