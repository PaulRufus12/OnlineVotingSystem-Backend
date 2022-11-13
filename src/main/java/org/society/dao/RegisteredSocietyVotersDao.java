package org.society.dao;

import java.util.List;
import java.util.Optional;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.society.repo.RegisteredSocietyVotersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
public class RegisteredSocietyVotersDao {

	@Autowired
	RegisteredSocietyVotersRepo dao ;

	public void setDao(RegisteredSocietyVotersRepo dao) {
		this.dao = dao;
	}

	@Transactional
	public void voterRegistration(RegisteredSocietyVoters voter)
	{
		dao.save(voter);

	}

	@Transactional
	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter) throws VoterNotFoundException
	{
		boolean a = false;

		if(dao.existsById(voter.getId()))
		{
			dao.save(voter);
			a = true;
		}

		else 
			throw new VoterNotFoundException();

		return a;

	}

	@Transactional
	public boolean deleteRegisteredVoter(int voterId) throws VoterNotFoundException
	{
		boolean a =  false;

		if(dao.existsById(voterId))
		{
			dao.deleteById(voterId);
			a = true;
		}

		else
			throw new VoterNotFoundException();

		return a;

	}

	@Transactional(readOnly =  true)
	public List<RegisteredSocietyVoters> viewRegisteredVoterList()
	{
		return dao.findAll();

	}

	@Transactional(readOnly =  true)
	public RegisteredSocietyVoters searchByVoterID(int voterId) throws VoterNotFoundException
	{
		RegisteredSocietyVoters voters = null;

		if(dao.existsById(voterId))
			voters = dao.findById(voterId).get();

		else
			throw new VoterNotFoundException();

		return voters;

	}

	@Transactional(readOnly = true)
	public Optional<RegisteredSocietyVoters> login(String emailId, String password) throws WrongCredentialsException,VoterNotFoundException {
		Optional<RegisteredSocietyVoters> voter = dao.getByEmailId(emailId);
		if(voter.isPresent()) {
			if(password.equals(dao.readLoginData(emailId)))
				return voter;
			else
				throw new WrongCredentialsException();
		}
		else
		{
			throw new VoterNotFoundException();
		}
	}

}
