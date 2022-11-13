package org.society.dao;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.repo.ElectionResultRepo;
import org.society.repo.NominatedCandidatesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ElectionResultDao  {

	@Autowired
	ElectionResultRepo electiondao;
	
	@Autowired
	NominatedCandidatesRepo cand;
	
	public void setElectionOfficeDao(ElectionResultRepo electiondao)
	{
		this.electiondao=electiondao;
	}
	
	@Transactional
	public void addElectionResult(ElectionResult result)
	{
		electiondao.save(result);
	}
	
	@Transactional
	public List<ElectionResult> viewElectionResultList()
	{
		return electiondao.findAll();
	}
	
	@Transactional
	public ElectionResult viewCandidatewiseResult(int candidateId)
	{
	  List<ElectionResult> results=electiondao.findAll();
	  for (ElectionResult result: results) {
		  if(result.getCandidate().getCandidateId()==candidateId) {
			  return result;
		  }
	  }
	return null;
	}
	
	
	public double viewCandidateVotingPercent(int candidateId) {
		  List<ElectionResult> results=electiondao.findAll();
		  for (ElectionResult result: results) {
			  if(result.getCandidate().getCandidateId()==candidateId) {
				  return result.getCandidateVotesPercentage();
			  }
		  }
		return 0.0;
	}
	
	@Transactional
	public double viewVotingPercentage()
	{
		  double sum=0.0;
		  int count=0;
		  List<ElectionResult> results=electiondao.findAll();
		  for (ElectionResult result: results) {
			   sum=sum+result.getTotalPollingPercentage();
			   count++;
		  }
		  return sum/count;
	}
	
	
	public NominatedCandidates viewHighestVotingPercentCandidate() {

		List<ElectionResult> results=electiondao.findAll();
		double high=results.get(0).getCandidateVotesPercentage();
		NominatedCandidates highVotingNominatedCandidates=results.get(0).getCandidate();
		  for (ElectionResult result: results) {
			  double currentResultPercentage=result.getCandidateVotesPercentage();
			   if ( currentResultPercentage >  high) {
				   high=currentResultPercentage;
				   highVotingNominatedCandidates=result.getCandidate();
			   }
		  }
		  return highVotingNominatedCandidates;
	}
	
	public NominatedCandidates viewLowestVotingPercentCandidate() {
		List<ElectionResult> results=electiondao.findAll();
		double low=results.get(0).getCandidateVotesPercentage();
		NominatedCandidates lowVotingNominatedCandidates=results.get(0).getCandidate();
		  for (ElectionResult result: results) {
			  double currentResultPercentage=result.getCandidateVotesPercentage();
			   if ( currentResultPercentage <  low) {
				   low=currentResultPercentage;
				   lowVotingNominatedCandidates=result.getCandidate();
			   }
		  }
		  return lowVotingNominatedCandidates;
	}
	
}
