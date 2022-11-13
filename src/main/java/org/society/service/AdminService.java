package org.society.service;

import java.util.Optional;

import org.society.entities.Admin;

public interface AdminService {

	public Optional<Admin> login(String emailId,String password);
}
