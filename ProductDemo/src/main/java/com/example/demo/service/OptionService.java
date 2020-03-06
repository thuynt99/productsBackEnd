package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Option;
import com.example.demo.repository.OptionRepository;

@Service
public class OptionService {
	@Autowired
	OptionRepository optionRepository;
	public ResponseContract<?> createOptionValue(Option option) {
		try { 
			return new ResponseContract<String>("200", "Success", optionRepository.createOptionValue(option));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> deleteOption(int optionId) {
		try {
			return new ResponseContract<String>("200", "Success", optionRepository.deleteOption(optionId));
		} catch(Exception e) {
			e.getStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> deleteOptions(List<Integer> list) {
		try {
			for( Integer id : list) {
				optionRepository.deleteOption(id);
			}
			return new ResponseContract<List<Integer>>("200", "Success", list);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
}
