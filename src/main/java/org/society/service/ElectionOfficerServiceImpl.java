package org.society.service;

import java.util.List;
import java.util.Optional;

import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.exceptions.ElectionOfficerNotFoundException;
import org.society.exceptions.WrongCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionOfficerServiceImpl implements ElectionOfficeService  {

	@Autowired
	ElectionOfficerDao officerimpl;

	@Override
	public ElectionOfficer addElectionOfficerDetails(ElectionOfficer officer) {
		return officerimpl.addElectionOfficerDetails(officer);

	}

	@Override
	public boolean updateElectionOfficerDetails(ElectionOfficer officer) {
		boolean a=false;
		try
		{
			a=officerimpl.updateElectionOfficerDetails(officer);
		}
		catch(ElectionOfficerNotFoundException ex)
		{
			System.out.println("ElectionOfficer Not Found to Modify");
		}
		return a;
	}

	@Override
	public boolean deleteElectionOfficer(int officerId) {
		boolean a = false;
		try
		{
			a =  officerimpl.deleteElectionOfficer(officerId);
		}catch(ElectionOfficerNotFoundException ex)
		{
			System.out.println("officer not found to delete");
		}

		return a;

	}

	@Override
	public ElectionOfficer viewElectionOfficerById(int officerId) {
		ElectionOfficer officer = null;
		try
		{
			officer = officerimpl.viewElectionOfficerById(officerId);
		}catch(ElectionOfficerNotFoundException ex)
		{
			System.out.println("Election Officer not found");
		}
		return officer;

	}

	@Override
	public List<ElectionOfficer> viewElectionOfficerList() {

		return officerimpl.viewElectionOfficerList();
	}

	@Override
	public Optional<ElectionOfficer> login(String emailId, String password) {
		Optional<ElectionOfficer> officer = null;
		try
		{
			officer = officerimpl.login(emailId, password);
		}
		catch(WrongCredentialsException ex)
		{
			System.out.println("Wrong Credentials");
		}
		catch (ElectionOfficerNotFoundException e) {
			System.out.println("Election Officer not found");
		}
		return officer;
	}

}
