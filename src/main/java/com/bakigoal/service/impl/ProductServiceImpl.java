package com.bakigoal.service.impl;

import com.bakigoal.entity.Product;
import com.bakigoal.repository.ProductRepository;
import com.bakigoal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by bakigoal on 09.09.15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
