package com.ncdc.emailApp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface Service extends RemoteService{
	
	void setName(String name);
	void setSurname(String surname);
	void setPhone(String phone);
	void setEmailAddress(String emailAddress);
	void sendEmail();

}
