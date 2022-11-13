package org.society.controller;

import java.util.Optional;
import org.society.entities.Admin;
import org.society.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl admincontrol;
	
	@GetMapping(value = "/login")
	public ResponseEntity<Admin> login(@RequestParam String emailId,@RequestParam String password)
	{
		Optional<Admin> a = admincontrol.login(emailId, password);
	//	System.out.println(a.get);
		if(a!=null)
			return new ResponseEntity<Admin>(a.get(),HttpStatus.OK);
		else
			return new ResponseEntity("Sorry ! Admin not found !!! please check the credentials",HttpStatus.NOT_ACCEPTABLE);
		
	}

}
