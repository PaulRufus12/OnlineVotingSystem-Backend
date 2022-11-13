package org.society.dao;

import java.util.ArrayList;
import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.entities.User;
import org.society.entities.VotedList;
import org.society.exceptions.CastedVoteNotFoundException;
import org.society.exceptions.NominatedCandidateNotFoundException;
import org.society.exceptions.VoterNotFoundException;
import org.society.repo.VotedListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class VotedListDao 
{
	@Autowired
	VotedListRepo dao;

	public void setDao(VotedListRepo dao) 
	{
		this.dao = dao;
	}

	@Transactional
	public void castVotedList(VotedList votedList)
	{
		dao.save(votedList);

	}

	public boolean updateVotedListDetails(VotedList votedList) throws CastedVoteNotFoundException
	{
		boolean a=false;

		if(dao.findById(votedList.getId())!=null)
		{
			System.out.println("found voter : "+votedList.getId());
			dao.save(votedList);
			a=true;
		}
		else
			throw new CastedVoteNotFoundException();

		return a;
	}

	@Transactional
	public boolean deletedVotedListDetails(int id) throws CastedVoteNotFoundException
	{
		boolean a=false;
		try 
		{	VotedList votedList=dao.searchByVoterId(id);
		if(votedList!=null)
		{
			System.out.println("found voter");
			dao.delete(votedList);
			a=true;
		}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("id  not found");
		}
		return a;

	}

	@Transactional(readOnly = true)
	public List<VotedList> viewVotedList()
	{
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public VotedList searchByVoterId(int voterId) throws VoterNotFoundException
	{
		VotedList list = null;
		try {
			if(dao.existsById(voterId))
				list = dao.findById(voterId).get();
		}
		catch(Exception ex)
		{
			System.out.println(" voter id not found");
		}
		return list;
	}


}
