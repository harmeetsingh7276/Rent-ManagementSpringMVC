package org.rentmanagement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "hello";
	}
	
	@RequestMapping(value = "listOfTenants", method = RequestMethod.GET)
	public String listOfTenants(@RequestParam("mobileNumber") String mobileNumber,Model model) {
		model.addAttribute("mobileNumber",mobileNumber);
		return "listOfTenants";
	}
	
}
