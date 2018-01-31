package org.accolite.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.accolite.ACL.DAO.ApplicationDao;
import org.accolite.ACL.DAO.ApplicationObjectDao;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationObject;
import org.accolite.ACL.service.ApplicationObjectService;
import org.accolite.ACL.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class ApplicationObjectServicetest {

	@Test
	@Transactional
	public void checkAddObject() 
	{
		ApplicationObjectService aos=new ApplicationObjectService();
		ApplicationObject ao=Mockito.mock(ApplicationObject.class);
		Application app=Mockito.mock(Application.class);
		Mockito.when(app.getApplicationName()).thenReturn("test");
		ApplicationService as=new ApplicationService();
		as.addApplication(app);
		Mockito.when(ao.getApplicationId()).thenReturn(1);
		Mockito.when(ao.getObjectPath()).thenReturn("test");
		assertEquals(ApplicationObjectDao.SUCCESS, aos.addObject(ao));
		assertEquals(ApplicationObjectDao.SUCCESS,aos.deleteApplicationObject("test"));
		as.removeApplication("test");
	}
	
	
	@Test
	@Transactional
	public void getAllObjectTest() 
	{
		ApplicationObjectService aos=new ApplicationObjectService();
		ApplicationObject ao=Mockito.mock(ApplicationObject.class);
		Application app=Mockito.mock(Application.class);
		Mockito.when(app.getApplicationName()).thenReturn("test");
		
		ApplicationService as=new ApplicationService();
		as.addApplication(app);
		
		Mockito.when(ao.getApplicationId()).thenReturn(ApplicationDao.getApplicationId("test"));
		Mockito.when(ao.getObjectPath()).thenReturn("test");
		aos.addObject(ao);
		assertTrue(aos.getAllObject(app).size()>0);
		aos.deleteApplicationObject("test");
	}
}
