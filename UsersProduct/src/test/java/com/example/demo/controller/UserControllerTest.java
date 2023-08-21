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
import com.example.demo.entity.User;
import com.example.demo.serviceIntr.UserService;

@SpringBootTest
class UserControllerTest
{
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Mock
	private User user;
	
	
		
	public static User getUser()
	{
		User user=new User();
		user.setId(1L);
		user.setUserName("venu");
		user.setUserGender("male");
		user.setUserAge("23");
		user.setUserAddress("bangalore");
		return user;
	} 

	@Test
	void testAddUser() 
	{
		User user=getUser();
		Mockito.when(userService.addUser(user)).thenReturn(user);
		assertEquals(userController.addUser(user).getUserName(), user.getUserName());
		
	}

	@Test
	void testGetAllUser() {
		User user=getUser();
		List<User> list = new ArrayList<User>();
		list.add(user);
		Mockito.when(userService.getAllUser()).thenReturn(list);
		assertEquals(userController.getAllUser().isEmpty(), list.isEmpty());
	}

	@Test
	void testGetByIdUser() {
		User user=getUser();
		Mockito.when(userService.getByIdUser(1L)).thenReturn(user);
		assertEquals(userController.getByIdUser(1L).getUserName(),user.getUserName());
	}

	@Test
	void testUpdateUser() {
		User user=getUser();
		Mockito.when(userService.updateUser(1L, user)).thenReturn(user);
		assertEquals(userController.updateUser(1L, user).getUserName(), user.getUserName());
	}

	@Test
	void testDeleteUser() {
		//long userId=1L;
		doNothing().when(userService).deleteUser(1L);
		userController.deleteUser(1L);
	}

}
