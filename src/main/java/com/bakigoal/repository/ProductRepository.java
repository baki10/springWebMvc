package com.bakigoal.repository;

import com.bakigoal.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bakigoal on 08.09.15.
 */
public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);
}
