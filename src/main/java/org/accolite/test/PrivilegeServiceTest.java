package org.accolite.test;

import static org.junit.Assert.assertEquals;

import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.service.PrivilegeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class PrivilegeServiceTest {

	@Test
	@Transactional
	public void addRemovePrivilegeTest() 
	{
		Privilege p=Mockito.mock(Privilege.class);
		Mockito.when(p.getEdit()).thenReturn(true);
		Mockito.when(p.getView()).thenReturn(true);
		PrivilegeService ps=new PrivilegeService();
		assertEquals("Successfull", ps.addPrivilege(p));
	}
	
	
}
