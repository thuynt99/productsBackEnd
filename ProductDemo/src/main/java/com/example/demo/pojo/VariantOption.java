package com.example.demo.pojo;

import java.util.List;

import com.example.demo.model.Option;
import com.example.demo.model.Variant;

public class VariantOption {
	Variant variant;
	List<Option> listOption;
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public List<Option> getListOption() {
		return listOption;
	}
	public void setListOption(List<Option> listOption) {
		this.listOption = listOption;
	}
	
}
