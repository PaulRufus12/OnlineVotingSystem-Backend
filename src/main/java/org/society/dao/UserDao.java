package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.User;
import org.society.exceptions.UserNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.society.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDao {
	@Autowired
	UserRepo userdao;

	public void setUserDao(UserRepo userdao) {
		this.userdao = userdao;
	}

	@Transactional
	public User registerUser(User user) {
		return userdao.save(user);

	}

	@Transactional
	public boolean updateUser(User user) throws UserNotFoundException {
		boolean a = false;

		if (userdao.existsById(user.getUserId())) {
			userdao.save(user);
			a = true;
		}

		else
		{
			throw new UserNotFoundException();
		}

		return a;
	}

	@Transactional
	public boolean deleteUser(int userId) throws UserNotFoundException {
		boolean a = false;

		if (userdao.existsById(userId)) {
			userdao.deleteById(userId);
			a = true;
		}

		else
			throw new UserNotFoundException();

		return a;
	}

	@Transactional(readOnly = true)
	public List<User> viewUserList() {

		return userdao.findAll();
	}

	@Transactional(readOnly = true)
	public User findByUserId(int userId) throws UserNotFoundException {
		User user = null;

		if (userdao.existsById(userId))
			user = userdao.findById(userId).get();

		else 
			throw new UserNotFoundException();

		return user;
	}
	
	@Transactional(readOnly = true)
	public Optional<User> login(String emailId,String password) throws UserNotFoundException,WrongCredentialsException{
		Optional<User> u = userdao.getByEmailId(emailId);
		if(u.isPresent()) {
			if(password.equals(userdao.readLoginData(emailId)))
			  return u;
			else
				throw new WrongCredentialsException();
		}
		else
		{
			throw new UserNotFoundException();
		}
	}

}
