package org.accolite.ACL.service;

import java.util.List;
import java.util.Map;

import org.accolite.ACL.model.ApplicationUserPrivilege;
import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;
import org.accolite.DAO.ApplicationUserObjectPrivilegeDao;
import org.accolite.DAO.ApplicationUserPrivilegeDao;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class ApplicationUserObjectPrivilegeService {

	@RequestMapping(value = "/addObjUserPri", method = RequestMethod.POST) 
	public String addAppObjUserPrivilege(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.addUserObjPri(aMap);
		
	}
	
	@RequestMapping(value = "/showAppUserObjPri", method = RequestMethod.GET) 
	public @ResponseBody Privilege viewAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.viewUserObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/editAppUserObjPri", method = RequestMethod.GET) 
	public @ResponseBody String editAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.modifyUserObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/deleteAppUserObjPri", method = RequestMethod.GET) 
	public @ResponseBody String deleteAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.removeUserObjPrivilege(aMap);
	}
	
}
