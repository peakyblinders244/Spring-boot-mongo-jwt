package com.hcmus.demo.demo.controller;

import com.hcmus.demo.demo.model.Product;
import com.hcmus.demo.demo.service.IProductService;
import com.hcmus.demo.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("service/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable(value = "id") String id) {
        return productService.findOne(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable(value = "id") String id) {
        if (product.getId() == null) {
            product.setId(id);
        }
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        productService.delete(id);
    }
}
