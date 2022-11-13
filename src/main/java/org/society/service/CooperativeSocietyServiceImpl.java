package org.society.service;

import java.util.List;

import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.exceptions.SocietyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CooperativeSocietyServiceImpl  implements CooperativeSocietyService{
	@Autowired
	CooperativeSocietyDao societyimpl;

	@Override
	public CooperativeSociety addSocietyDetails(CooperativeSociety society) {
		return societyimpl.addSocietyDetails(society);

	}

	@Override
	public boolean updateSocietyDetails(CooperativeSociety society)   {
		boolean a = false;
		try
		{
			a = societyimpl.updateSocietyDetails(society);

		} catch(SocietyNotFoundException ex)
		{
			System.out.println("Society not found to modify");
		}
		return a;

	}

	@Override
	public boolean deleteSociety(int societyId)  {
		boolean a = false;
		try
		{
			a = societyimpl.deleteSociety(societyId);
		} catch(SocietyNotFoundException ex)
		{
			System.out.println("Society not found to delete");
		}
		return a;
	}

	@Override
	public List<CooperativeSociety> viewSocietiesList() {
		return societyimpl.viewSocietiesList();
	}

	@Override
	public CooperativeSociety viewSocietyById(int societyId) {
		CooperativeSociety found = null;
		try
		{
			found = societyimpl.viewSocietyById(societyId);

		} catch(SocietyNotFoundException ex)
		{
			System.out.println("Society not found");
		}
		return found;


	}

}

