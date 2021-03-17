package com.iti.service;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;

public class LoginService {
    private final UserDao userDao= UserDAOImp.getInstance();
    private static final LoginService loginService = new LoginService();

    public static synchronized LoginService getInstance(){
        return loginService;
    }


    public UserDTO getUser(String email,String password){
        return   userDao.getUser(email,password);
    }
}
