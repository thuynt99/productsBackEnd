package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contract.ResponseContract;
import com.example.demo.pojo.VariantOption;
import com.example.demo.service.VariantOptionService;

@RestController
@RequestMapping("/api")
public class VariantOptionController {
	@Autowired
	VariantOptionService variantOptionService;
	
	@GetMapping("/getVariantOption/{variantId}")
	public VariantOption getVariantOption(@PathVariable Integer variantId) {
		return variantOptionService.getVariantOption(variantId);
	}
	@PutMapping("/updateVariantOption")
	public ResponseContract<?> updateVariantOption(@RequestBody VariantOption vOption) {
		return variantOptionService.updateVariantOption(vOption);
	}
	@PostMapping("/createVO")
	public ResponseContract<?> createVO(@RequestBody VariantOption vOption) {
		return variantOptionService.createVO(vOption);
	}
}
