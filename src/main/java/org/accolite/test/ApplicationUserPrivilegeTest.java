package org.accolite.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.accolite.ACL.DAO.ApplicationUserPrivilegeDao;
import org.accolite.ACL.service.ApplicationUserPrivilegeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class ApplicationUserPrivilegeTest {
	
	@Test
	@Transactional
	public void checkAdd() {
		ApplicationUserPrivilegeService aups=new ApplicationUserPrivilegeService();
		HashMap<String,String> map=new HashMap<>();
		map.put("applicationId", "1");
		map.put("userId", "1");
		map.put("PrivilegeId", "1");
		assertEquals("Successfull",aups.addAppUserPrivilege(map));
	}

}
