package com.java.data.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.data.redis.entity.Product;
import com.java.data.redis.repository.ProductDAO;

@RestController
@RequestMapping("/product")
public class RedisController {

	@Autowired
	ProductDAO dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> findAll(){
		return dao.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return dao.getProductById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		return dao.deleteProduct(id);
	}
}
