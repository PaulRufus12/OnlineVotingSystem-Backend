package org.society.service;

import java.util.List;
import java.util.Optional;

import org.society.entities.RegisteredSocietyVoters;
import org.society.exceptions.VoterNotFoundException;

public interface RegisteredSocietyVotersService {
	public void voterRegistration(RegisteredSocietyVoters voter);
	public boolean updateRegisteredVoterDetails(RegisteredSocietyVoters voter)throws VoterNotFoundException;
	public boolean deleteRegisteredVoter(int voterId)throws VoterNotFoundException;
	public List<RegisteredSocietyVoters> viewRegisteredVoterList();
	public RegisteredSocietyVoters searchByVoterID(int voterId) throws VoterNotFoundException;
	public Optional<RegisteredSocietyVoters> login(String emailId, String password);
}
