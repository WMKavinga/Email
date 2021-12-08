package com.project.emailSender.Service;

import com.project.emailSender.Dao.EmailRepo;
import com.project.emailSender.Model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
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
}
