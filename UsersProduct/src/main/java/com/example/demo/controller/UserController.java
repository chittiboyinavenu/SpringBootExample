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

import com.example.demo.entity.User;
import com.example.demo.serviceIntr.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@GetMapping("/get")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@GetMapping("/get/{id}")
	public User getByIdUser(@PathVariable Long id)
	{
		return userService.getByIdUser(id);
	}
	
	@PutMapping("/update/id")
	public User updateUser(@PathVariable Long id ,@RequestBody User user)
	{
		return userService.updateUser(id,user);
	}
	
	@DeleteMapping("/delete/id")
	public void deleteUser(@PathVariable Long id)
	{
		 userService.deleteUser(id);
	}
}
