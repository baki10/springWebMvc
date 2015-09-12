package com.bakigoal.service;

import com.bakigoal.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bakigoal on 09.09.15.
 */
public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);
    void addProduct(Product product);
}
