package com.batm.Day2.repositories;

import com.batm.Day2.entities.Category;
import com.batm.Day2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Integer> {

}
