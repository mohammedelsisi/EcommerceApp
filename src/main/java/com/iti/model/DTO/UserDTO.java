package com.iti.model.DTO;

public class UserDTO {
    private String email;
    private String id;
    private String password;
    private String job;
//    private Date;


    public UserDTO(String email, String id, String password, String job) {
        this.email = email;
        this.id = id;
        this.password = password;
        this.job = job;
    }
}
