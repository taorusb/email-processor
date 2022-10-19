package com.example.emailprocessor.service;

public interface MailService {
	void sendEmail(String email, String subject, String text);
}
