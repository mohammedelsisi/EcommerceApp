package com.iti.model.mapper;

import com.iti.model.DTO.UserDTO;
import com.iti.model.DTO.RoleUser;
import com.iti.model.entity.Address;
import com.iti.model.entity.Interest;
import com.iti.model.entity.UserDetails;

import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {
    private static UserMapper userMapper;
    private UserMapper(){

    }
    public static synchronized UserMapper getInstance(){
        return Objects.requireNonNullElseGet(userMapper,UserMapper::getInstance);
    }

    public UserDetails getEntity(UserDTO userDTO) {

    public UserDetails getUserEntity(UserDTO userDTO) {

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
        userDetails.setInterests(userDTO.getAddresses().stream().map(Interest::new).collect(Collectors.toSet()));
        return userDetails;
    }

    public UserDTO getDTO(UserDetails userDetails) {

    public UserDTO getUserDTO(UserDetails userDetails) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDetails.getId());
        userDTO.setBirthday(userDetails.getBirthday());
        userDTO.setCreditLimit(userDetails.getCreditLimit());
        userDTO.setEmail(userDetails.getEmail());
        userDTO.setImage(userDetails.getImage());
        userDTO.setJob(userDetails.getJob());
        userDTO.setPassword(userDetails.getPassword());
        userDTO.setPhoneNumber(userDetails.getPhoneNumber());
        userDTO.setRole(RoleUser.valueOf(userDetails.getRole()));
        userDTO.setUserName(userDetails.getUserName());
        userDTO.setInterests(userDetails.getInterests().stream().map(Interest::getInterest).collect(Collectors.toList()));
        userDTO.setAddresses(userDetails.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
//        userDTO.setOrders(userDetails.getOrderDetails().stream().map(OrderDetail::getAddress).collect(Collectors.toList()));
        return userDTO;

    }
}
