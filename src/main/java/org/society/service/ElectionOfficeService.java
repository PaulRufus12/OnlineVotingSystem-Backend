package org.society.service;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionOfficer;

public interface ElectionOfficeService {
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer);
	public boolean updateElectionOfficerDetails(ElectionOfficer officer);
	public boolean deleteElectionOfficer(int officerId);
	public ElectionOfficer viewElectionOfficerById(int officerId);
	public List<ElectionOfficer> viewElectionOfficerList();
	public Optional<ElectionOfficer> login(String emailId,String password);
}
