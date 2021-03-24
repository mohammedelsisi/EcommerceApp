package com.iti.model.Dao.Imp;

import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        if (email.equals("true@true.com"))
            return true;
        else return false;
    }

    @Override
    public UserDTO getUser(String email, String password) {
        if (email.equals("true@true.com") && password.equals("123456")) {
            LocalDate localDate = LocalDate.of(1994,11,26);
            UserDTO userDTO = new UserDTO("ahmed", email, password);
            userDTO.setBirthday(java.sql.Date.valueOf(localDate));
            userDTO.setCreditLimit(12.0);
            return userDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> retriveall() {
        return null;
    }


    @Override
    public boolean editName(String name) {
        UserDTO user = new UserDTO();
        user.setUserName(name);
        return true;
    }

    @Override
    public boolean changePassword(String oldpassword, String newpassword) {
        UserDTO user = new UserDTO();
        if (user.getPassword().equals(oldpassword)) {
            user.setPassword(newpassword);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editCreditLimit(Double credit) {
        UserDTO user = new UserDTO();
        user.setCreditLimit(credit);
        return true;
    }

    @Override
    public boolean editBirthDate(Date birthdate) {
        UserDTO user = new UserDTO();
        user.setBirthday(birthdate);
        return true;
    }

    @Override
    public boolean editJob(String job) {
        UserDTO user = new UserDTO();
        user.setJob(job);
        return true;
    }

    @Override
    public boolean addAddress(String address) {
        UserDTO user = new UserDTO();
        List<String> Addresses = new ArrayList<>();
        Addresses.add("221B Barker St.");
        user.setAddresses(Addresses);
        user.getAddresses().add(address);
        return true;
    }


    @Override
    public String selectAddress(int selectedAddress) {
        UserDTO user = new UserDTO();
        List<String> Addresses = new ArrayList<>();
        Addresses.add("221B Barker St.");
        user.setAddresses(Addresses);
        return user.getAddresses().get(selectedAddress);
    }

    @Override
    public boolean editImage (String image){
        UserDTO user = new UserDTO();
        user.setImage(image);
        return true;
    }
}
