package org.rentmanagement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "hello";
	}
	
	@RequestMapping(value = "listOfTenants", method = RequestMethod.GET)
	public String listOfTenants(HttpServletRequest request) {
		String mobileNumber=request.getParameter("mobileNumber");
		request.setAttribute("mobileNumber", mobileNumber);
		return "listOfTenants";
	}
	
}
