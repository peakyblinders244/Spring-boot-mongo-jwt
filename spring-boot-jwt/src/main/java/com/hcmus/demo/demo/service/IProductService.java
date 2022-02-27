package com.hcmus.demo.demo.service;

import com.hcmus.demo.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    Product save(Product product);
    void delete(String id);
    Product findOne(String id);
    List<Product> findAll();
    Product update(Product product);
}
