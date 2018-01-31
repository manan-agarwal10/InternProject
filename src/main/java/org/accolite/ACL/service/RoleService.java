package org.accolite.ACL.service;

import java.util.List;

import org.accolite.ACL.DAO.RoleDao;
import org.accolite.ACL.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleService {

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public @ResponseBody String addRole(@RequestBody Role r) {
		System.out.println(r.getRoleId() + r.getRoleName());
		return RoleDao.save(r);
		
	}
	
	@RequestMapping(value = "/viewRoles", method = RequestMethod.GET)
	public @ResponseBody List<Role> viewRole() {
		return RoleDao.getAllRoles();
	}
	
	@RequestMapping(value = "/removeRoles", method = RequestMethod.POST)
	public @ResponseBody String removeRole(@RequestBody Role r) {
		System.out.println(r.getRoleId() + r.getRoleName());
		return RoleDao.delete(r.getRoleName());
	}

}
