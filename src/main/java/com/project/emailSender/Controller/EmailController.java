package com.project.emailSender.Controller;

import com.project.emailSender.Model.Email;
import com.project.emailSender.Dao.EmailRepo;
import com.project.emailSender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmailController {


    @Autowired
    public EmailService emailService;

    @PostMapping("/sendEmail")
    public String createEmployee(@ModelAttribute("sendEmail") @RequestBody Email email , Model model){
        emailService.saveEmail(email);
        emailService.sendSimpleEmail(email.getTo(), email.getSubject(), email.getBody());
        model.addAttribute("emails","Email Sent...");
        return "success";
        //return "Email Sent...";
    }

}
