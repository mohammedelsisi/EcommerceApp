package com.iti.model.Dao.Imp;

import com.iti.model.DTO.OrderDTO;
import com.iti.model.Dao.OrderDao;
import com.iti.model.entity.OrderDetail;
import com.iti.model.entity.UserDetails;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
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
        Root<OrderDetail> orderRoot = orderQuery.from(OrderDetail.class);

//        Subquery sub = orderQuery.subquery(String.class);
//        Root<UserDetails> subqueryuser = sub.from(UserDetails.class);
//        sub.select(cb.equal(subqueryuser.get("email"), "%"+filter.getEmail()+"%"));



        Predicate predicate = cb.conjunction();

        if (filter.getId() > 0)
            predicate = cb.and(predicate,cb.equal(orderRoot.get("orderId"), filter.getId()));


            if (filter.getSelectedAddress().length() > 0)
                predicate = cb.and(predicate, cb.like(orderRoot.get("selectedAddress"), "%"+filter.getSelectedAddress()+"%"));

            if (filter.getEmail().length() > 0) {
                Subquery sub = orderQuery.subquery(String.class);
                Root<UserDetails> subqueryuser = sub.from(UserDetails.class);
                Subquery emailQurey = sub.select(subqueryuser).where(cb.like(subqueryuser.get("email"),"%"+filter.getEmail()+"%"));

                predicate = cb.and(predicate,cb.equal(emailQurey,orderRoot.get("userDetails")));
            }

            if (filter.getPurchaseDate() != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(filter.getPurchaseDate());
                c.add(Calendar.DATE, 1);
                Date dayafter = c.getTime();
                System.out.println(dayafter);
                predicate = cb.and(predicate, cb.between(orderRoot.get("purchaseDate"), filter.getPurchaseDate(), dayafter));
            }
            orderQuery.where(predicate);


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
