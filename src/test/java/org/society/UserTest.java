package org.society;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceConfigurationError;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.runner.RunWith;
import org.society.dao.UserDao;
import org.society.entities.User;
import org.society.exceptions.UserNotFoundException;
import org.society.repo.UserRepo;
import org.society.service.UserService;
import org.society.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootTest
class UserTest {

	@Autowired
	UserServiceImpl service;
	@Autowired
	UserDao dao;
	@MockBean
	UserRepo repo;

	@Test
	public void registerUser()
	{
		User u = new User(77,"pass", "raj", "kumar", "raj@yahoo", "99999");
		Mockito.when(repo.save(u)).thenReturn(u);
		assertEquals(u, service.registerUser(u));
	}

	@Test
	public void viewUserList()
	{

		Mockito.when(repo.findAll()).thenReturn(Stream.of(new User(78,"pass", "raju", "kumar", "raju@yahoo", "99999")
				,new User(79,"pass", "rajesh", "kumar", "rajesh@yahoo", "99999")).collect(Collectors.toList()));
		assertEquals(2,service.viewUserList().size());
	}


}
