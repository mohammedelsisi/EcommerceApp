package com.iti.model.Dao.Imp;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;

import java.util.List;

public class UserDAOImp implements UserDao {
    @Override
    public boolean insertUser(UserDTO u) {
        return true;
    }

    @Override
    public List<UserDTO> retriveall() {
        return null;
    }
}
