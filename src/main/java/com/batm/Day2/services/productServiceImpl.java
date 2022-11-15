package com.batm.Day2.services;

import com.batm.Day2.entities.Product;
import com.batm.Day2.repositories.CategoryRepository;
import com.batm.Day2.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements productService {

    @Autowired
    private productRepository productRepository;

    @Override
    public boolean saveProduct(Product product) {
        productRepository.save(product);
        return productRepository.findById(product.getId()).isPresent();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category tidak ditemukan"));
    }

    @Override
    public boolean deleteProductById(int id) {
        productRepository.deleteById(id);
        return !productRepository.findById(id).isPresent();
    }
}
