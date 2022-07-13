package org.rentmanagement.Controller;
import java.util.List;

import org.rentmanagement.DAO.DAO;
import org.rentmanagement.model.Tenants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	@RequestMapping(value = "createTenant", method = RequestMethod.GET)
	public ModelAndView createTenant() {
		ModelAndView modelAndView=new ModelAndView("createTenant");
		return modelAndView;
	}
	//@RequestMapping(value = "listOfTenants", method = RequestMethod.GET)
	//to perform GET request only use
	@GetMapping("listOfTenants")
	public ModelAndView listOfTenants() {
		List<Tenants> lst=new DAO().listTenantsDetails();
		ModelAndView modelAndView=new ModelAndView("listOfTenants");
		modelAndView.addObject("listOfTenants", lst);
		return modelAndView;
	}
	
}
