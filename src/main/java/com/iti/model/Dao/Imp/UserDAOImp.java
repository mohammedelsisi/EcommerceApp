package com.iti.model.Dao.Imp;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;

import java.util.List;

public class UserDAOImp implements UserDao {
    private static final UserDAOImp userDAOImp = new UserDAOImp();

    public static synchronized UserDAOImp getInstance() {
        return userDAOImp;
    }

    @Override
    public boolean insertUser(UserDTO u) {
        return true;
    }

    @Override
    public boolean isUserEmail(String email) {
        if(email.equals("true@true.com"))
            return true;
        else return false;
    }

    @Override
    public UserDTO getUser(String email, String password) {
       if(email.equals("true@true.com") && password.equals("123456")){
           return new UserDTO("ahmed",email,password);
       }else {
           return null;
       }
    }

    @Override
    public List<UserDTO> retriveall() {
        return null;
    }
}
