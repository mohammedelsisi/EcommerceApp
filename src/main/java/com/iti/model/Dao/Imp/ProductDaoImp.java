package com.iti.model.Dao.Imp;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Product;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ProductDaoImp implements ProductDao {
    EntityManager entityManager;
    ProductDTO p1 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_1.jpg", 50);
    ProductDTO p2 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_2.jpg", 50);
    ProductDTO p3 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_3.jpg", 50);
    ProductDTO p4 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_1.jpg", 50);
    ProductDTO p5 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_2.jpg", 50);
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
        System.out.println(query);
//        String query2= "from Product where price between 500.0 and 1500.0 and description like '%Shirt%'  and color in ( 'Red', 'Black') and size in ( 'Small', 'Medium')";
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
    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.add("Men");
        list.add("Women");
        list.add("Children");
        return list;
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

}
