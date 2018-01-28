package org.accolite.ACL.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.accolite.ACL.model.ApplicationUserPrivilege;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;
import org.accolite.DAO.ApplicationUserObjectPrivilegeDao;
import org.accolite.DAO.ApplicationUserPrivilegeDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationUserPrivilegeService {

	@RequestMapping(value = "/addUserPri", method = RequestMethod.POST) 
	public @ResponseBody String addAppUserPrivilege(@RequestBody Map<String,String> aMap) 
	{
		return ApplicationUserPrivilegeDao.addApplicationUserPrivilege(aMap);	
	}
	
	@RequestMapping(value = "/showAppUser", method = RequestMethod.GET) 
	public @ResponseBody List<User> viewAppUser(@RequestBody Map<String,String> aMap) 
	{
		return ApplicationUserPrivilegeDao.getUsersByApplication(Integer.parseInt(aMap.get("applicationId")));
	}
	
	@RequestMapping(value = "/showUserPri", method = RequestMethod.GET) 
	public @ResponseBody Privilege viewAppUserPrivilege(@RequestBody Map<String,String> aMap) 
	{
		return ApplicationUserPrivilegeDao.getUserPrivilegeByApplication(Integer.parseInt(aMap.get("applicationId")),Integer.parseInt(aMap.get("UserId")));
	}
	
	//Show user
	//To return map
	//Request Application
	//Return UserName,Privilege
	
}
