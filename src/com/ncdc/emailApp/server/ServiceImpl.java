package com.ncdc.emailApp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ncdc.emailApp.client.service.Service;

public class ServiceImpl extends RemoteServiceServlet implements Service{
	
	private String nameFromClient;
	private String surnameFromClient;
	private String phoneFromClient;
	private String emailFromClient;

	@Override
	public void sendEmail(String name, String surname, String phone, String email) {
		nameFromClient = name;
		surnameFromClient = surname;
		phoneFromClient = phone;
		emailFromClient = email;
		System.out.println("\n\nName: " + nameFromClient + "\nSurname: " + surnameFromClient 
				+ "\nPhone number: " + phoneFromClient + "\nEmail address" + emailFromClient);
	}
}
