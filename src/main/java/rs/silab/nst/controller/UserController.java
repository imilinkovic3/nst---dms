package rs.silab.nst.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;
import javax.annotation.Resource;
import java.io.IOException;
/**
 * Created by milinkoi on 11.02.2017.
 */
@Controller
@Scope("session")
@RequestMapping("/nst/login")
public class UserController {
    @Resource(name = "roleService")
    RoleService roleService;
    @Resource(name = "userService")
    UserService userService;
    @RequestMapping(value = {"/editUser/"}, method = RequestMethod.POST)
    public String editUser(@RequestBody User user) throws IOException {
        userService.updateUser(user);
        return "homepage_admin";
    }
    @RequestMapping(value = {"/selectedUser/"}, method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody User selectUser(Integer id) {
        User selectedUser = userService.findById(id);
        return selectedUser;
    }
}