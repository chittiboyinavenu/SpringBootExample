package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.serviceIntr.ProductService;

@SpringBootTest
class ProductControllerTest
{
	@InjectMocks
	private ProductController productController;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private Product product;
	

	
//	@Mock
//	private static User user;
		
	public static Product getProduct()
	{
		User user=new User();
		Product product=new Product();
		product.setId(1L);
		product.setProductName("apple");
		product.setProductNumber(23L);
		product.setUser(user);
		return product;
	}
	@Test
	void testAddProduct() 
	{
		Product product=getProduct();
		Mockito.when(productService.addProduct(product)).thenReturn(product);
		assertEquals(productController.addProduct(product).getProductName(), product.getProductName());
	}

	@Test
	void testGetProduct() 
	{
		Product product=getProduct();
		List<Product> list = new ArrayList<Product>(); 
		list.add(product);
		Mockito.when(productService.getAllProduct()).thenReturn(list);
		assertEquals(productController.getAllProduct().isEmpty(),list.isEmpty());
	}

	@Test
	void testGetByIdProduct() 
	{
		Product product=getProduct();
		Mockito.when(productService.getByIdProduct(1L)).thenReturn(product);
		assertEquals(productController.getByIdProduct(1L).getProductName(),product.getProductName());
		
	}

	@Test
	void testUpdateProduct() {
		Product product=getProduct();
		Mockito.when(productService.updateProduct(1L, product)).thenReturn(product);
		assertEquals(productController.updateProduct(1L, product).getId(), product.getId());
	}

	@Test
	void testDeleteProduct() 
	{
//		long productId=1L; 
		doNothing().when(productService).deleteProduct(1L);
		productController.deleteProduct(1L);
	}

}
