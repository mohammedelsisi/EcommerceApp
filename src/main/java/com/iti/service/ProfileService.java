package com.iti.service;

import com.iti.controller.screens.Addresses;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.UserDetails;

import java.util.Date;
import java.util.List;

public class ProfileService {
//    private final UserDao userDao = UserDAOImp.getInstance();
    private static final ProfileService profileService = new ProfileService();
    public static synchronized ProfileService getInstance() {
        return profileService;
    }

    public boolean editProfile(UserDTO user) {
//     return userDao.EditProfile(user);
        return false;
    }

   public boolean changePassword(String oldpassword, String newpassword){
//        return userDao.changePassword( oldpassword, newpassword);
       return false;
    }

    public boolean addAddress (String address) {
//        return userDao.addAddress(address) ;return false;
        return false;

    }

//Todo: this must be in the checkout
  /*  public String selectAddress( int selectedAddress) {

        return userDao.selectAddress(selectedAddress);
    }*/

}
