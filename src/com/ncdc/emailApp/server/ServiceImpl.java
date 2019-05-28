package com.ncdc.emailApp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ncdc.emailApp.client.service.Service;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceImpl extends RemoteServiceServlet implements Service{

	String from = ""; //please input your email address here
	String password = ""; //please input your password here

	private String generateMessage(String name, String surname, String phone, 
			String email, boolean newsletter) {
		
		return "\n\nName: " + name + "\nSurname: " + surname 
				+ "\nPhone number: " + phone + "\nEmail address: " + email
				+ "\nNewsletter: " + newsletter;
	}
	
	private Properties setUpProperties() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        	props.put("mail.smtp.port", 587);
        	props.put("mail.smtp.auth", "true");
        	props.put("mail.smtp.starttls.enable", "true");
        	props.put("mail.user", from);
        	props.put("mail.password", password);
        	
        return props;
	}
	
	private void transportEmail(Session session, String email, String message) {
		try {
			  Message msg = new MimeMessage(session);
			  msg.setFrom(new InternetAddress(from));
			  msg.addRecipient(Message.RecipientType.TO,
			                   new InternetAddress(email));
			  msg.setSubject("EmailApp");
			  msg.setText(message);
			  Transport.send(msg);
			} catch (AddressException e) {
			  System.out.println("Address exception\n" + e);
			} catch (MessagingException e) {
			  System.out.println("Message exception\n" + e);
			}
	}

	@Override
	public void sendEmail(String name, String surname, String phone, String email, 
			boolean newsletter) {
		
		String message = generateMessage(name, surname, phone, email, newsletter);
		System.out.println(message);
  
		Session session = Session.getDefaultInstance(setUpProperties(), new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		transportEmail(session, email, message);
	}
}
