package org.society.service;

import java.util.List;

import org.society.entities.VotedList;
import org.society.exceptions.VoterNotFoundException;

public interface VotedListService {
	public void castVotedList(VotedList votedList);
	public boolean updateVotedListDetails(VotedList votedList) throws VoterNotFoundException ;
	public boolean deletedVotedListDetails(int id) throws VoterNotFoundException;
	public List<VotedList> viewVotedList();
	public VotedList searchByVoterId(int voterId) throws VoterNotFoundException;
	
}
