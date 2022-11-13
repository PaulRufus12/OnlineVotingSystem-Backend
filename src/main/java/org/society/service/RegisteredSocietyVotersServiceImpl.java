package org.society.service;

import java.util.List;
import java.util.Optional;

import org.society.dao.RegisteredSocietyVotersDao;
import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredSocietyVotersServiceImpl implements RegisteredSocietyVotersService {

	@Autowired
	RegisteredSocietyVotersDao voterImpl;

	@Override
	public void voterRegistration(RegisteredSocietyVoters voter) {
		voterImpl.voterRegistration(voter);
	}

	@Override
	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter) 
	{
		boolean a = false;
		try
		{
			a = voterImpl.updateRegisteredVoterDetails(voter);

		} 
		catch(VoterNotFoundException ex)
		{
			System.out.println("voter not found to update");
		}
		return a;
	}

	@Override
	public boolean deleteRegisteredVoter(int VoterId ) 
	{
		boolean a = false;
		try
		{
			a = voterImpl.deleteRegisteredVoter(VoterId);

		} catch(VoterNotFoundException ex)
		{
			System.out.println("voter not found");
		}
		return a;
	}

	@Override
	public List<RegisteredSocietyVoters> viewRegisteredVoterList() 
	{
		return voterImpl.viewRegisteredVoterList();
	}

	@Override
	public RegisteredSocietyVoters searchByVoterID(int voterId) 
	{
		RegisteredSocietyVoters found = null;
		try
		{
			found = voterImpl.searchByVoterID(voterId);
		}
		catch(VoterNotFoundException ex)
		{
			System.out.println("voter not found");
		}
		return found;
	}

	@Override
	public Optional<RegisteredSocietyVoters> login(String emailId, String password) {
		Optional<RegisteredSocietyVoters> voter = null;
		try
		{
			voter = voterImpl.login(emailId, password);
		}
		catch (WrongCredentialsException ex) {
			System.out.println("Wrong Credentials !!!");
		}
		catch (VoterNotFoundException e) {
			System.out.println("Voter Not Found !!!");
		}
		return voter;
	}

}
