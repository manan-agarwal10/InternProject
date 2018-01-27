package org.accolite.ACL.service;

import org.accolite.ACL.database.ApplicationDatabase;
import org.accolite.ACL.model.Privilege;
import org.accolite.DAO.PrivilegeDao;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrivilegeService {
	public PrivilegeService() {}
	
	@RequestMapping(value = "/addPri", method = RequestMethod.POST) 
	public @ResponseBody Privilege addPrivilege(@RequestBody Privilege p) 
	{
		System.out.println(p.getPrivilegeId()+""+p.getEdit()+""+p.getView());
		  PrivilegeDao.save(p);
		  return p;
	}
	
	@RequestMapping(value = "/removePri", method = RequestMethod.PUT) 
	public @ResponseBody void deletePrivilege(@RequestBody int pid) 
	{
		PrivilegeDao.delete(pid);
	}
	
}
