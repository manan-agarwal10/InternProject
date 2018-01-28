package org.accolite.ACL.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationObject;
import org.accolite.ACL.model.Privilege;
import org.accolite.DAO.ApplicationDao;
import org.accolite.DAO.ApplicationObjectDao;
import org.accolite.DAO.PrivilegeDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ApplicationObjectService {

	public ApplicationObjectService() {
		// Do nothing because of Its a controller.

	}

	@RequestMapping(value = "/addObj", method = RequestMethod.POST)
	public @ResponseBody ApplicationObject addObject(@RequestBody ApplicationObject ao) {
		ApplicationObjectDao.save(ao);
		return ao;
	}
	

	
	@RequestMapping(value = "/removeObj", method = RequestMethod.PUT)
	public @ResponseBody void deleteApplicationObject(@RequestBody int objid) {
		ApplicationObjectDao.delete(objid);
	}
	
	@RequestMapping(value = "/getAllObj", method = RequestMethod.POST)
	public @ResponseBody List<ApplicationObject>  getAllObject(@RequestBody Application app) {
		System.out.println("Service check"+app.getApplicationId());
		return ApplicationObjectDao.getObjectByApplication(app);
	}
}
