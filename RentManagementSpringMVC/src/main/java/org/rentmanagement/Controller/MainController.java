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

	@RequestMapping(value = "createTenantPage", method = RequestMethod.GET)
	public ModelAndView createTenantPage() {
		ModelAndView modelAndView = new ModelAndView("createTenantPage");
		return modelAndView;
	}

	// @RequestMapping(value = "listOfTenants", method = RequestMethod.GET)
	// to perform GET request only use
	@GetMapping("listOfTenants")
	public ModelAndView listOfTenants() {
		List<Tenants> lst = new DAO().listTenantsDetails();
		ModelAndView modelAndView = new ModelAndView("listOfTenants");
		modelAndView.addObject("listOfTenants", lst);
		return modelAndView;
	}

	@RequestMapping(value = "createTenant")
	public ModelAndView createTenant(@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("name") String name, @RequestParam("idProof") String idProof,
			@RequestParam("rent") String rent, @RequestParam("deposit") String deposit,
			@RequestParam("dateOfDeposit") String dateOfDeposit, @RequestParam("dateOfLiving") String dateOfLiving) {
		Tenants tenant=new Tenants(mobileNumber, name, idProof, deposit, rent, dateOfDeposit, dateOfLiving);
		new DAO().createTenant(tenant);
		ModelAndView modelAndView = new ModelAndView("listOfTenants");
		return modelAndView;
	}

}
