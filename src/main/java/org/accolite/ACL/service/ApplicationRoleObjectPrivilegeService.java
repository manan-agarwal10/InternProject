package org.accolite.ACL.service;

import java.util.HashMap;
import java.util.Map;

import org.accolite.ACL.DAO.ApplicationRoleObjectPrivilegeDao;
import org.accolite.ACL.model.Privilege;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationRoleObjectPrivilegeService {
	@RequestMapping(value = "/addObjRolePri", method = RequestMethod.POST) 
	public String addAppObjRolePrivilege(@RequestBody HashMap<String,String> aMap) 
	{
		System.out.println("aall");
		ApplicationRoleObjectPrivilegeDao auop=new ApplicationRoleObjectPrivilegeDao();
		return auop.addRoleObjPri(aMap);
		
	}
	
	@RequestMapping(value = "/showAppRoleObjPri", method = RequestMethod.POST) 
	public @ResponseBody Privilege viewAppObjectRolePri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationRoleObjectPrivilegeDao auop=new ApplicationRoleObjectPrivilegeDao();
		return auop.viewRoleObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/editAppRoleObjPri", method = RequestMethod.POST) 
	public @ResponseBody String editAppObjectRolePri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationRoleObjectPrivilegeDao auop=new ApplicationRoleObjectPrivilegeDao();
		return auop.modifyRoleObjectPrivilege(aMap);
	}
	
	@RequestMapping(value = "/deleteAppRoleObjPri", method = RequestMethod.POST) 
	public @ResponseBody String deleteAppObjectRolePri(@RequestBody Map<String,String> aMap) 
	{
		ApplicationRoleObjectPrivilegeDao auop=new ApplicationRoleObjectPrivilegeDao();
		return auop.removeRoleObjPrivilege(aMap);
	}
	


}
