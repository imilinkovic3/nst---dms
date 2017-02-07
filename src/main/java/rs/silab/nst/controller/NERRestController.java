package rs.silab.nst.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import rs.silab.nst.model.User;
import rs.silab.nst.service.RoleService;
import rs.silab.nst.service.UserService;

import javax.annotation.Resource;
import java.time.Clock;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/nst")
@Scope("session")
//@SessionAttributes("http")
public class NERRestController {

    @Resource(name = "roleService")
    RoleService roleService;

    @Resource(name = "userService")
    UserService userService;


    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;



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

    @RequestMapping(value = {"/confrimregistration/"}, method = RequestMethod.POST)
    public String confrimRregistration(@Validated User user, BindingResult result) {
        System.out.println(user);

        try {
            sendConfirmationEmail();

        } catch (MessagingException e) {
            e.printStackTrace();}

        return "confrim_registration";
    }

    public void sendConfirmationEmail() throws AddressException, MessagingException {

              // Step1
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            // Step2
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("imilinkovic3@gmail.com"));
            int code = (int)Math.round(Math.random()*10000);

            generateMailMessage.setSubject("Register confirmation");
            String emailBody = "Please, confirm your registretion with folowing code "+ code;
            generateMailMessage.setContent(emailBody, "text/html");

            // Step3
            Transport transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com","nstprojekat@gmail.com", "nstprojekat2017");


        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

        transport.close();

           System.out.println("\n\n ===> Email sent successfully");

        }
        }
