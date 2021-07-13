package com.edersousa.productcatalog.controller;

import com.edersousa.productcatalog.model.Product;
import com.edersousa.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produtc")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws Exception {
        return productRepository.findById(id).orElseThrow(() -> new Exception("Product not found!"));
    }

    @RequestMapping(value = "/name/{name}")
    public Iterable<Product> findByName(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }
}
