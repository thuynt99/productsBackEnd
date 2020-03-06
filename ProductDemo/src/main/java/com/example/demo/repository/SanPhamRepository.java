package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Option;
import com.example.demo.model.Product;
import com.example.demo.model.Variant;
import com.example.demo.pojo.SanPham;
import com.example.demo.pojo.VariantOption;

@Repository
public class SanPhamRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public SanPham getProductDetail(int id) {
		String sql = "select * from tbl_products where id = :id ";
		Map<String, Object> argMap = new HashMap<>();
		argMap.put("id", id);
		SanPham result = new SanPham();
		result.setProduct(jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<Product>(Product.class)));
		List<VariantOption> listVariantOptions = new ArrayList<VariantOption>();
		List<Variant> listVariants;
		sql = "select * from tbl_variants where tbl_products_id = " + result.getProduct().getId();
		listVariants = jdbcTemplate.query(sql, new HashMap<>(), new BeanPropertyRowMapper<Variant>(Variant.class));
		for (int i = 0; i < listVariants.size(); i++) {
			VariantOption variantOption = new VariantOption();
			sql = "select * from tbl_options where tbl_variants_variant_id = " + listVariants.get(i).getVariantId();
			variantOption.setVariant(listVariants.get(i));
			variantOption.setListOption(jdbcTemplate.query(sql, new BeanPropertyRowMapper<Option>(Option.class)));
			listVariantOptions.add(i, variantOption);
		}
		result.setListVariantOptions(listVariantOptions);
		return result;
	}
	
	public String updateProduct(SanPham sanPham) {
		Product product = sanPham.getProduct();
		String sql = "UPDATE tbl_products SET product_name=:productName, product_line=:productLine, product_price=:productPrice, product_description=:productDescription, updated_at=CURRENT_TIMESTAMP WHERE id=:id";
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(product);
		jdbcTemplate.update(sql, source);
		List<VariantOption> list = sanPham.getListVariantOptions();
		for( int i = 0; i< list.size(); i++) {
			Variant variant = list.get(i).getVariant();
			String sqlVar = "update tbl_variants set variant_name = " + variant.getVariantName() + " where variant_id=" + variant.getVariantId();
			BeanPropertySqlParameterSource sourceVar = new BeanPropertySqlParameterSource(variant);
			jdbcTemplate.update(sqlVar, sourceVar);
			List<Option> options = list.get(i).getListOption();
			for(int j = 0; j < options.size(); j++) {
				Option option = options.get(j);
				String mysql = "update tbl_options set option_value = " + option.getOptionValue() + " where option_id = " + option.getOptionId();
				BeanPropertySqlParameterSource optionSource = new BeanPropertySqlParameterSource(option);
				jdbcTemplate.update(mysql, optionSource);
			}
			
		}
		return "true";
	}
}
