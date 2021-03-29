package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.CartItemDao;
import com.iti.model.entity.Cart;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImp implements CartItemDao {
    EntityManager entityManager;
    CartItemDTO c1 = new CartItemDTO("shirt", 10.0, 2, "images/cloth_1.jpg", 1);
    CartItemDTO c2 = new CartItemDTO("shirt", 50.0, 1, "images/cloth_2.jpg", 2);

    public CartItemDaoImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static synchronized CartItemDaoImp getInstance() {
        return new CartItemDaoImp();
    }

    public void close() {
        if (entityManager.isOpen()) entityManager.close();
    }

    @Override
    public List<Cart> retrieveAllItems(long userID) {
        return entityManager.createQuery("From Cart where id=:user", Cart.class).setParameter("user", userID).getResultList();
    }

    @Override
    public void updateCart(List<Cart> list) {
        entityManager.getTransaction().begin();
        list.stream().forEach((e) -> {
            entityManager.merge(e);
        });
        entityManager.getTransaction().commit();


    }

    @Override
    public void removeCartItems(List<Cart> list) {
        entityManager.getTransaction().begin();
        System.out.println(list);
        System.out.println("list = " + list);
        System.out.println("CartItemDaoImp.removeCartItems");

        list.stream().forEach((e) -> {
         entityManager.createQuery("delete from Cart where user_id=:id and product_id=:pId").setParameter("id",e.getId().getUserId())
                 .setParameter("pId",e.getId().getProductId()).executeUpdate();
        });
        entityManager.getTransaction().commit();

    }
}
