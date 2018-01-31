package org.accolite.ACL.service;


import java.util.List;

import org.accolite.ACL.DAO.ApplicationDao;
import org.accolite.ACL.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationService {

	
	
	@RequestMapping(value = "/addApp", method = RequestMethod.POST) 
	 public @ResponseBody String addApplication(@RequestBody Application app) {
	  System.out.println(app.getApplicationId()+app.getApplicationName());
	  return ApplicationDao.save(app);
	  
	 }
	
	@RequestMapping(value = "/removeApp", method = RequestMethod.PUT)
	public void  removeApplication(@RequestBody String appName) {
		  System.out.println(appName);
		  ApplicationDao.delete(appName);
		 }
	
	@RequestMapping(value = "/getAllApp", method = RequestMethod.GET)
	public @ResponseBody List<Application>  getAllApplication() {
		return ApplicationDao.getAllApplication();
	}
	
	
	
	
	
	
	
	
}
