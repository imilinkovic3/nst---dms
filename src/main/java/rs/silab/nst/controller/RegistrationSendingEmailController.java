package rs.silab.nst.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rs.silab.nst.email.Email;
import rs.silab.nst.email.EmailConfiguration;
import rs.silab.nst.email.EmailService;
import rs.silab.nst.model.User;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@Scope("session")
@RequestMapping("/nst")
public class RegistrationSendingEmailController {

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = {"/confirmregistration/"}, method = RequestMethod.POST)
    public String confrimRregistration(@RequestBody User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        if (session.getAttribute("sessionUser") == null) {
            return "redirect:/nst/";
        }

        try {
            User doubleUser = userService.findByEmail(user);
            if (doubleUser != null) {
                response.setStatus(400);
                return "prijavi_se";
            }
            sendConfirmationEmail(request);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "prijavi_se";
        }
        return "confirm_registration";
    }

    @RequestMapping(value = {"/forgetpassword/"}, method = RequestMethod.POST)
    public String forgetPassword(@RequestParam("emailOrUsername") String emailOrUsername, @ModelAttribute("user") User employee, HttpSession session) {
        if (session.getAttribute("sessionUser") == null) {
            return "redirect:/nst/";
        }

        // Mora da stoji modelAttribute u ulaznim parametrima! Ne brisati!
        User user = new User();
        user.setEmail(emailOrUsername);
        user.setUsername(emailOrUsername);
        User foundUser = userService.findByEmail(user);
        if (foundUser == null) {
            foundUser = userService.findByUsername(user);
        }
        if (foundUser == null) {
            return "prijavi_se";
        }

        try {
            sendResetPasswordEmail(foundUser);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "prijavi_se";
        }

        return "prijavi_se";
    }

    private void sendResetPasswordEmail(User user) throws AddressException, MessagingException {
        EmailConfiguration configuration = new EmailConfiguration();
        configuration.setProperty(EmailConfiguration.SMTP_HOST, "smtp.gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH, "true");
        configuration.setProperty(EmailConfiguration.SMTP_TLS_ENABLE, "true");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_USER, "nstprojekat@gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_PWD, "nstprojekat2017");
        EmailService emailService = new EmailService(configuration);

        Email email = new Email();
        email.setFrom("kuzma.fon@gmail.com");
        email.setTo(user.getEmail());
        email.setSubject("Register confirmation");
        email.setText("Your username is: " + user.getUsername() + " ,and your password is: " + user.getPassword());
        email.setMimeType("text/html");
        emailService.sendEmail(email);
    }

    public void sendConfirmationEmail(HttpServletRequest request) throws AddressException, MessagingException {
        EmailConfiguration configuration = new EmailConfiguration();
        configuration.setProperty(EmailConfiguration.SMTP_HOST, "smtp.gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH, "true");
        configuration.setProperty(EmailConfiguration.SMTP_TLS_ENABLE, "true");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_USER, "nstprojekat@gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_PWD, "nstprojekat2017");
        EmailService emailService = new EmailService(configuration);

        Email email = new Email();
        email.setFrom("kuzma.fon@gmail.com");
        email.setTo("kuzma.fon@gmail.com");

        int confirmationCode = (int) Math.round(Math.random() * 10000);

        request.getSession().setAttribute("confirmationcode", confirmationCode);

        email.setSubject("Register confirmation");
        email.setText("Please, confirm your registretion with folowing code " + confirmationCode);
        email.setMimeType("text/html");

        emailService.sendEmail(email);
    }
}