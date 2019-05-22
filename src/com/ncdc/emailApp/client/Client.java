package com.ncdc.emailApp.client;

public interface Client {

	void setName(String name);
	void setSurname(String surname);
	void setPhone(String phone);
	void setEmailAddress(String emailAddress);
	void sendEmail();
}
