package org.accolite.service;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationService {

	public ApplicationService() {
	}
	
	@RequestMapping("/hello")
	@ResponseBody

	public String handlerOne() {
		return "Hello";
	}
}
