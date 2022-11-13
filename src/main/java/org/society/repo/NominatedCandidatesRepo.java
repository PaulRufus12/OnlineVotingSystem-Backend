package org.society.repo;

import org.society.entities.NominatedCandidates;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NominatedCandidatesRepo extends JpaRepository<NominatedCandidates, Integer>{

	public NominatedCandidates searchByCandidateId(int id)throws NominatedCandidateNotFoundException;
}
