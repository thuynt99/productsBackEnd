package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Variant;
import com.example.demo.service.VariantService;

@RestController
@RequestMapping("/api")
public class VariantController {
	@Autowired
	VariantService variantService;
	
	@PostMapping("/createVariant")
	public String createVariant(@RequestBody Variant variant) {
		return variantService.createVariant(variant);
	}
	@DeleteMapping("/deleteVariant/{variantId}")
	public ResponseContract<?> deleteVariant(@PathVariable int variantId) {
		return variantService.deleteVariant(variantId);
	}
	@DeleteMapping("/deleteListVariants")
	public ResponseContract<?> deleteVariants(@RequestBody List<Integer> list) {
		return variantService.deleteVariants(list);
	}
}
	
