package rs.silab.nst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
//@Scope("session")
@RequestMapping("/nst/login")
public class UserController {

    @Resource(name = "roleService")
    RoleService roleService;

    @Resource(name = "userService")
    UserService userService;






}
