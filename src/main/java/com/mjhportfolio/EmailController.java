
package com.mjhportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins ="**")
public class EmailController {

    @Autowired
    private EmailSenderService SenderService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        String toEmail = emailRequest.getEmailAddress();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();
        String fullName = emailRequest.getFullName();
        
        SenderService.sendEmail(toEmail, fullName,subject, body);

        return "Email sent successfully!";
    }
    @GetMapping("/live")
    public void recibirRequest() {
        // Aquí colocas la lógica que deseas ejecutar cuando se recibe la solicitud
        System.out.println("El Servidor esta Live!");
    }
}
