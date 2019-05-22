package com.ncdc.emailApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.ncdc.emailApp.client.service.Service;
import com.ncdc.emailApp.client.service.ServiceAsync;

public class ClientImpl implements Client {

	private ServiceAsync service;
	private MainGUI maingui;
	int correctFields = 0;
	
	public ClientImpl(String url) {
		System.out.println(url);
		this.service = GWT.create(Service.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		this.maingui = new MainGUI(this);
	}
	
	public MainGUI getMainGUI() {
		return this.maingui;
	}

	@Override
	public void setName(String name) {
		this.service.setName(name, new NameCallback());
	}
	
	@Override
	public void setSurname(String surname) {
		this.service.setSurname(surname, new SurnameCallback());
	}

	@Override
	public void setPhone(String phone) {
		this.service.setPhone(phone, new PhoneCallback());
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.service.setEmailAddress(emailAddress, new EmailAddressCallback());
	}

	@Override
	public void sendEmail() {
		if (correctFields >= 4) {
			this.service.sendEmail(new SendEmailCallback());
		}
	}
	
	public class NameCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof String) {
				++correctFields;
				String message = result.toString().length() >= 2 ? "Name saved" : "Invalid input";
				maingui.updateNameResult(message);
			} else {
				String message = "Invalid input";
				maingui.updateNameResult(message);
			}
		}
	}
	
	public class SurnameCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof String) {
				++correctFields;
				String message = result.toString().length() >= 2 ? "Surname saved" : "Invalid input";
				maingui.updateSurnameResult(message);
			} else {
				String message = "Invalid input";
				maingui.updateSurnameResult(message);
			}
		}
	}
	
	public class PhoneCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof Long) {
				++correctFields;
				String message = result.toString().length() >= 2 ? "Phone number saved" : "Invalid input";
				maingui.updatePhoneResult(message);
			} else {
				String message = "Invalid input";
				maingui.updatePhoneResult(message);
			}
		}
	}
	
	public class EmailAddressCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			if (result instanceof String) {
				++correctFields;
				String message = result.toString().contains("@") ? "Email address saved" : "Invalid input";
				maingui.updateEmailResult(message);
			} else {
				String message = "Invalid input";
				maingui.updateEmailResult(message);
			}
		}
	}
	
	public class SendEmailCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			
		}
	}
}
