package com.edersousa.productcatalog.repository;

import com.edersousa.productcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
}
