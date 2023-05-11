package com.example.springdatatest.service;

import com.example.springdatatest.entity.Product;
import com.example.springdatatest.repository.ProductRepository;
import com.example.springdatatest.specification.ProductSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductSpecification productSpecification;

    public ProductServiceImpl(ProductRepository productRepository, ProductSpecification productSpecification) {
        this.productRepository = productRepository;
        this.productSpecification = productSpecification;
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

    @Override
    public List<Product> findProductsLessValue(Integer value) {
        return productRepository.findAll(productSpecification.minPriceProducts(value));
    }

    @Override
    public List<Product> findProductsMoreValue(Integer value) {
        return productRepository.findAll(productSpecification.maxPriceProducts(value));
    }

    @Override
    public List<Product> findProductsInTheRangeValues(Integer minValue, Integer maxValue) {
        return productRepository.findAll(productSpecification.minMaxPriceProduct(minValue, maxValue));
    }
}
