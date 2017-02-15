package rs.silab.nst.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rs.silab.nst.email.Email;
import rs.silab.nst.email.EmailConfiguration;
import rs.silab.nst.email.EmailService;
import rs.silab.nst.model.User;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("session")
@RequestMapping("/nst")
public class RegistrationSendingEmailController {

    @RequestMapping(value = {"/confrimregistration/"}, method = RequestMethod.POST)
    public String confrimRregistration(@Validated User user, BindingResult result, HttpServletRequest request) {
        try {
           sendConfirmationEmail(request);
           // testMetoda(request);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "prijavi_se";
        }

        return "confirm_registration";
    }

    private void testMetoda(HttpServletRequest request) throws AddressException, MessagingException {

        int confirmationCode = (int) Math.round(Math.random() * 10000);
        System.out.println("conf code"+confirmationCode);
        request.getSession().setAttribute("confirmationcode", confirmationCode);
    }

    public void sendConfirmationEmail(HttpServletRequest request) throws AddressException, MessagingException {
        EmailConfiguration configuration = new EmailConfiguration();
        configuration.setProperty(EmailConfiguration.SMTP_HOST, "smtp.gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH, "true");
        configuration.setProperty(EmailConfiguration.SMTP_TLS_ENABLE, "true");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_USER, "nstprojekat@gmail.com");
        configuration.setProperty(EmailConfiguration.SMTP_AUTH_PWD, "nstprojekat2017");
      //  configuration.setProperty(EmailConfiguration.SMTP_PORT, "587");



        EmailService emailService = new EmailService(configuration);
        Email email = new Email();
        email.setFrom("imilinkovic3@gmail.com");
        email.setTo("imilinkovic3@gmail.com");

        int confirmationCode = (int) Math.round(Math.random() * 10000);
        System.out.println("conf code"+confirmationCode);
        request.getSession().setAttribute("confirmationcode", confirmationCode);

        email.setSubject("Register confirmation");
        email.setText("Please, confirm your registretion with folowing code " + confirmationCode);
        email.setMimeType("text/html");

        emailService.sendEmail(email);
    }

    }