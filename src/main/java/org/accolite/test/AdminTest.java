package org.accolite.test;

import static org.junit.Assert.assertFalse;

import org.accolite.ACL.DAO.AdminDao;
import org.accolite.ACL.model.Admin;
import org.accolite.ACL.service.LoginCredential;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class AdminTest {

	@Test
	public void checkAdmin() {
		LoginCredential lc=new LoginCredential();
		Admin ad=Mockito.mock(Admin.class);
		Mockito.when(ad.getAdminName()).thenReturn("testAdmin");
		Mockito.when(ad.getAdminPassword()).thenReturn("111");
		assertFalse(lc.checkLogin(ad));
	}
	
	@Test
	@Transactional
	public void addAdminTest() 
	{
		//LoginCredential lc=new LoginCredential();
		Admin ad=Mockito.mock(Admin.class);
		Mockito.when(ad.getAdminName()).thenReturn("testAdmin3");
		Mockito.when(ad.getAdminPassword()).thenReturn("111");
		AdminDao.save(ad);
		//assertTrue(lc.checkLogin(ad));
		//AdminDao.delete("testAdmin2");
	}
}
