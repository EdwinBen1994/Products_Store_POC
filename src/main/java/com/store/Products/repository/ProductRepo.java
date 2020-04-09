package com.store.Products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.Products.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{

}
