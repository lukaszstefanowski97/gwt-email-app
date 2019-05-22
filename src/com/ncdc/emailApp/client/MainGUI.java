package com.ncdc.emailApp.client;

import java.util.LinkedList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class MainGUI extends Composite {
	
	private TextBox nameBox;
	private TextBox surname;
	private TextBox phone;
	private TextBox email;
	private LinkedList <HorizontalPanel> horizontalPanels = new LinkedList<>();
	private VerticalPanel vPanel = new VerticalPanel();
	private Label nameResult = new Label();
	private Label surnameResult = new Label();
	private Label phoneResult = new Label();
	private Label emailResult = new Label();
	private Label sendingResult = new Label();
	private ClientImpl clientImpl;

	public MainGUI(ClientImpl client) {
		initWidget(this.vPanel);
		
		HorizontalPanel hPanelName = new HorizontalPanel();
		this.nameBox = new TextBox();
		hPanelName.add(this.nameBox);
		Button sendNameButton = new Button("Send name");
		sendNameButton.addClickHandler(new NameButtonClickHandler());
		hPanelName.add(sendNameButton);
		nameResult.setText("Type name and click the button");
		horizontalPanels.add(hPanelName);
		
		HorizontalPanel hPanelSurname = new HorizontalPanel();
		this.surname = new TextBox();
		hPanelSurname.add(this.surname);
		Button sendSurnameButton = new Button("Type surname and click the button");
		sendSurnameButton.addClickHandler(new SurnameButtonClickHandler());
		hPanelName.add(sendSurnameButton);
		surnameResult.setText("Click to save the surname");
		horizontalPanels.add(hPanelSurname);
		
		HorizontalPanel hPanelPhone = new HorizontalPanel();
		this.phone = new TextBox();
		hPanelPhone.add(this.phone);
		Button sendPhoneButton = new Button("Send name");
		sendPhoneButton.addClickHandler(new PhoneButtonClickHandler());
		hPanelName.add(sendPhoneButton);
		phoneResult.setText("Type phone number and click the button");
		horizontalPanels.add(hPanelPhone);
		
		HorizontalPanel hPanelEmail = new HorizontalPanel();
		this.email = new TextBox();
		hPanelEmail.add(this.email);
		Button sendEmailAddressButton = new Button("Send name");
		sendEmailAddressButton.addClickHandler(new EmailAddressButtonClickHandler());
		hPanelName.add(sendEmailAddressButton);
		emailResult.setText("Type email address and click the button");
		horizontalPanels.add(hPanelEmail);
		
		HorizontalPanel hPanelNewsletter = new HorizontalPanel();
		RadioButton newsletterButton = new RadioButton("Subuscribe to newsletter");
		newsletterButton.setChecked(true);
		
		HorizontalPanel hPanelSend = new HorizontalPanel();
		Button sendButton = new Button("Send");
		sendButton.addClickHandler(new SendingButtonClickHandler());
		hPanelSend.add(sendButton);
		sendingResult.setText("Click to send your email");
		horizontalPanels.add(hPanelSend);
		
		for (HorizontalPanel hPanel : horizontalPanels) {
			vPanel.add(hPanel);
		}
	}

	public void updateNameResult(String message) {
		nameResult.setText(message);
	}	
	
	public void updateSurnameResult(String message) {
		surnameResult.setText(message);
	}
	
	public void updatePhoneResult(String message) {
		phoneResult.setText(message);
	}
	
	public void updateEmailResult(String message) {
		emailResult.setText(message);
	}
	
	public void updateSendingResult(String message) {
		sendingResult.setText(message);
	}
	
	private class NameButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String name = nameBox.getText();
			clientImpl.setName(name);
		}
	}
	
	private class SurnameButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String surname = nameBox.getText();
			clientImpl.setSurname(surname);
		}
	}
	
	private class PhoneButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String phone = nameBox.getText();
			clientImpl.setPhone(phone);
		}
	}
	
	private class EmailAddressButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String email = nameBox.getText();
			clientImpl.setEmailAddress(email);
		}
	}
	
	private class SendingButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			String message = clientImpl.correctFields >= 4 ? "Email sent" : "You have to fill all of the boxes to send an email";
			updateSendingResult(message);
			clientImpl.sendEmail();
		}
	}
}
