package rs.silab.nst.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import java.io.IOException;

@Controller
@Scope("session")
@RequestMapping("/nst")
public class RegistrationSendingEmailController {

    @Resource(name = "userService")
    UserService userService;

    @RequestMapping(value = {"/confirmregistration/"}, method = RequestMethod.POST)
    public String confrimRregistration(@Validated User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User doubleUser = userService.findByEmail(user.getEmail());
            if (doubleUser != null) {
                response.setStatus(400);
                return "";
            }
            sendConfirmationEmail(request);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "prijavi_se";
        }

        return "confirm_registration";
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
        System.out.println("conf code" + confirmationCode);
        request.getSession().setAttribute("ConfirmationCode", confirmationCode);

        email.setSubject("Register confirmation");
        email.setText("Please, confirm your registretion with folowing code " + confirmationCode);
        email.setMimeType("text/html");

        emailService.sendEmail(email);
    }

}