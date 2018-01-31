package org.accolite.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.accolite.ACL.model.User;
import org.accolite.ACL.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class UserServiceTest {
	@Test
	@Transactional
	public void addRemoveUserTest() 
	{
		User u=Mockito.mock(User.class);
		Mockito.when(u.getUserName()).thenReturn("Manan");
		Mockito.when(u.getUserPassword()).thenReturn("111");
		UserService us=new UserService();
		assertEquals("Successfull", us.addUser(u));
		assertTrue(us.validateUser(u));
		assertEquals("Successfull", us.removeUser(u));
	}
	
	@Test
	@Transactional
	public void getAllUserTest() 
	{
		User u=Mockito.mock(User.class);
		Mockito.when(u.getUserName()).thenReturn("Manan");
		Mockito.when(u.getUserPassword()).thenReturn("111");
		UserService us=new UserService();
		assertEquals("Successfull", us.addUser(u));
		assertTrue(us.viewUser().size()>0);
		us.removeUser(u);
	}
}
