package com.iti.model.DTO;

import com.iti.model.RoleUser;

import java.util.Date;
import java.util.List;

public class UserDTO {
    private long id;
    private String userName;
    private double creditLimit;
    private String email;
    private String job;
    private Date birthday;
    private String password;
    private List<String> interests;
    private RoleUser Role;
    private List<String> addresses;
    private String image;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", creditLimit=" + creditLimit +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", interests=" + interests +
                ", addresses=" + addresses +
                '}';
    }

    public UserDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


    public UserDTO( String userName, double creditLimit, String email, String job, Date birthday, String password, List<String> interests,String phoneNumber) {
        this.userName = userName;
        this.creditLimit = creditLimit;
        this.email = email;
        this.job = job;
        this.birthday = birthday;
        this.password = password;
        this.interests = interests;
        this.phoneNumber=phoneNumber;
    }

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public RoleUser getRole() {
        return Role;
    }

    public void setRole(RoleUser role) {
        Role = role;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<String> getAddresses() {
        return this.addresses;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}
