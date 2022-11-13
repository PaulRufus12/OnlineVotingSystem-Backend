package org.society;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.society.dao.CooperativeSocietyDao;
import org.society.entities.CooperativeSociety;
import org.society.repo.CooperativeSocietyRepo;
import org.society.service.CooperativeSocietyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CooperativeSocietyTest {

	@Autowired
	CooperativeSocietyServiceImpl service;
	@Autowired
	CooperativeSocietyDao dao;
	@MockBean
	CooperativeSocietyRepo repo;
	@Test
	public void registerSociety()
	{
		CooperativeSociety society = new CooperativeSociety(123,"ZZZ" ,"JOhn","dbpur","mandalal","bangalore","561203");

		Mockito.when(repo.save(society)).thenReturn(society);
		assertEquals(society, service.addSocietyDetails(society));
	}


	@Test
	public void viewUserList()
	{
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new CooperativeSociety(123,"ZZZ" ,"JOhn","dbpur","mandalal","bangalore","561203")
				,new CooperativeSociety(124,"XYZ" ,"JOhn","dbpur","mandalal","bangalore","561203")).collect(Collectors.toList()));

		assertEquals(2,service.viewSocietiesList().size());

	}

}
