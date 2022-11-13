package org.society.dao;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.entities.User;
import org.society.exceptions.SocietyNotFoundException;
import org.society.repo.CooperativeSocietyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CooperativeSocietyDao  
{

	@Autowired
	private CooperativeSocietyRepo dao;


	public void setDao(CooperativeSocietyRepo dao) {
		this.dao = dao;
	}

	@Transactional
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) 
	{
		return dao.save(society);

	}


	@Transactional 
	public boolean updateSocietyDetails(CooperativeSociety society) throws SocietyNotFoundException {
		boolean a= false;

		if(dao.existsById(society.getSocietyId()))
		{
			dao.save(society);
			a=true;
		}
		else
			throw new SocietyNotFoundException();
		return a;

	}

	@Transactional
	public boolean deleteSociety(int societyId) throws SocietyNotFoundException {
		boolean a=false;

		if(dao.existsById(societyId))
		{
			dao.deleteById(societyId);
			a=true;
		}
		else 
			throw new SocietyNotFoundException();

		return a;

	}

	@Transactional(readOnly = true)
	public List<CooperativeSociety> viewSocietiesList() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public CooperativeSociety viewSocietyById(int societyId) throws SocietyNotFoundException 
	{
		CooperativeSociety soc =  null;

		if(dao.existsById(societyId))
			soc=dao.findById(societyId).get();

		else 
			throw new SocietyNotFoundException();

		return soc;

	}

}