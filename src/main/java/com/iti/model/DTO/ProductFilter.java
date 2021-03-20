package com.iti.model.DTO;
import java.util.*;
import java.lang.reflect.Array;

public class ProductFilter {
   String [] colors;
   String [] Size;
    String search;
    double minPrice;
    double maxPrice;

    public ProductFilter(String[] colors, String[] size, String search, double minPrice, double maxPrice) {
        this.colors = colors;
        Size = size;
        this.search = search;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
}
