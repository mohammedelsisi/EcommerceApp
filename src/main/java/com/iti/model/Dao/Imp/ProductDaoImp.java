package com.iti.model.Dao.Imp;

import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Product;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    EntityManager entityManager;

    private ProductDaoImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static ProductDaoImp getInstance() {
        return new ProductDaoImp();
    }

    @Override
    public List<Product> reteriveMaxProducts() {
        return entityManager.createQuery("from Product order by quantity desc ", Product.class).setMaxResults(4).getResultList();

    }

    @Override
    public List<Product> retrieveFilteredProducts(ProductFilter productFilter) {
//        if (productFilter.isEmpty()) {
//            return retrieveAllProducts();
//        } else {
//
//            List<Product> products = new ArrayList<>();
//
//            return null;
//        }
        return null;
    }


    @Override
    public List<Product> retrieveProductswithFilter(Product filteredProduct) {
        System.out.println(filteredProduct);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> itemRoot = criteriaQuery.from(Product.class);

        if (filteredProduct.getProductId() > 0) {

            Predicate predicate = criteriaBuilder.equal(itemRoot.get("productId"), filteredProduct.getProductId());

            if (filteredProduct.getCategory().length() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("category"), filteredProduct.getCategory()));
            if (filteredProduct.getColor().length() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("color"), filteredProduct.getColor()));
            if (filteredProduct.getQuantity() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("quantity"), filteredProduct.getQuantity()));
//            if (filteredProduct.getDescription().length()>0)
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(itemRoot.get("description"), filteredProduct.getDescription()));
//            if (filteredProduct.getFirstImg().length()>0)
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(itemRoot.get("firstImg"), filteredProduct.getFirstImg()));
            if (filteredProduct.getPrice() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("price"), filteredProduct.getPrice()));
//            if (filteredProduct.getSecondImg().length()>0)
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(itemRoot.get("secondImg"), filteredProduct.getSecondImg()));
            if (filteredProduct.getSize().length() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("size"), filteredProduct.getSize()));
            if (filteredProduct.getType().length() > 0)
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(itemRoot.get("type"), filteredProduct.getType()));

            criteriaQuery.where(predicate);
        }

        List<Product> products = entityManager.createQuery(criteriaQuery).getResultList();

        return products;
    }

    @Override
    public Boolean updateProduct(Product updatingProduct) {
        try {
            entityManager.getTransaction().begin();
            Product prodToUpdate = entityManager.find(Product.class, updatingProduct.getProductId());
            prodToUpdate.setType(updatingProduct.getType());
            prodToUpdate.setColor(updatingProduct.getColor());
            prodToUpdate.setCategory(updatingProduct.getCategory());
            prodToUpdate.setPrice(updatingProduct.getPrice());
            prodToUpdate.setQuantity(updatingProduct.getQuantity());
            prodToUpdate.setFirstImg(updatingProduct.getFirstImg());
            prodToUpdate.setSecondImg(updatingProduct.getSecondImg());
            prodToUpdate.setSize(updatingProduct.getSize());
            //TODO discuss description with Cici
            prodToUpdate.setDescription(prodToUpdate.getDescription());
            entityManager.merge(prodToUpdate);
            entityManager.getTransaction().commit();
            return true;
            //TODO check exception type
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            return false;
        }


    }

    @Override
    public Boolean insertProduct(Product insertingProduct) {
        try {
            entityManager.getTransaction().begin();
            Product prodToInsert = new Product();
            prodToInsert.setType(insertingProduct.getType());
            prodToInsert.setColor(insertingProduct.getColor());
            prodToInsert.setCategory(insertingProduct.getCategory());
            prodToInsert.setPrice(insertingProduct.getPrice());
            prodToInsert.setQuantity(insertingProduct.getQuantity());
            prodToInsert.setFirstImg(insertingProduct.getFirstImg());
            prodToInsert.setSecondImg(insertingProduct.getSecondImg());
            prodToInsert.setSize(insertingProduct.getSize());
            entityManager.persist(prodToInsert);
            entityManager.getTransaction().commit();
            return true;
            //TODO check exception type
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Boolean deleteProduct(Product deletingProduct) {
        try {
            entityManager.getTransaction().begin();
            Product prodToDelete = entityManager.find(Product.class, deletingProduct.getProductId());
            entityManager.remove(prodToDelete);
            entityManager.getTransaction().commit();
            return true;
            //TODO check exception type
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public void close() {
        if (entityManager.isOpen())
            entityManager.close();
    }

    @Override
    public List<String> getSizes() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        return list;
    }

    @Override
    public List<String> getColors() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        return list;
    }


    @Override
    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Men");
        list.add("Women");
        list.add("Children");
        return list;
    }

    @Override
    public List<String> getTypes() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("T-Shirt");
        list.add("Shirt");
        list.add("Cap");
        return list;
    }


}
