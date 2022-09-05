package com.example.EmailSender.service.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class EmailSenderServiceImpl {

    private final JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public static void senderEmail(String toEmail, String subject, String message) {

        final String fromEmail = "nguyenquangtrinh01102323@gmail.com";
        final String password = "wqwgvqmoxfwivrcn";

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, subject, message);

    }
}
