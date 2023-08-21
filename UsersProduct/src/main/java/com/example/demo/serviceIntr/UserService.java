package com.example.demo.serviceIntr;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {

	User addUser(User user);

	List<User> getAllUser();

	User getByIdUser(Long id);

	User updateUser(Long id, User user);

	void deleteUser(Long id);

}
