package com.twitterclone.sweater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
	@Autowired
	private JavaMailSender mailSender;
	
	//required for sender specification in setFrom
	@Value("${spring.mail.username}")
	private String username;
	
	//method to send out an email
	public void send(String emailTo, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(); 
		
		mailMessage.setFrom(username);
		mailMessage.setTo(emailTo);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		
		//the actual line that sends mail
		mailSender.send(mailMessage);
	}
}
