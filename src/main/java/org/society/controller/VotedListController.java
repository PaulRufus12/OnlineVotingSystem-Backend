package org.society.controller;

import java.util.List;

import org.society.entities.User;
import org.society.entities.VotedList;
import org.society.service.VotedListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/votedlist")
public class VotedListController 
{
	@Autowired
	VotedListServiceImpl serviceimpl;

	public void setcastvoted(VotedListServiceImpl serviceImpl)
	{
		this.serviceimpl = serviceImpl;
	}

	@GetMapping(value="/viewall",produces="application/json")
	public ResponseEntity<List<VotedList>> getVotedList()
	{
		return new ResponseEntity<List<VotedList>>(serviceimpl.viewVotedList(),HttpStatus.OK);
	}

	@GetMapping(value="/viewbyid/{id}",produces="application/json")
	public ResponseEntity<VotedList> findVotedList(@PathVariable("id")Integer id){
		VotedList voted = null;
		try {
			voted = serviceimpl.searchByVoterId(id);
		}catch(Exception ex)
		{
			System.out.println("Voter not found");
		}
		if(voted==null) {
			System.out.println("voter not found");
			return new ResponseEntity("Sorry! voter not found!",HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<VotedList>(voted, HttpStatus.OK);
	}
	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<HttpStatus> addvoter(@RequestBody VotedList voter)
	{
		serviceimpl.castVotedList(voter);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping(value="/update",consumes="application/json")
	public ResponseEntity<HttpStatus> modifyUser(@RequestBody VotedList votedList)
	{
		boolean a=false;

		a=serviceimpl.updateVotedListDetails(votedList);

		if(a==false)
		{
			System.out.println("votedid not found to modify");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping(value="/{Id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("Id")Integer id)
	{
		boolean a= false;
		try {
			a=serviceimpl.deletedVotedListDetails(id);
		}catch(Exception ex)
		{

		}
		if(a==false)
		{
			System.out.println("votedid not found to delete");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}



}
