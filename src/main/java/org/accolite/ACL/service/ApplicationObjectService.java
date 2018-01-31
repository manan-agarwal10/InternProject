package org.accolite.ACL.service;

import java.util.List;

import org.accolite.ACL.DAO.ApplicationObjectDao;
import org.accolite.ACL.model.Application;
import org.accolite.ACL.model.ApplicationObject;
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
	public @ResponseBody String addObject(@RequestBody ApplicationObject ao) {
		return ApplicationObjectDao.save(ao);
	}
	

	
	@RequestMapping(value = "/removeObj", method = RequestMethod.PUT)
	public @ResponseBody String deleteApplicationObject(@RequestBody int objid) {
		return ApplicationObjectDao.delete(objid);
	}
	
	@RequestMapping(value = "/removeObjByName", method = RequestMethod.PUT)
	public @ResponseBody String deleteApplicationObject(@RequestBody String objPath) {
		return ApplicationObjectDao.delete(objPath);
	}
	
	
	@RequestMapping(value = "/getAllObj", method = RequestMethod.POST)
	public @ResponseBody List<ApplicationObject>  getAllObject(@RequestBody Application app) {
		return ApplicationObjectDao.getObjectByApplication(app);
	}
}
