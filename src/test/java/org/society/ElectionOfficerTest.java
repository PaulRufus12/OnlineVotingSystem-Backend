package org.society;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.society.dao.ElectionOfficerDao;
import org.society.entities.ElectionOfficer;
import org.society.repo.ElectionOfficerRepo;
import org.society.service.ElectionOfficerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ElectionOfficerTest {
	@Autowired
	ElectionOfficerServiceImpl service;
	@Autowired
	ElectionOfficerDao dao;
	@MockBean
	ElectionOfficerRepo repo;
	@Test
	public void registerSociety()
	{
		ElectionOfficer officer = new ElectionOfficer(99,"ramesh","kumar","rameshk","male","9999","ramesh@gmail.com","address1","address2","bangalore", 561203);
		Mockito.when(repo.save(officer)).thenReturn(officer);

		assertEquals(officer, service.addElectionOfficerDetails(officer));
	}


	@Test
	public void viewUserList()
	{
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new ElectionOfficer(99,"ramesh","kumar","rameshk","male","9999","ramesh@gmail.com","address1","address2","bangalore", 561203)
				,new ElectionOfficer(999,"suresh","kumar","sureshk","male","900999","suresh@gmail.com","address1","address2","bangalore", 561203)).collect(Collectors.toList()));

		assertEquals(2,service.viewElectionOfficerList().size());

	}

}
