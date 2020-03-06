package com.example.demo.repository;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;

import org.apache.catalina.util.ParameterMap;
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

@Repository
public class ProductRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	public int create(Product product) {
		String sql ="INSERT INTO tbl_products(product_name, product_line, product_price, product_image, product_description, created_at) VALUE(:productName, :productLine, :productPrice, :productImage, :productDescription, CURRENT_TIMESTAMP)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(product);
		jdbcTemplate.update(sql, source, keyHolder);
		return keyHolder.getKey().intValue();
	}
	public List<Product> getAll(){
		String sql ="SELECT * FROM tbl_products";
		List<Product> listProduct = jdbcTemplate.query(sql, new HashMap<>(),
				new BeanPropertyRowMapper<Product>(Product.class));
				return listProduct;
	}
	
	public Product findByProductId(int id) {
		String sql = "SELECT * from productdb.tbl_products where id = :id";
		Map<String, Object> argMap = new HashMap<>();
		argMap.put("id", id);
		return jdbcTemplate.queryForObject(sql, argMap, new BeanPropertyRowMapper<Product>(Product.class));
	}
	
	public boolean deleteProduct(int id) {
		String sql = "delete from tbl_products where id = :id";
		Map<String, Object> maps = new HashMap<String , Object>();
		maps.put("id", id);
		int status = jdbcTemplate.update(sql, maps);
		if(status != 0) {return true;}
		else {return false;}
	}
	public int updateProduct(Product p) {
		System.out.println(p.id);
		if (p.id ==null) {
			
		}
		String sql = "UPDATE tbl_products SET product_name=:productName, product_line=:productLine, product_price=:productPrice, product_description=:productDescription, updated_at=CURRENT_TIMESTAMP WHERE id=:id";
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(p);
		return jdbcTemplate.update(sql, source);	
	}
	
	public List<Product> findByName(String productName) {
		String sql = "SELECT * FROM tbl_products WHERE product_name LIKE '"+ "%" + productName + "%" +"' ";
		List<Product> listProduct = jdbcTemplate.query(sql, new HashMap<>(),
				new BeanPropertyRowMapper<Product>(Product.class));
				return listProduct;	
	}
	
	public List<Product> findBySize(int size) {
		List<Product> listProduct = new ArrayList<Product>();
		
		String sqlOp = "select * from tbl_variants v where v.variant_id in "
				+ "(select tbl_variants_variant_id from tbl_options op where op.option_value =" + size + ")";
		
		List<Variant> variants  = jdbcTemplate.query(sqlOp, new HashMap<>(),
					new BeanPropertyRowMapper<Variant>(Variant.class));			
			for (int j = 0; j < variants.size(); j++) {
				String sqlP = "select * from tbl_products p where p.id = " + variants.get(j).getTbl_productsId();
				listProduct.addAll(jdbcTemplate.query(sqlP, new HashMap<>(),
						new BeanPropertyRowMapper<Product>(Product.class)));
			}
			
		return listProduct;	
		
	}

}
