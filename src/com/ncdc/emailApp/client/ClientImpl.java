package com.ncdc.emailApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.ncdc.emailApp.client.service.Service;
import com.ncdc.emailApp.client.service.ServiceAsync;

public class ClientImpl implements Client {

	private ServiceAsync service;
	private MainGUI maingui;
	
	public ClientImpl(String url) {
		System.out.println("URL: " + url);
		this.service = GWT.create(Service.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		this.maingui = new MainGUI(this);
	}
	
	public MainGUI getMainGUI() {
		return this.maingui;
	}

	@Override
	public void sendEmail(String name, String surname, String phone, String email) {
			this.service.sendEmail(name, surname, phone, email, new SendEmailCallback());
	}
	
	public class SendEmailCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			maingui.updateSendingResult("Email sent");
		}
	}
}
