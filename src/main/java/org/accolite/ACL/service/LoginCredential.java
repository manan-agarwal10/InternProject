package org.accolite.ACL.service;

import org.accolite.ACL.model.Admin;
import org.accolite.ACL.model.Application;
import org.accolite.DAO.AdminDao;
import org.accolite.DAO.ApplicationDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginCredential {

	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST) 
	 public @ResponseBody boolean checkLogin(@RequestBody Admin admin) {
	  System.out.println(admin.getAdminId()+admin.getAdminName()+admin.getAdminPassword());
	  return AdminDao.checkAdmin(admin);
	}	
	
	
	
}
