package org.society.repo;

import java.util.Optional;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElectionOfficerRepo extends JpaRepository<ElectionOfficer, Integer> {

	public ElectionOfficer searchByEmailId(String emailId) throws ElectionOfficerNotFoundException;

	@Query(value = "select e.password from ElectionOfficer e where e.emailId=?1")
	public String readLoginData(String emailId);
	
	@Query(value = "select e from ElectionOfficer e where e.emailId=:emailId")
	public Optional<ElectionOfficer> getByEmailId(@Param("emailId")String emailId);
}
 