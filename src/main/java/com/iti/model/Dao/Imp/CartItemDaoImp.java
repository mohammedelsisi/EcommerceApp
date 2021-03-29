package com.iti.model.Dao.Imp;

import com.iti.model.DTO.CartItemDTO;
import com.iti.model.Dao.CartItemDao;
import com.iti.model.entity.Cart;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.OrderHasProducts;
import com.iti.model.entity.OrderHasProductsId;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartItemDaoImp implements CartItemDao {
    EntityManager entityManager;
    CartItemDTO c1 = new CartItemDTO("shirt", 10.0, 2, "images/cloth_1.jpg", 1);
    CartItemDTO c2 = new CartItemDTO("shirt", 50.0, 1, "images/cloth_2.jpg", 2);

    private CartItemDaoImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }


    public static synchronized CartItemDaoImp getInstance() {
        return new CartItemDaoImp();
    }

    public void close() {
        if (entityManager.isOpen()) entityManager.close();
    }

    @Override
    public void makeOrder(OrderDetail orderDetail, Set<CartItemDTO> list) {
        entityManager.getTransaction().begin();
        entityManager.persist(orderDetail);
        list.forEach(e -> {
            OrderHasProductsId orderHasProductsId = new OrderHasProductsId();
            orderHasProductsId.setOrdersOrderId(orderDetail.getOrderId());
            orderHasProductsId.setProductsProductId(e.getProductID());
            OrderHasProducts orderHasProducts =  new OrderHasProducts();
            orderHasProducts.setId(orderHasProductsId);
            orderHasProducts.setQuantity((int)e.getItemQuantity());
            entityManager.persist(orderHasProducts);
        });
        entityManager.getTransaction().commit();
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
            entityManager.createQuery("delete from Cart where user_id=:id and product_id=:pId").setParameter("id", e.getId().getUserId())
                    .setParameter("pId", e.getId().getProductId()).executeUpdate();
        });
        entityManager.getTransaction().commit();

    }
}
