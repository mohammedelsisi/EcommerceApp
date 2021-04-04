package com.iti.service;


import com.iti.model.DTO.RoleUser;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class UsersService {

    private static final UsersService USERS_SERVICE = new UsersService();

    public static synchronized UsersService getInstance() {
        return USERS_SERVICE;
    }

    public List<UserDTO> retrieveAllUsers() {

        return null;
    }

    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {
        UserDao userDao = UserDAOImp.getInstance();
        UserDetails filteringUser = UserMapper.getInstance().getUserEntity(userFilter);
        List<UserDetails> users = userDao.retrieveFilteredUsers(filteringUser);
        List<UserDTO> list = new ArrayList<>();
        users.forEach(e->{
            list.add(UserMapper.getInstance().getUserDTO(e));
        });
        userDao.close();
        return list;
    }


    public List<String> getRoles() {
        UserDao userDao = UserDAOImp.getInstance();
        userDao.close();
        return userDao.getRoles();
    }

    public void updatedUserRole(UserDTO updatingUser) {
        UserDao userDao = UserDAOImp.getInstance();
        UserDetails userToUpdate = UserMapper.getInstance().getUserEntity(updatingUser);

        boolean status = userDao.updateUserRole(userToUpdate);
        userDao.close();
        System.out.println(status);

    }
}
