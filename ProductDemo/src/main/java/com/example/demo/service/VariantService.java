package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Variant;
import com.example.demo.repository.VariantRepository;

@Service
public class VariantService {
	@Autowired
	VariantRepository variantRepository;
	public String createVariant(Variant variant) {
		return variantRepository.createVariant(variant);
	}
	public ResponseContract<?> deleteVariant(int variantId) {
		try {
			return new ResponseContract<String>("200", "Success", variantRepository.deleteVariant(variantId));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	public ResponseContract<?> deleteVariants(List<Integer> list) {
		try {
			for( Integer id : list) {
				variantRepository.deleteVariant(id);
			}
			return new ResponseContract<List<Integer>>("200", "Success", list);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
}
