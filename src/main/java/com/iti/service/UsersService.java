package com.iti.service;


import com.iti.model.DTO.*;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;

import java.util.List;

public class UsersService {

    private static final UsersService USERS_SERVICE = new UsersService();
//    private final UserDao userDao = UserDAOImp.getInstance();

    public static synchronized UsersService getInstance() {
        return USERS_SERVICE;
    }

    public List<UserDTO> retrieveAllUsers() {
//        return userDao.retriveall();
        return null;
    }

    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {

        return null;
    }


    public List<RoleUser> getRoles() {

        return null;
    }

}
