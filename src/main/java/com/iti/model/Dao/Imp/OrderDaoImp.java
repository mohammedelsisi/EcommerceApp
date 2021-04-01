package com.iti.model.Dao.Imp;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.Dao.OrderDao;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.UserDetails;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderDaoImp implements OrderDao {
    EntityManager entityManager;

    private OrderDaoImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static OrderDaoImp getInstance() {
        return new OrderDaoImp();
    }

    @Override
    public List<OrderDetail> retrieveFilteredOrders(OrderDTO filter) {
        System.out.println(filter);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderDetail> orderQuery = cb.createQuery(OrderDetail.class);
        CriteriaQuery<UserDetails> emailQuery = cb.createQuery(UserDetails.class);
        Root<OrderDetail> orderRoot = orderQuery.from(OrderDetail.class);
        Root<UserDetails> userRoot = emailQuery.from(UserDetails.class);

        if (filter.getId() > 0) {
            System.out.println("filtering");
            Predicate predicate = cb.equal(orderRoot.get("orderId"), filter.getId());


            if (filter.getSelectedAddress().length() > 0)
                predicate = cb.or(predicate, cb.equal(orderRoot.get("selectedAddress"), filter.getSelectedAddress()));

            if (filter.getEmail().length() > 0)
                predicate = cb.or(predicate, cb.equal(userRoot.get("email"), filter.getEmail()));

            if (filter.getPurchaseDate() != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(filter.getPurchaseDate());
                c.add(Calendar.DATE, 1);
                Date dayafter = c.getTime();
                System.out.println(dayafter);
                predicate = cb.or(predicate, cb.between(orderRoot.get("purchaseDate"), filter.getPurchaseDate(), dayafter));
            }
            orderQuery.where(predicate);
        }

        return entityManager.createQuery(orderQuery).getResultList();


    }

    @Override
    public OrderDetail retrieveOrderByID() {
        return null;
    }

    @Override
    public void close() {
        if (entityManager.isOpen())
            entityManager.close();
    }
}
