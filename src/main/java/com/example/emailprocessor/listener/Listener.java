package com.example.emailprocessor.listener;

import com.example.emailprocessor.dto.User;
import com.example.emailprocessor.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Listener {

	private final MailService mailService;
	private final static String subject = "Welcome to our service!";
	private final static String message = "Welcome %s to our service!";

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group-id}")
	void listen(User user) {
		mailService.sendEmail(user.getEmail(), subject, String.format(message, user.getFirstName()));
	}
}
