package org.society.controller;

import java.util.List;

import org.society.entities.CooperativeSociety;
import org.society.service.CooperativeSocietyServiceImpl;
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
@RequestMapping("/society")
public class SocietyController {

	@Autowired
	CooperativeSocietyServiceImpl serviceimpl;

	public void setServiceimpl(CooperativeSocietyServiceImpl serviceimpl) {
		this.serviceimpl = serviceimpl;
	}

	@GetMapping(value="/viewall",produces="application/json")
	public ResponseEntity<List<CooperativeSociety>> getCoopSociety()
	{
		return new ResponseEntity<List<CooperativeSociety>>(serviceimpl.viewSocietiesList(),HttpStatus.OK);
	}

	@GetMapping(value="/viewbyid/{societyId}",produces="application/json")
	public ResponseEntity<CooperativeSociety> findSociety(@PathVariable("societyId")Integer societyId){
		CooperativeSociety cop = null;

		cop = serviceimpl.viewSocietyById(societyId);

		if(cop==null) {
			System.out.println("Society not found");
			return new ResponseEntity("Sorry! Society not found !",HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CooperativeSociety>(cop, HttpStatus.OK);
	}

	@PostMapping(value = "/add", consumes="application/json")
	public ResponseEntity<HttpStatus> addSociety(@RequestBody CooperativeSociety cop)
	{
		serviceimpl.addSocietyDetails(cop);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping(value = "/update/{societyId}", consumes="application/json")
	public ResponseEntity<HttpStatus> modifySociety(@PathVariable("societyId")Integer societyId, @RequestBody CooperativeSociety cop)
	{
		boolean a=false;

		a=serviceimpl.updateSocietyDetails(cop);

		if(a==false)
		{
			System.out.println("Society not found to modify");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping(value="/del/{societyId}")
	public ResponseEntity<HttpStatus> deleteSociety(@PathVariable("societyId")Integer societyId)
	{
		boolean a= false;

		a=serviceimpl.deleteSociety(societyId);

		if(a==false)
		{
			System.out.println("Society not found to delete");
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}


}
