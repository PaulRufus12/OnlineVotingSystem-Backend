package org.society.service;

import java.util.List;

import org.society.dao.NominatedCandidatesDao;
import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NominatedCandidatesSreviceImpl implements NominatedCandidatesService {

	@Autowired
	NominatedCandidatesDao service;

	@Override
	public void addNominatedCandidate(NominatedCandidates candidate) {
		service.addNominatedCandidate(candidate);
	}

	@Override
	public boolean updateNominatedCandidateDetails(NominatedCandidates candidate) {
		boolean a=false;
		try
		{
			a=service.updateNominatedCandidateDetails(candidate);
		}catch(NominatedCandidateNotFoundException ex)
		{
			System.out.println("Candidate not found to Update");
		}
		return a;
	}

	@Override
	public boolean deleteNominatedCandididate(int candidateId) {

		boolean a =false;
		try
		{
			a = service.deleteNominatedCandididate(candidateId);
		}catch(NominatedCandidateNotFoundException ex)
		{
			System.out.println("error in deleting Candidate");
		}

		return a;
	}

	@Override
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		return service.viewNominatedCandidatesList();
	}

	@Override
	public NominatedCandidates searchByCandidateId(int id) {

		NominatedCandidates found = null;
		try
		{
			found = service.searchByCandidateId(id);
		}catch(NominatedCandidateNotFoundException ex)
		{
			System.out.println("Candidate not found");
		}

		return found;
	}

}


