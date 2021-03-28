package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTOM;
import com.iti.model.DTO.OrderDTO;
import com.iti.model.DTO.UserDTO;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.Address;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.UserMapper;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;

public class UserDAOImp implements UserDao {
    private static final UserDAOImp userDAOImp = new UserDAOImp();

    public static synchronized UserDAOImp getInstance() {
        return userDAOImp;
    }

    @Override
    public boolean insertUser(UserDetails userDetails) {
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }

    @Override
    public boolean isUserEmail(String email) {
        if (email.equals("true@true.com"))
            return true;
        else return false;
    }

    @Override
    public UserDetails getUser(String email, String password) {
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<UserDetails> resultList = entityManager.createQuery("select from UserDetails where email=" + email + "and password= " + password, UserDetails.class).getResultList();
        return resultList.get(0);

//        if (email.equals("true@true.com") && password.equals("123456")) {
//            LocalDate localDate = LocalDate.of(1994, 11, 26);
//            UserDTO userDTO = new UserDTO("ahmed", email, password);
//            userDTO.setBirthday(java.sql.Date.valueOf(localDate));
//            userDTO.setPhoneNumber("+201027579113");
//            userDTO.setCreditLimit(12.0);
//            CartItemDTOM cartItemDTOM = new CartItemDTOM();
//            cartItemDTOM.setItemType("Shirt");
//            cartItemDTOM.setItemPrice(1200);
//            cartItemDTOM.setItemQuantity(2);
//            CartItemDTOM cartItemDTOM2 = new CartItemDTOM();
//            cartItemDTOM2.setItemType("Pants");
//            cartItemDTOM2.setItemPrice(1500);
//            cartItemDTOM2.setItemQuantity(2);
//            Set<CartItemDTOM> items = new HashSet<>();
//            items.add(cartItemDTOM);
//            items.add(cartItemDTOM2);
//            OrderDTO orderDTO = new OrderDTO();
//            orderDTO.setId(123456L);
//            orderDTO.setPurchaseDate(new Date());
//            orderDTO.setItems(items);
//            OrderDTO orderDTO2 = new OrderDTO();
//            orderDTO2.setId(123456L);
//            orderDTO2.setPurchaseDate(new Date());
//            orderDTO2.setItems(items);
//            ArrayList<OrderDTO> objects = new ArrayList<>();
//            objects.add(orderDTO);
//            objects.add(orderDTO2);
//            userDTO.setOrders(objects);
//            return userDTO;
//        } else {
//            return null;
//        }
    }

    @Override
    public List<UserDTO> retriveall() {
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
                " , user_name= " + user.getUserName()+ " where id = " + id  ,UserDetails.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }
}
