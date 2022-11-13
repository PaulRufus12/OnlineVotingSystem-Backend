package org.society.service;

import java.util.List;

import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;

public interface ElectionResultService {
	public void addElectionResult(ElectionResult result);
	public List<ElectionResult> viewElectionResultList();
	public ElectionResult viewCandidatewiseResult(int candidateId);
	public double viewVotingPercentage();
	public double viewCandidateVotingPercent(int candidateId);
	public NominatedCandidates viewHighestVotingPercentCandidate();
	public NominatedCandidates viewLowestVotingPercentCandidate();

}
