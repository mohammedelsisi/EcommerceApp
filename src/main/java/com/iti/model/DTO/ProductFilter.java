package com.iti.model.DTO;

import java.util.*;

public class ProductFilter {
    List<String> colors;
    List<String> sizes;
    String search;
    double minPrice;
    double maxPrice;
    boolean isEmpty;

    public ProductFilter() {
    }

    public static ProductFilter getEmptyFilter(){
       ProductFilter productFilter = new ProductFilter();
       productFilter.setEmpty(true);
       return productFilter;
   }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public static ProductFilter createFilledFilter(List<String> colors, List<String> sizes, String search, double minPrice, double maxPrice) {
        ProductFilter productFilter = new ProductFilter();
        productFilter.setEmpty(false);
        productFilter.colors = colors;
        productFilter.sizes = sizes;
        productFilter.search = search;
        productFilter.minPrice = minPrice;
        productFilter.maxPrice = maxPrice;
        return productFilter;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public String toString() {
        return "ProductFilter{" +
                "colors=" + colors +
                ", sizes=" + sizes +
                ", search='" + search + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
}
