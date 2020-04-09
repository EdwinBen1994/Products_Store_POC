package com.store.Products.service;

import java.util.List;

import com.store.Products.exception.ProductException;
import com.store.Products.model.Products;


public interface ProductService {
	Products createProduct(Products product);

	Products updateProduct(Products product) throws ProductException;

	List<Products> getAllProduct();

	Products getProductById(long productId) throws ProductException;

	void deleteProduct(long id) throws ProductException;
}
