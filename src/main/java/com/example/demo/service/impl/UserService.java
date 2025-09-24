package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {

	User createUser(User user);

	List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	User updateUser(Long id, User updatedUser);

	void deleteUser(Long id);
}
