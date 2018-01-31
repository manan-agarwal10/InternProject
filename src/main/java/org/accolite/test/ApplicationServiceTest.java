package org.accolite.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.accolite.ACL.model.Application;
import org.accolite.ACL.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)

public class ApplicationServiceTest {

	@Test
	@Transactional
	public void  checkSave() 
	{
		Application app=new Application();
		app.setApplicationName("TestApp");
		ApplicationService as=new ApplicationService();
		assertEquals("Successfull",as.addApplication(app));
		as.removeApplication(app.getApplicationName());
	}
	
	
	@Test
	@Transactional
	public void checkGetAll() 
	{
		Application app=new Application();
		app.setApplicationName("TestApp");
		ApplicationService as=new ApplicationService();
		as.addApplication(app);
		assertTrue(as.getAllApplication().size()>0);
		as.removeApplication(app.getApplicationName());
	}
}
