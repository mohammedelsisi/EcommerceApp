package com.iti.service;

import com.iti.model.DTO.ProductDTO;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;


import java.util.List;

public class HomeService {

    private final ProductDao productDao= ProductDaoImp.getInstance();
    private static final HomeService homeService = new HomeService();

    public static synchronized HomeService getInstance(){
        return homeService;
    }
    public List<ProductDTO> retriveMaxiQuant(){return productDao.retriveMaxiQuant();}
}
