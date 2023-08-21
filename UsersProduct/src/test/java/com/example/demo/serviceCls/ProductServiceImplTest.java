package com.example.demo.serviceCls;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
class ProductServiceImplTest 
{
	@Spy
	@InjectMocks ProductServiceImpl productServiceImpl;
	
	@Mock ProductRepository productRepository;
	
	@Mock Product product;
	
	//@Mock static User user;
	
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
		Product product= getProduct();
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(productServiceImpl.addProduct(product).getProductName(),product.getProductName());
		
	}

	@Test
	void testGetProduct()
	{
		Product product =getProduct();
		List<Product>list=new ArrayList<Product>();
		list.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(list);
		assertEquals(productServiceImpl.getAllProduct().isEmpty(),list.isEmpty());
	}

	@Test
	void testGetByIdProduct() 
	{
		Product product =getProduct();
		Optional<Product> o = Optional.of(product);
		Mockito.when(productRepository.findById(1L)).thenReturn(o);
		assertEquals(productServiceImpl.getByIdProduct(1L).getProductName(), product.getProductName());
		
		
	}

	@Test
	void testUpdateProduct() 
	{
		//Long id = 1L;
		Product product =getProduct();
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		productServiceImpl.updateProduct(1L, product);
		verify(productServiceImpl, times(1)).updateProduct(1L, product);
}

	@Test
	void testDeleteProduct() {
		Long id = 1L;
		doNothing().when(productRepository).delete(product);
		productServiceImpl.deleteProduct(id);
	}

}
