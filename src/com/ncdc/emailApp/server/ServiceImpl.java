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
	
	private String nameFromClient;
	private String surnameFromClient;
	private String phoneFromClient;
	private String emailFromClient;
	private boolean newsletterFromClient;
	private String message;

	@Override
	public void sendEmail(String name, String surname, String phone, String email, boolean newsletter) {
		nameFromClient = name;
		surnameFromClient = surname;
		phoneFromClient = phone;
		emailFromClient = email;
		newsletterFromClient = newsletter;
		message = "\n\nName: " + nameFromClient + "\nSurname: " + surnameFromClient 
				+ "\nPhone number: " + phoneFromClient + "\nEmail address: " + emailFromClient
				+ "\nNewsletter: " + newsletterFromClient;
		System.out.println(message);
		
		String from = "testingemailapp2019@gmail.com";
		String password = "PASSword123";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", from);
        props.put("mail.password", password);
  
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
		  Message msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(from));
		  msg.addRecipient(Message.RecipientType.TO,
		                   new InternetAddress(emailFromClient));
		  msg.setSubject("EmailApp");
		  msg.setText(message);
		  Transport.send(msg);
		  System.out.println("\nEmail sent");
		} catch (AddressException e) {
		  System.out.println("\nAddress Exception");
		} catch (MessagingException e) {
		  System.out.println("\nMessage Exception");
		}
	}
}
