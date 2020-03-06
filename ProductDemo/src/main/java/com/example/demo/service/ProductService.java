package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public int create(Product product) {
		return productRepository.create(product);
	}
	
	public ResponseContract<?> getAll() {
		try {
			return new ResponseContract<List<Product>>("200", "Success", productRepository.getAll());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> findByProductId(int id) {
		try {
			return new ResponseContract<Product>("200", "Success", productRepository.findByProductId(id));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public boolean deleteProduct(int id) {
		return productRepository.deleteProduct(id);
	}
	public int updateProduct(Product p) {
		return productRepository.updateProduct(p);
	}
	public ResponseContract<?> deleteListId(List<Integer> list) {
		try {
			for( Integer id : list) {
				productRepository.deleteProduct(id);
			}
			return new ResponseContract<List<Integer>>("200", "Success", list);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> findByName(String productName) {
		try {
			return new ResponseContract<List<Product>>("200", "Success", productRepository.findByName(productName));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> findBySize(int size) {
		try {
			return new ResponseContract<List<Product>>("200", "Success", productRepository.findBySize(size));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
		
	}
}
