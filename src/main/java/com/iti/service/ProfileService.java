package com.iti.service;

import com.iti.controller.servlets.Addresses;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.Imp.UserDAOImp;
import com.iti.model.Dao.UserDao;

import java.util.Date;
import java.util.List;

public class ProfileService {
    private final UserDao userDao = UserDAOImp.getInstance();
    private static final ProfileService profileService = new ProfileService();
    public static synchronized ProfileService getInstance() {
        return profileService;
    }

    public boolean editProfile(String name, Double credit, Date birthdate, String job, String image) {
        return
                userDao.editName(name)
                        & userDao.editCreditLimit(credit)
                        & userDao.editBirthDate(birthdate)
                        & userDao.editJob(job)
                        & userDao.editImage(image);

    }

   public boolean changePassword(String oldpassword, String newpassword){
        return userDao.changePassword( oldpassword, newpassword);
    }

    public boolean addAddress (String address) {
        return userDao.addAddress(address) ;
    }

//todo: this function is now in the "checkout process"
    /*public String selectAddress( int selectedAddress) {

        return userDao.selectAddress(selectedAddress);
    }*/

}
