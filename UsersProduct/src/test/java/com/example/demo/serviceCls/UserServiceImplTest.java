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

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class UserServiceImplTest
{
	@Spy
	@InjectMocks UserServiceImpl userServiceImpl;
	
	@Mock UserRepository userRepository;
	
	@Mock User user;
	
	public static User getUser()
	{
		User user=new User();
		user.setId(1L);
		user.setUserName("venu");
		user.setUserAge("23");
		user.setUserGender("male");
		user.setUserAddress("bangalore");
		return user;
	}

	@Test
	void testAddUser() {
		User user=getUser();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(userServiceImpl.addUser(user).getUserName(), user.getUserName());
	}

	@Test
	void testGetAllUser() {
		//User user=getUser();
		List<User>list=new ArrayList<User>();
		Mockito.when(userRepository.findAll()).thenReturn(list);
		assertEquals(userServiceImpl.getAllUser().isEmpty(), list.isEmpty());
	}

	@Test
	void testGetByIdUser()
	{
		User user=getUser();
		Optional<User> o = Optional.of(user);
		Mockito.when(userRepository.findById(1L)).thenReturn(o);
		assertEquals(userServiceImpl.getByIdUser(1L).getUserName(),user.getUserName());
	}

	@Test
	void testUpdateUser() {
		//Long id = 1L;
		User user=getUser();
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		userServiceImpl.updateUser(1L, user);
		verify(userServiceImpl, times(1)).updateUser(1L, user);
	}

	@Test
	void testDeleteUser()
	{
		Long id = 1L;
		doNothing().when(userRepository).delete(user);
		userServiceImpl.deleteUser(id);
	}

}
