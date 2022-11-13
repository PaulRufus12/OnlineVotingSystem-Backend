package org.society.controller;

import java.util.List;

import org.society.service.ElectionResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.society.entities.ElectionResult;
import org.society.entities.NominatedCandidates;
import org.society.entities.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/electionresult")
public class ElectionResultController {

	@Autowired
	ElectionResultServiceImpl control;

	public void setElectionResult(ElectionResultServiceImpl control)
	{
		this.control=control;
	}

	@GetMapping(value="/viewall",produces="application/json")
	public ResponseEntity<List<ElectionResult>> getResults()
	{
		return new ResponseEntity<List<ElectionResult>>(control.viewElectionResultList(),HttpStatus.OK);
	}

	@GetMapping(value="/viewbyid/{candidateId}",produces="application/json")
	public ResponseEntity<ElectionResult> findUser(@PathVariable("candidateId")int candidateId){
		ElectionResult result = null;

		result = control.viewCandidatewiseResult(candidateId);

		if(result==null) {
			System.out.println("result not found");
			return new ResponseEntity("Sorry! result not found!",HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ElectionResult>(result, HttpStatus.OK);
	}

	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addUser(@RequestBody ElectionResult result)
	{
		control.addElectionResult(result);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping(value="/votingpercentage",produces="application/json")
	public ResponseEntity<String> viewPercentage()
	{
		return new ResponseEntity<String>(String.valueOf(control.viewVotingPercentage()), HttpStatus.OK);
	}

	@GetMapping(value="/votingcandidatepercentage/{candidateId}",produces="application/json")
	public ResponseEntity<String> viewCandidatePercentage(@PathVariable("candidateId")int candidateId)
	{
		return new ResponseEntity<String>(String.valueOf(control.viewCandidateVotingPercent(candidateId)), HttpStatus.OK);
	}

	@GetMapping(value="/highvotingpercentagecandidate",produces="application/json")
	public ResponseEntity<NominatedCandidates> viewHighVotingPercentageCandidate()
	{
		return new ResponseEntity<NominatedCandidates>(control.viewHighestVotingPercentCandidate(),HttpStatus.OK);
	}
	@GetMapping(value="/lowvotingpercentagecandidate",produces="application/json")
	public ResponseEntity<NominatedCandidates> viewLowVotingPercentageCandidate()
	{
		return new ResponseEntity<NominatedCandidates>(control.viewLowestVotingPercentCandidate(),HttpStatus.OK);
	}

}
