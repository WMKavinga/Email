package com.project.emailSender.Service;

import com.project.emailSender.Dao.EmailRepo;
import com.project.emailSender.Model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailService {

    @Autowired
    public JavaMailSender mailSender;
    @Autowired
    public EmailRepo emailRepo;

    public void sendSimpleEmail(String toEmail,String subject, String body){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("weerasinghekavinga@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void saveEmail(Email email){
        emailRepo.save(email);
    }

    public List<Email> getEmails(){
        return emailRepo.findAll();
    }

    public void deleteEmail(String id){
        emailRepo.deleteById(id);
    }
}
