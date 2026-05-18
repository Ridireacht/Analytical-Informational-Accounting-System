package com.vasiliy.project.service.impl;

import com.vasiliy.project.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;


    @Override
    public void sendNewPassword(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Пароль был сброшен");
        message.setText("Ваш новый пароль: " + password);
        message.setFrom("yorineso@gmail.com");

        mailSender.send(message);
    }
}
