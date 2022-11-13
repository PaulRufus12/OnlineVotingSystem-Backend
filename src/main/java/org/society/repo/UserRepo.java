package org.society.repo;

import java.util.Optional;

import org.society.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query(value = "select u.password from User u where u.email=?1")
	public String readLoginData(String email);
	
	@Query(value = "select u from User u where u.email=:emailId")
	public Optional<User> getByEmailId(@Param("emailId")String email);
	
}
