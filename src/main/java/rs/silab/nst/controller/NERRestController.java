package rs.silab.nst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/nst")
public class NERRestController {

    @Resource(name = "roleService")
    RoleService roleService;

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(ModelMap model) {
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("user", new User());
        return "prijavi_se";
    }

    @RequestMapping(value = {"/register/"}, method = RequestMethod.POST)
    public String register(@Validated User user, BindingResult result) {
        System.out.println(user);
        userService.saveUser(user);
        return "prijavi_se";
    }


}
