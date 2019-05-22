package com.ncdc.emailApp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAsync {
	
	void setName(String name, AsyncCallback callback);
	void setSurname(String surname, AsyncCallback callback);
	void setPhone(String phone, AsyncCallback callback);
	void setEmailAddress(String emailAddress, AsyncCallback callback);
	void sendEmail(AsyncCallback callback);
}
