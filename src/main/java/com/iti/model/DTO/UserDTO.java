package com.iti.model.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO {
    Set<CartItemDTO> cartItem = new HashSet<>();
    private String dateView;
    private long id;

    private String userName;

    private String phoneNumber;
    private String email;
    private double creditLimit;
    private String image = "layout/images/img_avatar.png";
    private RoleUser Role = RoleUser.CustomerRole;
    private String job;
    private Date birthday;
    private String password;
    private List<String> interests;
    private List<String> addresses;
    private List<OrderDTO> orders;
    public UserDTO(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public UserDTO(String userName, double creditLimit, String email, String job, Date birthday, String password, List<String> interests, String phoneNumber) {
        this.userName = userName;
        this.creditLimit = creditLimit;
        this.email = email;
        this.job = job;
        this.birthday = birthday;
        this.password = password;
        this.interests = interests;
        this.phoneNumber = phoneNumber;
    }

    //this is used in create user for edit profile
    public UserDTO(String userName, double creditLimit, String job, Date birthday, String phoneNumber) {
        this.userName = userName;
        this.creditLimit = creditLimit;
        this.job = job;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public UserDTO() {
    }

    public String getDateView() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(birthday);
    }

    public void setDateView(String dateView) {
        this.dateView = dateView;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @NotNull
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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", creditLimit=" + creditLimit +
                ", image='" + image + '\'' +
                ", Role=" + Role +
                ", job='" + job + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", interests=" + interests +
                ", addresses=" + addresses +
                ", orders=" + orders +
                ", cartItem=" + cartItem +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @NotBlank
    @Size(min = 3)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Positive
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    @Email
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
    @Past
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
    }
    @NotBlank
    @Size(min = 6)
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
    @NotNull
    public RoleUser getRole() {
        return Role;
    }

    public void setRole(RoleUser role) {
        Role = role;
    }

    public List<String> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<CartItemDTO> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItemDTO> cartItem) {
        this.cartItem = cartItem;
    }
}
