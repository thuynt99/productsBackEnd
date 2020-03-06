package com.example.demo.repository;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Variant;

@Repository
public class VariantRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public String createVariant(Variant variant) {
		String sql = "INSERT INTO tbl_variants(variant_name, tbl_products_id) VALUE(:variantName, :tbl_productsId)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(variant);
		jdbcTemplate.update(sql, source, keyHolder);
		return "true variantId: " + keyHolder.getKey().intValue();
	}
	public String deleteVariant(int variantId) {
		String sql = "delete from tbl_variants where variant_id = :variantId";
		Map<String, Object> maps = new HashMap<String , Object>();
		maps.put("variantId", variantId);
		int status = jdbcTemplate.update(sql, maps);
		return "Delete " + status;
		}
}
