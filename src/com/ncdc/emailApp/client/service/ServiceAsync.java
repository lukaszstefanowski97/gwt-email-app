package com.ncdc.emailApp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceAsync {
	
	void sendEmail(String name, String surname, String phone, String email, boolean newsletter,
			AsyncCallback callback);
}
