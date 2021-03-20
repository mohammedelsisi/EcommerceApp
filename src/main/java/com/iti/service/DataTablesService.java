package com.iti.service;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;

import java.util.List;

public class DataTablesService {

    private final ProductDao productDao= ProductDaoImp.getInstance();
    private static final DataTablesService dataTablesService = new DataTablesService();

    public static synchronized DataTablesService getInstance(){
        return dataTablesService;
    }
    public List<ProductDTO> retriveAllProducts(){return productDao.retrieveAllProducts();}

}
