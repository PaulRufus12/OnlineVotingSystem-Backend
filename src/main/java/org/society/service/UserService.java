package org.society.service;

import java.util.List;
import java.util.Optional;

import org.society.entities.User;

public interface UserService {
	public User registerUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
	public List<User> viewUserList();
	public User findByUserId(int userId);
	public Optional<User> login(String emailId,String password);
}
