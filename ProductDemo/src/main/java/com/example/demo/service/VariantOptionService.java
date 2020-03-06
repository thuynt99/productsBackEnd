package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Option;
import com.example.demo.model.Variant;
import com.example.demo.pojo.VariantOption;
import com.example.demo.repository.VariantOptionRepository;

@Service
public class VariantOptionService {
	@Autowired
	VariantOptionRepository variantOptionRepository;
	@Autowired
	VariantService variantService;
	@Autowired
	OptionService optionService;
	public VariantOption getVariantOption(Integer variantId) {
		return variantOptionRepository.getVariantOption(variantId);
	}
	public ResponseContract<?> updateVariantOption(VariantOption vOption) {
		try {
			return new ResponseContract<String>("200", "Sucess", variantOptionRepository.updateVariantOption(vOption));
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	
	public ResponseContract<?> createVO(VariantOption vOption) {
		try {
			Variant variant = vOption.getVariant();
			variantService.createVariant(variant);
			List<Option> list = vOption.getListOption();
			for (int i = 0; i< list.size(); i++) {
				Option option = list.get(i);
				optionService.createOptionValue(option);
			}
			return new ResponseContract<String>("200", "Success", null);
		} catch(Exception e) {
			e.getStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
}
