package com.example.springdatatest.service;

import com.example.springdatatest.entity.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(Long id);
    List<Product> findAllProduct();
    Long saveOrUpdateProduct(Product product);
    void deleteProductById(Long id);
}
