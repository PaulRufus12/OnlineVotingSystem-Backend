package org.society.service;

import java.util.List;

import org.society.dao.ElectionResultDao;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ElectionResultServiceImpl implements ElectionResultService {

	@Autowired
	ElectionResultDao service;
	
	@Override
	public void addElectionResult(ElectionResult result) {
		service.addElectionResult(result);
		
	}

	@Override
	public List<ElectionResult> viewElectionResultList() {
		
		return service.viewElectionResultList();
	}

	@Override
	public ElectionResult viewCandidatewiseResult(int candidateId) {
		
		return service.viewCandidatewiseResult(candidateId);
	}

	@Override
	public double viewVotingPercentage() {
		
		return service.viewVotingPercentage();
	}

	@Override
	public double viewCandidateVotingPercent(int candidateId) {
		
		return service.viewCandidateVotingPercent(candidateId);
	}

	

	@Override
	public NominatedCandidates viewHighestVotingPercentCandidate() {
	
		return service.viewHighestVotingPercentCandidate();
	}

	@Override
	public NominatedCandidates viewLowestVotingPercentCandidate() {
	
		return service.viewLowestVotingPercentCandidate();
	}

	
}
