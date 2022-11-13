package org.society.controller;

import java.util.List;
import java.util.Optional;

import org.society.entities.ElectionOfficer;
import org.society.service.ElectionOfficerServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/electionofficer")
public class ElectionOfficerController {

	@Autowired
	ElectionOfficerServiceImpl electionimpl;

	public void setElectionimpl(ElectionOfficerServiceImpl electionimpl)
	{
		this.electionimpl=electionimpl;
	}

	@GetMapping(value="/all",produces="application/json")
	public ResponseEntity<List<ElectionOfficer>> getElectionOfficerList()
	{
		return new ResponseEntity<List<ElectionOfficer>>(electionimpl.viewElectionOfficerList(),HttpStatus.OK);
	}

	@GetMapping(value="/{officerId}",produces="application/json")
	public ResponseEntity<ElectionOfficer> findOfficer(@PathVariable("officerId")int officerId){

		ElectionOfficer officer = null;

		officer = electionimpl.viewElectionOfficerById(officerId);

		if(officer==null) {
			System.out.println("officer not found");
			return new ResponseEntity("Sorry! Officer not found!",HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ElectionOfficer>(officer, HttpStatus.OK);
	}

	@PostMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> addUser(@RequestBody ElectionOfficer officer)
	{
		electionimpl.addElectionOfficerDetails(officer);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping(consumes="application/json")
	public ResponseEntity<HttpStatus> modifyUser(@RequestBody ElectionOfficer officer)
	{
		boolean a=false;

		a=electionimpl.updateElectionOfficerDetails(officer);

		if(a==false)
		{
			System.out.println("officer not found to modify");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping(value="/{officerId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("officerId")Integer offierId)
	{
		boolean a= false;

		a=electionimpl.deleteElectionOfficer(offierId);

		if(a==false)
		{
			System.out.println("officer not found to delete");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<ElectionOfficer> login(@RequestParam String emailId,@RequestParam String password)
	{
		Optional<ElectionOfficer> eo = electionimpl.login(emailId,password);
		if(eo!=null)
			return new ResponseEntity<ElectionOfficer>(eo.get(),HttpStatus.OK);
		else
			return new ResponseEntity("Sorry! Officer not found! check the credentials",HttpStatus.NOT_ACCEPTABLE);
	}

}
