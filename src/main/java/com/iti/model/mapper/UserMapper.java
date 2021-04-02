package com.iti.model.mapper;

import com.iti.model.DTO.UserDTO;
import com.iti.model.DTO.RoleUser;
import com.iti.model.entity.Address;
import com.iti.model.entity.Interest;
import com.iti.model.entity.UserDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {
    private static final UserMapper userMapper = new UserMapper();

    private UserMapper() {

    }

    public static synchronized UserMapper getInstance() {
        return userMapper;
    }

    public UserDetails getUserEntity(UserDTO userDTO) {


        System.out.println("UserMapper.getUserEntity");

        UserDetails userDetails = new UserDetails();
        userDetails.setId(userDTO.getId());

        userDetails.setBirthday(userDTO.getBirthday());


        userDetails.setCreditLimit(userDTO.getCreditLimit());
        userDetails.setEmail(userDTO.getEmail());
        userDetails.setImage(userDTO.getImage());
        userDetails.setJob(userDTO.getJob());
        userDetails.setPassword(userDTO.getPassword());
        userDetails.setPhoneNumber(userDTO.getPhoneNumber());
        System.out.println("userDetails = " + userDetails);
        System.out.println("userDetails = " + userDetails.getPhoneNumber());
        userDetails.setRole(userDTO.getRole().name());
        userDetails.setUserName(userDTO.getUserName());
        System.out.println(userDTO);
        if (userDTO.getAddresses() != null)
            userDetails.setAddresses(userDTO.getAddresses().stream().map(Address::new).collect(Collectors.toSet()));
        if (userDTO.getInterests() != null)
            userDetails.setInterests(userDTO.getInterests().stream().map(Interest::new).collect(Collectors.toSet()));
        return userDetails;

    }

    public UserDTO getUserDTO(UserDetails userDetails) {


        UserDTO userDTO = new UserDTO();
        System.out.println("USer user" + userDetails);
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
        //userDTO.setOrders(userDetails.getOrderDetails().stream().map(OrderDetail::getAddress).collect(Collectors.toList()));
        return userDTO;

    }
}
