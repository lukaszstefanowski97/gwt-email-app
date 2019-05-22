package com.ncdc.emailApp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.ncdc.emailApp.client.service.Service;

public class ServiceImpl extends RemoteServiceServlet implements Service{
	
	private String nameFromClient;
	private String surnameFromClient;
	private String phoneFromClient;
	private String emailFromClient;

	
	@Override
	public void setName(String name) {
		nameFromClient = name;
	}

	@Override
	public void setSurname(String surname) {
		surnameFromClient = surname;
	}

	@Override
	public void setPhone(String phone) {
		phoneFromClient = phone;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		emailFromClient = emailAddress;
	}

	@Override
	public void sendEmail() {
		
	}
}
