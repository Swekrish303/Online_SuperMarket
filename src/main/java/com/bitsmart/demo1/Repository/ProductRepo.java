package com.bitsmart.demo1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsmart.demo1.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
