package com.bakigoal.service.impl;

import com.bakigoal.entity.Product;
import com.bakigoal.repository.ProductRepository;
import com.bakigoal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bakigoal on 08.09.15.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, long quantity) {
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("Out of Stock. Available Units in stock" + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
}
