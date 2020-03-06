package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contract.ResponseContract;
import com.example.demo.pojo.SanPham;
import com.example.demo.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class SanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/productDetail/{id}")
	public SanPham getProductDetail(@PathVariable int id) {
		return sanPhamService.getProductDetail(id);
	}
	@PutMapping("/updateProduct")
	public ResponseContract<?> updateProduct(@RequestBody SanPham sanPham) {
		return sanPhamService.updateProduct(sanPham);
	}
	
}
