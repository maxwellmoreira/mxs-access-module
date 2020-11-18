package com.mxs.domain.user.usecase.recover;

import com.mxs.factory.type.RecoveryType;
import com.mxs.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Optional;

@Service
public final class RecoverUseCaseImpl implements RecoverUseCase {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void recoverAccess(final Optional<UserModel> userModelOptional, final RecoveryType recoveryType) {
        try {
            sendEmailWithAttachment();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("@gmail.com");
        helper.setSubject("Testing from Spring Boot");
        helper.setText("<h1>Check attachment for image!</h1>", true);
        helper.addAttachment("android.png", new ClassPathResource("android.png"));
        this.javaMailSender.send(msg);
    }

    private void sendEmailWithoutAttachment() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("@gmail.com");
        simpleMailMessage.setSubject("Testing from Spring Boot");
        simpleMailMessage.setText("Hello World \n Spring Boot Email");
        this.javaMailSender.send(simpleMailMessage);
    }
}