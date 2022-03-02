package com.bhavna.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavna.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
