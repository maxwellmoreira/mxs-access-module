package com.mxs.factory.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Component
public final class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailWithAttachment(final String email) throws MessagingException, IOException {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Testing from Spring Boot");
        mimeMessageHelper.setText("<h1>Check attachment for image!</h1>", true);
        mimeMessageHelper.addAttachment("android.png", new ClassPathResource("android.png"));
        this.javaMailSender.send(mimeMessage);
    }

    public void sendEmailWithoutAttachment(final String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Testing from Spring Boot");
        simpleMailMessage.setText("Hello World \n Spring Boot Email");
        this.javaMailSender.send(simpleMailMessage);
    }
}