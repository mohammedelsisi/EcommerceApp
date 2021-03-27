package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

public class LoginService {
    private final UserDao userDao= UserDAOImp.getInstance();
    private static final LoginService loginService = new LoginService();

    public static synchronized LoginService getInstance(){
        return loginService;
    }


    public UserDTO getUser(String email,String password){
        UserDetails user = userDao.getUser(email, password);
        return UserMapper.getInstance().getUserDTO(user);
    }
}
