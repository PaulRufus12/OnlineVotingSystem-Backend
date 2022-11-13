package org.society.service;

import java.util.List;

import org.society.entities.CooperativeSociety;

public interface CooperativeSocietyService {
	public CooperativeSociety addSocietyDetails(CooperativeSociety society);
	public boolean updateSocietyDetails(CooperativeSociety society);
	public boolean deleteSociety(int societyId) ;
	public List<CooperativeSociety> viewSocietiesList();
	public CooperativeSociety viewSocietyById(int societyId) ;
}
