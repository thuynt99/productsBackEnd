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
import com.example.demo.model.Option;
import com.example.demo.service.OptionService;

@RestController
@RequestMapping("/api")
public class OptionController {
	@Autowired
	OptionService optionService;
	@PostMapping("/createOptionValue")
	public ResponseContract<?> createOptionValue(@RequestBody Option option) {
		return optionService.createOptionValue(option);
	}
	@DeleteMapping("/deleteOption/{optionId}")
	public ResponseContract<?> deleteOption(@PathVariable 	int optionId) {
		return optionService.deleteOption(optionId);
	}
	@DeleteMapping("/deleteListOptions")
	public ResponseContract<?> deleteOptions(@RequestBody List<Integer> list) {
		return optionService.deleteOptions(list);
	}
	
}
