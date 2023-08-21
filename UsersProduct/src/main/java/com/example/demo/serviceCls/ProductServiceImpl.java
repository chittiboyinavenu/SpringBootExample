package com.example.demo.serviceCls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.serviceIntr.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getByIdProduct(Long id) {
		return productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product product1=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
		product1.setProductName(product.getProductName());
		product1.setProductNumber(product.getProductNumber());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}	

}
