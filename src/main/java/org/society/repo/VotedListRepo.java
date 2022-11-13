package org.society.repo;

import org.society.entities.VotedList;
import org.society.exceptions.VoterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotedListRepo extends JpaRepository<VotedList, Integer> {

 public VotedList searchByVoterId(int voterId) throws VoterNotFoundException;

}
