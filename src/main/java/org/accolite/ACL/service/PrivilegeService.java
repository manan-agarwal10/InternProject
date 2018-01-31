package org.accolite.ACL.service;

import org.accolite.ACL.DAO.PrivilegeDao;
import org.accolite.ACL.model.Privilege;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrivilegeService {
	
	@RequestMapping(value = "/addPri", method = RequestMethod.POST) 
	public @ResponseBody String addPrivilege(@RequestBody Privilege p) 
	{
		System.out.println(p.getPrivilegeId()+""+p.getEdit()+""+p.getView());
		  return PrivilegeDao.save(p);
	}
	
	@RequestMapping(value = "/removePri", method = RequestMethod.PUT) 
	public @ResponseBody void deletePrivilege(@RequestBody int pid) 
	{
		PrivilegeDao.delete(pid);
	}
}
