package org.society.repo;

import java.util.Optional;

import org.society.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegisteredSocietyVotersRepo extends JpaRepository<RegisteredSocietyVoters, Integer> {
	
	@Query(value = "select v.password from RegisteredSocietyVoters v where v.emailId=?1")
	public String readLoginData(String emailId);
	
	@Query(value = "select v from RegisteredSocietyVoters v where v.emailId=:emailId")
	public Optional<RegisteredSocietyVoters> getByEmailId(@Param("emailId")String emailId);
}