package org.society.service;

import java.util.List;

import org.society.entities.NominatedCandidates;

public interface NominatedCandidatesService {
	public void addNominatedCandidate(NominatedCandidates candidate);
	public boolean updateNominatedCandidateDetails(NominatedCandidates candidate);
	public boolean deleteNominatedCandididate(int candidateId);
	public List<NominatedCandidates> viewNominatedCandidatesList();
	public NominatedCandidates searchByCandidateId(int id);
}
