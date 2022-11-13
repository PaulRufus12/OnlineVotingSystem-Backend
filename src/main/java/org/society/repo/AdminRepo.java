package org.society.repo;

import java.util.Optional;

import org.society.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	@Query(value = "select e.password from Admin e where e.emailId=?1")
	public String readLoginData(String emailId);
	
	@Query(value = "select e from Admin e where e.emailId=:emailId")
	public Optional<Admin> getByEmailId(@Param("emailId")String emailId);
}
