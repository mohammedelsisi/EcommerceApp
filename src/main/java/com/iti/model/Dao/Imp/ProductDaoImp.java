package com.iti.model.Dao.Imp;

import com.iti.model.DTO.ProductDTO;
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
import java.util.ListIterator;

public class ProductDaoImp implements ProductDao {
    EntityManager entityManager;
    ProductDTO p1 = new ProductDTO("t-shirt", "layout/images/cloth_1.jpg", 50);
    ProductDTO p2 = new ProductDTO("t-shirt", "layout/images/cloth_2.jpg", 50);
    ProductDTO p3 = new ProductDTO("t-shirt", "layout/images/cloth_3.jpg", 50);
    ProductDTO p4 = new ProductDTO("t-shirt", "layout/images/cloth_1.jpg", 50);
    ProductDTO p5 = new ProductDTO("t-shirt", "layout/images/cloth_2.jpg", 50);
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
        System.out.println(productFilter);
        String search = productFilter.getSearch();
        List<String> colors = productFilter.getColors();
        List<String> sizes = productFilter.getSizes();
        List<String> cates = productFilter.getCategories();
        StringBuilder query = new StringBuilder();
        double minPrice = productFilter.getMinPrice();
        double maxPrice = productFilter.getMaxPrice();
        query.append("from Product where price between ").append(minPrice).append(" and ").append(maxPrice);
        if (!search.equals("")) {
            query.append(" and (description like '%").append(search).append("%' ");
            query.append("or type like '%").append(search).append("%'");
            query.append("or category like '%").append(search).append("%')");
        }
        if (colors.size() > 0) {
            StringBuilder color = new StringBuilder();
            for (int i = 0; i < colors.size(); i++) {

                color.append("'").append(colors.get(i));
                color.append("'");
                if (i != colors.size() - 1)
                    color.append(", ");
            }
            query.append(" and color in ( ").append(color).append(")");
        }
        if (sizes.size() > 0) {
            StringBuilder size = new StringBuilder();
            for (int i = 0; i < sizes.size(); i++) {

                size.append("'").append(sizes.get(i));
                size.append("'");

                if (i != sizes.size() - 1)
                    size.append(", ");
            }
            query.append(" and size in ( ").append(size).append(")");
        }
        if (cates.size() > 0) {
            StringBuilder cate = new StringBuilder();
            for (int i = 0; i < cates.size(); i++) {

                cate.append("'").append(cates.get(i));
                cate.append("'");

                if (i != cates.size() - 1)
                    cate.append(", ");
            }
            query.append(" and category in ( ").append(cate).append(")");
        }
        System.out.println(query);
        return entityManager.createQuery(query.toString(), Product.class).getResultList();

    }

    @Override
    public List<String> getSizes() {
        List<String> list = new ArrayList<>();
        list.add("Small");
        list.add("Medium");
        list.add("Large");
        return list;
    }

    @Override
    public List<String> getColors() {
        List<String> list = new ArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        return list;
    }

    @Override
    public void close() {
        if (entityManager.isOpen())
            entityManager.close();
    }


    @Override
    public List<String> getTypes() {
        List<String> list = new ArrayList<>();
        list.add("T-Shirt");
        list.add("Shirt");
        list.add("Cap");
        return list;
    }



    @Override
    public List<ProductDTO> retrieveAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p5);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p5);
        products.add(p1);
        products.add(p2);

        return products;
    }
    public  Product retrieveItem(long id) {

        return entityManager.find(Product.class,id);

    }

    @Override
    public Product getProductById(long prodId) {
        return entityManager.createQuery("from Product where id =:prodId",Product.class).setParameter("prodId", prodId).getSingleResult();
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
    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.add("Men");
        list.add("Women");
        list.add("Children");
        return list;
    }

}
