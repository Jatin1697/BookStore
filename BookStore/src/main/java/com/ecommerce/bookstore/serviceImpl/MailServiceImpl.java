package com.ecommerce.bookstore.serviceImpl;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.ecommerce.bookstore.model.Users;
import com.ecommerce.bookstore.service.MailService;

@Service("mailService")
public class MailServiceImpl implements  MailService{

	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail(Users u) {
		// TODO Auto-generated method stub
		 MimeMessagePreparator preparator = getMessagePreparator(u);
		 
	        try {
	            mailSender.send(preparator);
	            System.out.println("Message Send...Hurrey");
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }
	 
	    private MimeMessagePreparator getMessagePreparator(final Users u) {
	 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                mimeMessage.setFrom();
	                mimeMessage.setRecipient(Message.RecipientType.TO,
	                        new InternetAddress(u.getEmail()));
	                mimeMessage.setText("Dear " + u.getUsername()
	                        + ", thank you for registering.");
	                mimeMessage.setSubject("Welcome to bookstore");
	            }
	        };
	        return preparator;
	}

}
