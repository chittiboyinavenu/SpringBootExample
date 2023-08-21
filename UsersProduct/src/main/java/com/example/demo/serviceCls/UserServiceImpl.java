package com.example.demo.serviceCls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceIntr.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository; 

	@Override
	public User addUser(User user)
	{
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}

	@Override
	public User getByIdUser(Long id)
	{
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","id",id));
	}

	@Override
	public User updateUser(Long id, User user)
	{
		User user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		user1.setUserName(user.getUserName());
		user1.setUserGender(user.getUserGender());
		user1.setUserAge(user.getUserAge());
		user1.setUserAddress(user.getUserAddress());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) 
	{
		userRepository.deleteById(id);
	}

	

}
