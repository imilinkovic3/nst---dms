package rs.silab.nst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;

@Controller
@RequestMapping("/api/")
public class NERRestController {

	@Autowired
	RoleService roleService;
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//
//		model.addAttribute("message", "Spring 3 MVC Hello World");
//		return "prijavi_se";
//
//	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register(@Validated User user, ModelMap model, BindingResult result) {
		if (result.hasErrors()) {
			return "prijavi_se";
		}
		System.out.println(user);
//		userService.saveUser(user);
		return "businessuser_homepage";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(ModelMap model) {
	model.addAttribute("roles", roleService.findAllRoles());
		model.addAttribute("user", new User());
		return "prijavi_se";
	}


}
