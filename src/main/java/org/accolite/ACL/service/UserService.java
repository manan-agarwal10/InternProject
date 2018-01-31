package org.accolite.ACL.service;

import java.util.List;

import org.accolite.ACL.DAO.UserDao;
import org.accolite.ACL.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserService {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody User u) {
		System.out.println(u.getUserId() + u.getUserName() + u.getUserPassword());
		return UserDao.save(u);
		
	}
	
	@RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
	public @ResponseBody List<User> viewUser() {
		return UserDao.getAllUsers();
	}
	
	@RequestMapping(value = "/removeUsers", method = RequestMethod.POST)
	public @ResponseBody String removeUser(@RequestBody User u) {
		System.out.println(u.getUserId() + u.getUserName() + u.getUserPassword());
		return UserDao.delete(u.getUserName());
	}
	
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public @ResponseBody boolean validateUser(@RequestBody User u) {
		System.out.println(u.getUserId() + u.getUserName() + u.getUserPassword());
		return UserDao.checkUser(u);
	}

}
