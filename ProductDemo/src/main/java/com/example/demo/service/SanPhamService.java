package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contract.ResponseContract;
import com.example.demo.model.Option;
import com.example.demo.model.Product;
import com.example.demo.model.Variant;
import com.example.demo.pojo.SanPham;
import com.example.demo.pojo.VariantOption;
import com.example.demo.repository.OptionRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.repository.VariantOptionRepository;
import com.example.demo.repository.VariantRepository;

@Service
public class SanPhamService {
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	VariantOptionRepository variantOptionRepository;
	public SanPham getProductDetail(int id) {
		return sanPhamRepository.getProductDetail(id);
	}
	public ResponseContract<?> updateProduct(SanPham sanPham) {
		try {
			Product product = sanPham.getProduct();
			productRepository.updateProduct(product);
			List<VariantOption> listVO = sanPham.getListVariantOptions();
			int n = listVO.size();
			for(int i = 0; i < n; i++) {
				VariantOption vOption = listVO.get(i);
				variantOptionRepository.updateVariantOption(vOption);
			}
			return new ResponseContract<String>("200", "Success", null);
		} catch(Exception e) {
			e.getStackTrace();
			return new ResponseContract<String>("500", e.getMessage(), null);
		}
	}
	
}
