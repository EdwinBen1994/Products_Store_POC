package com.store.Products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.Products.exception.ProductException;
import com.store.Products.model.Products;
import com.store.Products.repository.ProductRepo;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepo productRepository;
	
	
	@Override
	public Products createProduct(Products product) {
		return productRepository.save(product);
	}

	@Override
	public Products updateProduct(Products product) throws ProductException {
		Optional<Products> productDb = this.productRepository.findById(product.getId());
		
		if(productDb.isPresent()) {
			Products productUpdate = productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}else {
			throw new ProductException("Record not found with id : " + product.getId());
		}		
	}

	@Override
	public List<Products> getAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Products getProductById(long productId) throws ProductException {
		
		Optional<Products> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ProductException("Record not found with id : " + productId);
		}
	}

	@Override
	public void deleteProduct(long productId) throws ProductException {
		Optional<Products> productDb = this.productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}else {
			throw new ProductException("Record not found with id : " + productId);
		}
		
	}

}
