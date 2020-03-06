package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Option;
import com.example.demo.model.Variant;
import com.example.demo.pojo.VariantOption;

@Repository
public class VariantOptionRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public VariantOption getVariantOption(Integer variantId) {
		String sql = "select * from tbl_variants where variant_id = :variant_id";
		Map<String, Object> argMap = new HashMap<>();
		argMap.put("variant_id", variantId);
		VariantOption variantOption = new VariantOption();
		variantOption.setVariant(jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<Variant>(Variant.class)));
		sql = "select * from tbl_options where tbl_variants_variant_id = " + variantOption.getVariant().getVariantId();
		variantOption.setListOption(jdbcTemplate.query(sql, argMap, new BeanPropertyRowMapper<Option>(Option.class)));
		return variantOption;
	}
	public String updateVariantOption(VariantOption vOption) {
		Variant variant = vOption.getVariant();
		String sql = "update tbl_variants set variant_name = :variantName where variant_id = :variantId";
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(variant);
		jdbcTemplate.update(sql, source);	
		int n = vOption.getListOption().size();
		for(int i = 0; i < n; i++) {
			Option option = vOption.getListOption().get(i);
			String mysql = "update tbl_options set option_value ='"+ option.getOptionValue() +"' where option_id = " + option.getOptionId();
			BeanPropertySqlParameterSource optionSource = new BeanPropertySqlParameterSource(vOption);
			jdbcTemplate.update(mysql, optionSource);
		}	
		return "true";
	}
}
