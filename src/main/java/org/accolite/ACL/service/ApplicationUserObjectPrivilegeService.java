package org.accolite.ACL.service;

import java.util.HashMap;
import java.util.Map;

import org.accolite.ACL.DAO.ApplicationUserObjectPrivilegeDao;
import org.accolite.ACL.model.Privilege;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ApplicationUserObjectPrivilegeService {

	@RequestMapping(value = "/addObjUserPri", method = RequestMethod.POST) 
	public @ResponseBody String addAppObjUserPrivilege(@RequestBody HashMap<String,String> aMap) 
	{
		System.out.println("aall");
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.addUserObjPri(aMap);
		
	}
	
	@RequestMapping(value = "/showAppUserObjPri", method = RequestMethod.POST) 
	public @ResponseBody Privilege viewAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.viewUserObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/editAppUserObjPri", method = RequestMethod.POST) 
	public @ResponseBody String editAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.modifyUserObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/deleteAppUserObjPri", method = RequestMethod.POST) 
	public @ResponseBody String deleteAppObjectUserPri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationUserObjectPrivilegeDao auop=new ApplicationUserObjectPrivilegeDao();
		return auop.removeUserObjPrivilege(aMap);
	}
	
}
