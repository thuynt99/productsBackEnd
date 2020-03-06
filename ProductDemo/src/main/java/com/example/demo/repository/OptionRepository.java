package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Option;

@Repository
public class OptionRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public String createOptionValue(Option option) {
		String sql = "insert into tbl_options(option_value, tbl_variants_variant_id ) value(:optionValue, :tbl_variantsVariantId)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(option);
		jdbcTemplate.update(sql, source, keyHolder);
		return  "true OptionId: " + keyHolder.getKey().intValue();
	}
	public String deleteOption(int optionId) {
		String sql = "delete from tbl_options where option_id = :optionId";
		Map<String, Object> maps = new HashMap<String , Object>();
		maps.put("optionId", optionId);
		int status = jdbcTemplate.update(sql, maps);
		return "Delete Option " + status;
	}
}
