package com.iti.model.Dao.Imp;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;
import com.iti.model.RoleUser;

import java.util.ArrayList;
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
        List<UserDTO> dummyUsers= new ArrayList<>();
        dummyUsers.add(new UserDTO(20,"ahmed","layout/images/men.jpg",250,"a@ss.com","01007707317", RoleUser.Admin));
        dummyUsers.add(new UserDTO(21,"mohmed","layout/images/men.jpg",250,"mo@ss.com","01007707317", RoleUser.User));
        dummyUsers.add(new UserDTO(22,"Mahmoud","layout/images/men.jpg",250,"ma@ss.com","01007707317", RoleUser.Admin));
        dummyUsers.add(new UserDTO(22,"ali","layout/images/men.jpg",250,"al@ss.com","01007707317", RoleUser.User));
        return dummyUsers;
    }

    @Override
    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {
        return null;
    }

    @Override
    public List<RoleUser> getRoles() {
        List<RoleUser> rolesList = new ArrayList<>();
        rolesList.add(RoleUser.Admin);
        rolesList.add(RoleUser.User);
        return rolesList;
    }


}
