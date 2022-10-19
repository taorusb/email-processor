package com.example.emailprocessor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Config {

	private static String USERNAME;
	private static String PASSWORD;
	private static String HOST;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(HOST);
		mailSender.setPort(587);
		mailSender.setUsername(USERNAME);
		mailSender.setPassword(PASSWORD);
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}

	@Value("${mail.username}")
	public void setMailUsername(String mailUsername) {
		USERNAME = mailUsername;
	}

	@Value("${mail.password}")
	public void setMailPassword(String mailPassword) {
		PASSWORD = mailPassword;
	}

	@Value("${mail.host}")
	public void setMailHost(String mailHost) {
		HOST = mailHost;
	}
}
