package com.iti.service;

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

    public boolean changePassword(UserDTO user, String oldpassword, String newpassword) {
        if (user.getPassword().equals(oldpassword)) {
            user.setPassword(newpassword);
            return true;
        } else {
            return false;
        }
    }


    public boolean addAddress(UserDTO user, String address) {
        user.getAddresses().add(address);
        return true;
    }


    public String selectAddress(UserDTO user, int selectedAddress) {
        return user.getAddresses().get(selectedAddress);
    }
}
