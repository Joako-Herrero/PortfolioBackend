
package com.mjhportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendEmail(String toEmail, String fullName, String subject, String body){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("portfoliomjh@gmail.com");
        message.setTo("joaquinherrero13@gmail.com");
        message.setText(body);
        message.setSubject(subject);
        
        String emailBody = String.format("Sent From: %s,\nThe email of contact is: %s,\n\n%s", fullName, toEmail,body);
        message.setText(emailBody);
        
        mailSender.send(message);
        
        System.out.println("MailSent successfully...");
    }
}
