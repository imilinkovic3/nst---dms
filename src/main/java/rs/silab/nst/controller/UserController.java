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

/**
 * Created by milinkoi on 11.02.2017.
 */

@Controller
@RequestMapping("/nst/login")
public class UserController {

    @Resource(name = "roleService")
    RoleService roleService;

    @Resource(name = "userService")
    UserService userService;


    @RequestMapping(value = {"/edit/"}, method = RequestMethod.POST)
    public String login(@Validated User user, BindingResult result, ModelMap model) {

    userService.updateUser(user);

        return "homepage_admin";
    }

}
