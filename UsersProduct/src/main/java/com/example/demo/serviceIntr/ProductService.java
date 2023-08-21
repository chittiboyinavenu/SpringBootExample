package com.example.demo.serviceIntr;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;

@Service
public interface ProductService {

	Product addProduct(Product product);

	Product getByIdProduct(Long id);

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);

	List<Product> getAllProduct();

}
