package org.accolite.ACL.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.DAO.ApplicationRolePrivilegeDao;
import org.accolite.ACL.model.ApplicationRolePrivilege;
import org.accolite.ACL.model.Privilege;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationRolePrivilegeService {
	private ApplicationRolePrivilegeService() {
	}

	@RequestMapping(value = "/addRolePri", method = RequestMethod.POST) 
	public @ResponseBody String addAppRolePrivilege(@RequestBody HashMap<String,String> aMap) 
	{
		System.out.println(""+aMap);
		return ApplicationRolePrivilegeDao.addApplicationRolePrivilege(aMap);	
	}
	
	@RequestMapping(value = "/showAppRole", method = RequestMethod.POST) 
	public @ResponseBody List<ApplicationRolePrivilege> viewAppRole(@RequestBody Map<String,String> aMap) 
	{
		return ApplicationRolePrivilegeDao.getRolesByApplication(Integer.parseInt(aMap.get("applicationId")));
	}
	
	@RequestMapping(value = "/showRolePri", method = RequestMethod.POST) 
	public @ResponseBody Privilege viewAppRolePrivilege(@RequestBody Map<String,String> aMap) 
	{
		return ApplicationRolePrivilegeDao.getRolePrivilegeByApplication(Integer.parseInt(aMap.get("applicationId")),Integer.parseInt(aMap.get("RoleId")));
	}
	
}
