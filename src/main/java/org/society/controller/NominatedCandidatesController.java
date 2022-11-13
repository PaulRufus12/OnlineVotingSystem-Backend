package org.society.controller;

import java.util.List;

import org.society.entities.NominatedCandidates;
import org.society.service.NominatedCandidatesSreviceImpl;
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
@RequestMapping("/candidates")
public class NominatedCandidatesController {
	@Autowired
	NominatedCandidatesSreviceImpl service;

	public void setNominatedCandidatesService(NominatedCandidatesSreviceImpl service)
	{
		this.service=service;
	}

	@GetMapping(value="/all",produces="application/json")
	public ResponseEntity<List<NominatedCandidates>> getCandidates()
	{
		return new ResponseEntity<List<NominatedCandidates>>(service.viewNominatedCandidatesList(),HttpStatus.OK);
	}


	@GetMapping(value="/{candidateId}",produces="application/json")
	public ResponseEntity<NominatedCandidates> searchByCandidateId(@PathVariable("candidateId")Integer candidateId){
		NominatedCandidates nominatedcandidate = null;

		nominatedcandidate = service.searchByCandidateId(candidateId);

		if(nominatedcandidate==null) {
			System.out.println("user not found");
			return new ResponseEntity("Sorry! Candidate not found!",HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<NominatedCandidates>(nominatedcandidate, HttpStatus.OK);
	}

	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addNominatedCandidate(@RequestBody NominatedCandidates candidate)
	{
		service.addNominatedCandidate(candidate);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping(produces="application/json")
	public ResponseEntity<HttpStatus> modifyNominatedCandidate(@RequestBody NominatedCandidates candidate)
	{
		boolean a=false;

		a=service.updateNominatedCandidateDetails(candidate);

		if(a==false)
		{
			System.out.println("Candidate not found to modify");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}


	@DeleteMapping(value="/{candidateId}")
	public ResponseEntity<HttpStatus> deleteNominatedCandididate(@PathVariable("candidateId")Integer candidateId)
	{
		boolean a= false;

		a=service.deleteNominatedCandididate(candidateId);

		if(a==false)
		{
			System.out.println("Candidate not found to delete");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}

}


