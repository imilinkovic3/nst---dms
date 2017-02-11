package rs.silab.nst.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            System.out.println("Code iz sesije: " + request.getSession().getAttribute("confirmationcode"));
            System.out.println("Code koji je korisnik uneo: " + Integer.parseInt(String.valueOf(request.getParameter("code"))));

            int codeFromUser = Integer.parseInt(String.valueOf(request.getParameter("code")));
            int confirmationCode = (Integer) request.getSession().getAttribute("confirmationcode");

            if (codeFromUser != confirmationCode) {
               return "confirm_registration";
            }
        } catch (NumberFormatException e) {
            return "confirm_registration";
        }
        userService.saveUser(user);
        return "homepage_admin";
    }

    @RequestMapping(value = {"/login/"}, method = RequestMethod.POST)
    public String login(@Validated User user, BindingResult result) {
        System.out.println(user);
        User u = userService.findByUsername(user);
        if (u.getPassword().equals(user.getPassword())) {
            if (u.getRoleBean().getName().equalsIgnoreCase("admin")) {
                return "homepage_admin";
            }
            if (u.getRoleBean().getName().equalsIgnoreCase("user")) {
                return "homepage_user";
            }
        }

        return "prijavi_se";
    }
}
