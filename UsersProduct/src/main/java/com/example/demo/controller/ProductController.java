package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.serviceIntr.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
		
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/get")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	@GetMapping("/get/{id}")
	public Product getByIdProduct(@PathVariable Long id)
	{
		return productService.getByIdProduct(id);
	}
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product)
	{
		return productService.updateProduct(id,product);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id)
	{
		productService.deleteProduct(id);
	}
}
