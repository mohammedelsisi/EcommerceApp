package com.iti.model.DTO;

import java.util.*;

public class ProductFilter {
    List<String> colors;
    List<String> sizes;
    String search;
    double minPrice;
    double maxPrice;

    public ProductFilter(List<String> colors, List<String> sizes, String search, double minPrice, double maxPrice) {
        this.colors = colors;
        this.sizes = sizes;
        this.search = search;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
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
