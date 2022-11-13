package org.society.dao;

import java.util.Optional;

import org.society.entities.Admin;
import org.society.exceptions.AdminNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.society.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdminDao {

	@Autowired
	AdminRepo admin;

	@Transactional(readOnly = true)
	public Optional<Admin> login(String emailId, String password) throws AdminNotFoundException, WrongCredentialsException{
		Optional<Admin> a = admin.getByEmailId(emailId);
		if(a.isPresent()) {
			if(password.equals(admin.readLoginData(emailId)))
				return a;
			else
				throw new WrongCredentialsException();
		}
		else
		{
			throw new AdminNotFoundException();
		}

	}

}
