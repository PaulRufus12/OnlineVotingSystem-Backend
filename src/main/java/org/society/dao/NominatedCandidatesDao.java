package org.society.dao;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.repo.NominatedCandidatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NominatedCandidatesDao {

	@Autowired
	NominatedCandidatesRepo repo;

	public void setNominatedCandidatesDao(NominatedCandidatesRepo nominatedcandidatedao)
	{
		this.repo=nominatedcandidatedao;
	}

	@Transactional
	public void addNominatedCandidate(NominatedCandidates candidate) {
		repo.save(candidate);
	}

	@Transactional
	public boolean updateNominatedCandidateDetails(NominatedCandidates candidate)
			throws NominatedCandidateNotFoundException {
		boolean a=false;

		if(repo.existsById(candidate.getCandidateId()))
		{
			repo.save(candidate);
			a=true;
		}

		else 
			throw new NominatedCandidateNotFoundException();
		return a;

	}


	@Transactional
	public boolean deleteNominatedCandididate(int candidateId) throws NominatedCandidateNotFoundException {
		boolean a=false;

		NominatedCandidates nominatedCandidate=repo.searchByCandidateId(candidateId);
		if(nominatedCandidate!=null)
		{
			System.out.println("candidate found : "+candidateId);
			repo.delete(nominatedCandidate);
			a=true;
		}

		else
			throw new NominatedCandidateNotFoundException();

		return a;

	}

	@Transactional(readOnly=true)
	public List<NominatedCandidates> viewNominatedCandidatesList() {
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	public NominatedCandidates searchByCandidateId(int id) throws NominatedCandidateNotFoundException {
		NominatedCandidates candidate=null;

		if(repo.existsById(id))
			candidate=repo.findById(id).get();

		else 
			throw new NominatedCandidateNotFoundException();

		return candidate;
	}
}

