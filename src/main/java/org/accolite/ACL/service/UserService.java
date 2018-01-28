package org.accolite.ACL.service;

import java.util.List;

import org.accolite.ACL.model.Privilege;
import org.accolite.ACL.model.User;
import org.accolite.DAO.PrivilegeDao;
import org.accolite.DAO.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserService {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User u) {
		System.out.println(u.getUserId() + u.getUserName() + u.getUserPassword());
		UserDao.save(u);
		return u;
	}
	
	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public @ResponseBody List<User> viewUser() {
		return UserDao.getAllUsers();
	}
	
	@RequestMapping(value = "/removeUsers", method = RequestMethod.POST)
	public @ResponseBody List<User> removeUser(@RequestBody User u) {
		System.out.println(u.getUserId() + u.getUserName() + u.getUserPassword());
		return UserDao.getAllUsers();
	}

}
