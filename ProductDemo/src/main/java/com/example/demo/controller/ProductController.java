package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/create")
	public int create(@RequestBody Product product) {
		return productService.create(product);
	}

	@GetMapping("/products")
	public ResponseContract<?> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseContract<?> findByProductId(@PathVariable int id) {
		return productService.findByProductId(id);
	}
	
	@DeleteMapping("/products/{id}")
	public boolean deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	@PutMapping("/products")
	public int updateProduct(@RequestBody Product p) {
		return productService.updateProduct(p);
	}
	@DeleteMapping("/deleteList")
	public ResponseContract<?> deleteListId(@RequestBody List<Integer> list) {
		return productService.deleteListId(list);
	}
	@GetMapping("/findByName")
	public ResponseContract<?> findByName(@RequestBody String productName) {
		return productService.findByName(productName);
	}
	@GetMapping("/findBySize/{size}")
	public ResponseContract<?> findBySize(@PathVariable int size) {
		return productService.findBySize(size);
	}
}
