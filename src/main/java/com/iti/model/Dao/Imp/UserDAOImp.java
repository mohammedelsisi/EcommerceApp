package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTOM;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.Address;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;
import com.iti.persistence.DatabaseManager;
import com.iti.model.RoleUser;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDao {
    //    private static final UserDAOImp userDAOImp = new UserDAOImp();
    EntityManager entityManager;

    private UserDAOImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static UserDAOImp getInstance() {
        return new UserDAOImp();
    }

    public void close() {
        if (entityManager.isOpen()){
            System.out.println("Closing Entity Manger of user ");
            entityManager.close();

        }
    }

    @Override
    public boolean insertUser(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        userDetails.getInterests().stream().forEach((e) -> {
            e.setUserDetails(userDetails);
            entityManager.persist(e);
        });
        entityManager.getTransaction().commit();
        return true;
    }


    @Override
    public boolean isUserEmail(String userEmail) {
        List<String> resultList = entityManager.createQuery("select email from UserDetails where email = :userEmail", String.class).setParameter("userEmail",userEmail.toLowerCase()).getResultList();
        return resultList.size() > 0;
    }

    @Override
    public UserDetails getUser(String userEmail, String userPassword) {
        List<UserDetails> resultList = entityManager.createQuery("from UserDetails where email = :userEmail and password = :userPassword", UserDetails.class)
                                        .setParameter("userEmail", userEmail.toLowerCase())
                                        .setParameter("userPassword", userPassword)
                                        .getResultList();
        if (resultList.size() == 1) {
            System.out.println(resultList.get(0));
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> retriveall() {

        List<UserDTO> dummyUsers= new ArrayList<>();
        dummyUsers.add(new UserDTO(20,"ahmed","layout/images/men.jpg",250,"a@ss.com","01007707317", RoleUser.Admin));
        dummyUsers.add(new UserDTO(21,"mohmed","layout/images/men.jpg",250,"mo@ss.com","01007707317", RoleUser.User));
        dummyUsers.add(new UserDTO(22,"Mahmoud","layout/images/men.jpg",250,"ma@ss.com","01007707317", RoleUser.Admin));
        dummyUsers.add(new UserDTO(22,"ali","layout/images/men.jpg",250,"al@ss.com","01007707317", RoleUser.User));
        return dummyUsers;
    }

    @Override
    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {
        return null;
    }

//these methods are replaced with (Edit profile) method
/*    @Override
    public boolean editName(String name) {
        UserDTO user = new UserDTO();
        user.setUserName(name);
        return true;
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
    public String selectAddress(int selectedAddress) {
        UserDTO user = new UserDTO();
        List<String> Addresses = new ArrayList<>();
        Addresses.add("221B Barker St.");
        user.setAddresses(Addresses);
        return user.getAddresses().get(selectedAddress);
    }*/

    @Override
    public boolean changePassword(String oldpassword, String newpassword) {
        if (oldpassword.equals("hello")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAddress(String address) {
        //I need the id of the current user here
        int id = 0;
        Address newAddress = new Address();
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newAddress);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }


    @Override
    public boolean editImage(String image) {
        UserDTO user = new UserDTO();
        user.setImage(image);
        return true;
    }


    @Override
    public boolean EditProfile(UserDTO user) {
        //I need the id of the current user here
        int id = 0;
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update userDetails set  birthDay =" + user.getBirthday() +
                ", credit_limit= " + user.getCreditLimit() +
                " , phone_number= " + user.getPhoneNumber() +
                " , job= " + user.getJob() +
                " , user_name= " + user.getUserName() + " where id = " + id, UserDetails.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }

    @Override
    public List<RoleUser> getRoles() {
        List<RoleUser> rolesList = new ArrayList<>();
        rolesList.add(RoleUser.Admin);
        rolesList.add(RoleUser.User);
        return rolesList;
    }


}
