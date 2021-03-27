package com.iti.model.mapper;

import com.iti.model.DTO.UserDTO;
import com.iti.model.entity.UserDetails;

import java.util.Objects;

public class UserMapper {
    private static UserMapper userMapper;
    private UserMapper(){

    }
    public static synchronized UserMapper getInstance(){
        return Objects.requireNonNullElseGet(userMapper,UserMapper::getInstance);
    }
    public UserDetails getEntity(UserDTO userDTO){
        UserDetails userDetails = new UserDetails();

        userDetails.setId(userDTO.getId());
        userDetails.setBirthday(userDTO.getBirthday());
        userDetails.setCreditLimit(userDTO.getCreditLimit());
        userDetails.setEmail(userDTO.getEmail());
        userDetails.setImage(userDTO.getImage());
        userDetails.setJob(userDTO.getJob());
        userDetails.setPassword(userDTO.getPassword());
        userDetails.setPhoneNumber(userDTO.getPhoneNumber());
        userDetails.setRole(userDTO.getRole().name());
        userDetails.setUserName(userDTO.getUserName());
        return userDetails;
    }
    public UserDTO getDTO (UserDetails userDetails){

    }
}
