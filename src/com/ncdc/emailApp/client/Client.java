package com.ncdc.emailApp.client;

public interface Client {

	void sendEmail(String name, String surname, String phone, String email, boolean newsletter);
}
