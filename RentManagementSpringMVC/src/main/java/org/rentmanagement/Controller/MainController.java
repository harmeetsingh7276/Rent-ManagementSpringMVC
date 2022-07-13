package org.rentmanagement.Controller;

import java.util.List;

import org.rentmanagement.DAO.DAO;
import org.rentmanagement.model.Tenants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@RequestMapping(value = "createTenantPage", method = RequestMethod.GET)
	public ModelAndView createTenantPage() {
		ModelAndView modelAndView = new ModelAndView("createTenantPage");
		Tenants tenant=new Tenants();
		modelAndView.addObject("tenant",tenant);
		return modelAndView;
	}

	// @RequestMapping(value = "listOfTenants", method = RequestMethod.GET)
	// to perform GET request only use
	@GetMapping("listOfTenants")
	public ModelAndView listOfTenants() {
		List<Tenants> lst = new DAO().listTenantsDetails();
		ModelAndView modelAndView = new ModelAndView("listOfTenants");
		Tenants updateTenant=new Tenants();
		modelAndView.addObject("updateTenant", updateTenant);
		modelAndView.addObject("listOfTenants", lst);
		return modelAndView;
	}

	@PostMapping("createTenant")
	public ModelAndView createTenant(@ModelAttribute Tenants tenant) {
		new DAO().createTenant(tenant);
		ModelAndView modelAndView = new ModelAndView("redirect:listOfTenants");
		return modelAndView;
	}
	@GetMapping("deleteTenant")
	public ModelAndView deleteTenant(@RequestParam("mobileNumber") String mobileNumber ) {
		new DAO().deleteTenant(mobileNumber);
		ModelAndView modelAndView = new ModelAndView("redirect:listOfTenants");
		return modelAndView;
	}
}
