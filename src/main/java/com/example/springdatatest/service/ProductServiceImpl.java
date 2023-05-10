package com.example.springdatatest.service;

import com.example.springdatatest.entity.Product;
import com.example.springdatatest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Long saveOrUpdateProduct(Product product) {
        return productRepository.save(product).getId();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
