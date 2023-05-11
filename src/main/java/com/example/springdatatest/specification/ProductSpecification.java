package com.example.springdatatest.specification;

import com.example.springdatatest.entity.Product;
import com.example.springdatatest.repository.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductSpecification {

    ProductRepository productRepository;

    public ProductSpecification(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Specification<Product> minPriceProducts(Integer maxValue) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lt(root.get("price"), maxValue));
    }

    public Specification<Product> maxPriceProducts(Integer minValue) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get("price"), minValue)));
    }

    public Specification<Product> minMaxPriceProduct(Integer minValue, Integer maxValue) {
        return (((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), minValue, maxValue)));
    }
}
