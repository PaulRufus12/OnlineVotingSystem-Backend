package org.society.service;

import java.util.List;

import org.society.dao.VotedListDao;
import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.VoterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotedListServiceImpl implements VotedListService
{
	@Autowired
	VotedListDao voterimpl;

	@Override
	public void castVotedList(VotedList votedList) {
		voterimpl.castVotedList(votedList);
	}

	@Override
	public boolean updateVotedListDetails(VotedList votedList) {
		boolean a = false;
		try
		{
			a = voterimpl.updateVotedListDetails(votedList);

		} catch(CastedVoteNotFoundException ex)
		{
			System.out.println("error in updating voted list");
			ex.printStackTrace();
			System.out.println("votedlist not found to modify");
		}
		return a;
	}

	@Override
	public boolean deletedVotedListDetails(int id) 
	{
		boolean a = false;
		try
		{
			a= voterimpl.deletedVotedListDetails(id);
		}catch(CastedVoteNotFoundException ex)
		{
			System.out.println("voter not found to delete");
		}
		return a;
	}

	@Override
	public List<VotedList> viewVotedList() {

		return voterimpl.viewVotedList();
	}


	@Override
	public VotedList searchByVoterId(int voterId) 
	{ 
		VotedList found = null;
		try
		{
			found = voterimpl.searchByVoterId(voterId);

		} catch(VoterNotFoundException ex)
		{
			System.out.println("Voter not found");
		}
		return found;

	}


}
