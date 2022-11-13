package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.society.repo.ElectionOfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ElectionOfficerDao  {

	@Autowired
	ElectionOfficerRepo electionofficerdao;

	public void setElectionOfficerdao(ElectionOfficerRepo electionofficerdao)
	{
		this.electionofficerdao=electionofficerdao;
	}


	@Transactional
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {
		return electionofficerdao.save(officer);
	}


	@Transactional
	public boolean updateElectionOfficerDetails(ElectionOfficer officer) throws ElectionOfficerNotFoundException {
		boolean a=false;

		ElectionOfficer old = null;

		old = electionofficerdao.findById(officer.getOfficerId()).get();
		if(old!=null)
		{
			electionofficerdao.save(officer);
			a=true;
		}
		else
			throw new ElectionOfficerNotFoundException();

		return a;
	}

	@Transactional
	public boolean deleteElectionOfficer(int officerId) throws ElectionOfficerNotFoundException {
		boolean a = false;

		if(electionofficerdao.existsById(officerId))
		{
			electionofficerdao.deleteById(officerId);
			a = true;
		}
		else
			throw new ElectionOfficerNotFoundException();

		return a;
	}


	public ElectionOfficer viewElectionOfficerById(int officerId) throws ElectionOfficerNotFoundException {

		ElectionOfficer officer = null;

		if(electionofficerdao.existsById(officerId))
			officer = electionofficerdao.findById(officerId).get();

		else
			throw new ElectionOfficerNotFoundException();

		return officer ;
	}


	public List<ElectionOfficer> viewElectionOfficerList() {

		return electionofficerdao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<ElectionOfficer> login(String emailId,String password) throws ElectionOfficerNotFoundException, WrongCredentialsException {
		Optional<ElectionOfficer> e = electionofficerdao.getByEmailId(emailId);
	     if(e.isPresent()) {
	    	 if(password.equals(electionofficerdao.readLoginData(emailId)))
	    		 return e;
	    	 else
	    		 throw new WrongCredentialsException();
	    		 
	     }
	     else 
	     {
	    	 throw new ElectionOfficerNotFoundException();
	     }
	}

}
