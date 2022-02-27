package com.hcmus.demo.demo.service.impl;

import com.hcmus.demo.demo.model.Product;
import com.hcmus.demo.demo.repository.IProductRepository;
import com.hcmus.demo.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {

        productRepository.deleteById(id);
    }

    @Override
    public Product findOne(String id) {
        return productRepository.findById(id).get();
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        Product productUpdate = productRepository.findById(product.getId()).get();
        productUpdate.setName(product.getName());
        productUpdate.setImage(product.getImage());
        productUpdate.setPrice(product.getPrice());
        return productRepository.save(productUpdate);
    }


}
