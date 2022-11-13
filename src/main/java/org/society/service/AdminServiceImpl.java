package org.society.service;

import java.util.Optional;
import org.society.dao.AdminDao;
import org.society.entities.Admin;
import org.society.exceptions.AdminNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;

	@Override
	public Optional<Admin> login(String emailId, String password) {
		Optional<Admin> admin = null;
		try
		{
			admin = dao.login(emailId, password);
		}
		catch(WrongCredentialsException ex)
		{
			System.out.println("Wrong Credentials !!!"); 
		}
		catch(AdminNotFoundException e)
		{
			System.out.println("Admin Not Found");
		}
		return admin;
	}

}
