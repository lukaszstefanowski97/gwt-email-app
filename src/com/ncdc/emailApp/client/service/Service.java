package com.ncdc.emailApp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface Service extends RemoteService{
	
	void sendEmail(String name, String surname, String phone, String email, boolean newsletter);
}
