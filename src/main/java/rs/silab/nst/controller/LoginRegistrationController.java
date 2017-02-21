package rs.silab.nst.controller;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.silab.nst.model.Role;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String start(ModelMap model, HttpSession session) {
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("user", new User());
        return "prijavi_se";
    }

    @RequestMapping(value = "/logout/", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if (session.getAttribute("sessionUser") == null) {
            return "redirect:/nst/";
        }

        session.invalidate();
        return "redirect:/nst/";
    }

    @RequestMapping(value = {"/register/"}, method = RequestMethod.POST)
    public String register(@Validated User user, HttpServletRequest request, ModelMap model, HttpSession session) {
        if (session.getAttribute("sessionUser") == null) {
            return "redirect:/nst/";
        }

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

        return "redirect:/nst/";
    }

    @RequestMapping(value = {"/login/"}, method = RequestMethod.POST)

    public String login(@Validated User user, BindingResult result, ModelMap model, HttpSession session) {
        User u = userService.findByUsername(user);
        session.setAttribute("sessionUser", u);

        if (u != null && u.getPassword().equals(user.getPassword())) {
            System.out.println("usao");
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("roles", roleService.findAllRoles());
            model.addAttribute("currentUser", u);

            for (Role role : u.getRoles()) {
                if (role.getName().equalsIgnoreCase("admin")) {

                    System.out.println("usao 2");
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
    public String login(@RequestBody Integer id, Model model, HttpSession session) throws IOException {
        if (session.getAttribute("sessionUser") == null) {
            return "redirect:/nst/";
        }
        model.addAttribute("user", new User());
        userService.deleteUser(id);
        return "homepage_admin";
    }
}