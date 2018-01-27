package org.accolite.ACL.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.accolite.ACL.database.ApplicationDatabase;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationUserPrivilege;
import org.accolite.DAO.ApplicationDao;
import org.accolite.DAO.ApplicationUserPrivilegeDao;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationService {

	public ApplicationService() {
	}
	
	@RequestMapping(value = "/addApp", method = RequestMethod.POST) 
	 public @ResponseBody String addApplication(@RequestBody Application app) {
	  System.out.println(app.getApplicationId()+app.getApplicationName());
	  return ApplicationDao.save(app);
	  
	 }
	
	@RequestMapping(value = "/removeApp", method = RequestMethod.PUT)
	public void  removeApplication(@RequestBody int app) {
		  System.out.println(app);
		  ApplicationDao.delete(app);
		 }
	
	@RequestMapping(value = "/getAllApp", method = RequestMethod.GET)
	public @ResponseBody List<Application>  getAllApplication() {
		return ApplicationDao.getAllApplication();
	}
	
	
	
	
	
	
	
	
}
