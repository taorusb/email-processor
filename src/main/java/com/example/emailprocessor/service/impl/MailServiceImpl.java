package com.example.emailprocessor.service.impl;

import com.example.emailprocessor.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

	private final JavaMailSender mailSender;
	private static String EMAIL_FROM;

	@Override
	public void sendEmail(String email, String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(EMAIL_FROM);
		mailMessage.setTo(email);
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		mailSender.send(mailMessage);
	}

	@Value("${mail.from}")
	public void setEmailFrom(String emailFrom) {
		EMAIL_FROM = emailFrom;
	}
}
