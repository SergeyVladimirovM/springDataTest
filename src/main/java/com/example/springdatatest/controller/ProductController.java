package com.example.springdatatest.controller;

import com.example.springdatatest.dto.ProductInput;
import com.example.springdatatest.entity.Product;
import com.example.springdatatest.service.ProductService;
import com.example.springdatatest.service.ProductServiceImpl;
import com.example.springdatatest.specification.ProductSpecification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product productById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @PostMapping("/")
    public Long saveOrUpdateProduct(@RequestBody ProductInput productInput) {
        Product product = new Product(
                productInput.getTitle(),
                productInput.getPrice()
        );
        return productService.saveOrUpdateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "Product delete";
    }

    @PostMapping("/less")
    public List<Product> getProductsLessValue(@RequestBody Integer value) {
        return productService.findProductsLessValue(value);
    }

    @PostMapping("/more")
    public List<Product> getProductsMoreValue(@RequestBody Integer value) {
        return productService.findProductsMoreValue(value);
    }

    @PostMapping("/range")
    public List<Product> getProductsInTheRange(@RequestBody List<Integer> values) {
        return productService.findProductsInTheRangeValues(values.get(0), values.get(1));
    }
}
