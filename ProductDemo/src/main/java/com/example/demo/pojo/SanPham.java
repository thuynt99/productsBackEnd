package com.example.demo.pojo;

import java.util.List;


import com.example.demo.model.Product;

public class SanPham {
	Product product;
	List<VariantOption> listVariantOptions;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<VariantOption> getListVariantOptions() {
		return listVariantOptions;
	}
	public void setListVariantOptions(List<VariantOption> listVariantOptions) {
		this.listVariantOptions = listVariantOptions;
	}
	
}
