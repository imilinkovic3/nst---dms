package rs.silab.nst.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.silab.nst.model.Role;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@Scope("session")
@RequestMapping("/nst")
public class LoginRegistrationController {

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
    public String register(@Validated User user, HttpServletRequest request, ModelMap model) {
        try {
            int codeFromUser = Integer.parseInt(String.valueOf(request.getParameter("code")));
            int confirmationCode = (Integer) request.getSession().getAttribute("confirmationcode");

            if (codeFromUser != confirmationCode) {
                return "confirm_registration";
            }
        } catch (NumberFormatException e) {
            return "confirm_registration";
        }

        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("roles", roleService.findAllRoles());

        //obrisati ovaj if posle
        if (user.getUsername() != "" && user.getUsername() != null)
            userService.saveUser(user);

        return "homepage_admin";
    }

    @RequestMapping(value = {"/login/"}, method = RequestMethod.POST)
    public String login(@RequestBody User user, BindingResult result, ModelMap model) {
        User u = userService.findByUsername(user);
        if (u != null && u.getPassword().equals(user.getPassword())) {
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("roles", roleService.findAllRoles());

            // ???
            for (Role role : u.getRoles()) {
                if (role.getName().equalsIgnoreCase("admin")) {
                    return "homepage_admin";
                }
            }

            for (Role role : u.getRoles()) {
                if (role.getName().equalsIgnoreCase("user")) {
                    return "homepage_user";
                }
            }

            for (Role role : u.getRoles()) {
                if (role.getName().equalsIgnoreCase("processcreator")) {
                    return "homepage_processcreator";
                }
            }
        }

        return "prijavi_se";
    }

    @RequestMapping(value = {"/user/delete/"}, method = RequestMethod.POST)
    public String login(@RequestBody Integer id, Model model) throws IOException {
        model.addAttribute("user", new User());
        userService.deleteUser(id);
        return "homepage_admin";
    }
}