package com.ncdc.emailApp.client;

import java.util.LinkedList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class MainGUI extends Composite {
	
	private TextBox nameBox;
	private TextBox surnameBox;
	private TextBox phoneBox;
	private TextBox emailBox;
	private LinkedList <HorizontalPanel> horizontalPanels = new LinkedList<>();
	private VerticalPanel vPanel = new VerticalPanel();
	private Label nameResult = new Label();
	private Label surnameResult = new Label();
	private Label phoneResult = new Label();
	private Label emailResult = new Label();
	private Label sendingResult = new Label();
	private ClientImpl clientImpl;
	private Validation validation = new ValidationImpl();
	private RadioButton radioButton1;
	private RadioButton radioButton2;

	public MainGUI(ClientImpl client) {
		initWidget(this.vPanel);
		this.clientImpl = client;
		
		HorizontalPanel hPanelName = new HorizontalPanel();
		this.nameBox = new TextBox();
		hPanelName.add(this.nameBox);
		nameResult.setText("Type name");
		hPanelName.add(nameResult);
		horizontalPanels.add(hPanelName);
		
		HorizontalPanel hPanelSurname = new HorizontalPanel();
		this.surnameBox = new TextBox();
		hPanelSurname.add(this.surnameBox);
		surnameResult.setText("Type surname");
		hPanelSurname.add(surnameResult);
		horizontalPanels.add(hPanelSurname);
		
		HorizontalPanel hPanelPhone = new HorizontalPanel();
		this.phoneBox = new TextBox();
		hPanelPhone.add(this.phoneBox);
		phoneResult.setText("Type phone number and click the button");
		hPanelPhone.add(phoneResult);
		horizontalPanels.add(hPanelPhone);
		
		HorizontalPanel hPanelEmail = new HorizontalPanel();
		this.emailBox = new TextBox();
		hPanelEmail.add(this.emailBox);
		emailResult.setText("Type email address and click the button");
		hPanelEmail.add(emailResult);
		horizontalPanels.add(hPanelEmail);
		
		HorizontalPanel hPanelRadio = new HorizontalPanel();
		radioButton1 = new RadioButton("radioGroup", "Subscribe to newsletter");
		radioButton1.setValue(true);
		radioButton2 = new RadioButton("radioGroup", "Don't subscribe to newsletter");
		radioButton2.setValue(false);
		hPanelRadio.add(radioButton1);
		hPanelRadio.add(radioButton2);
		horizontalPanels.add(hPanelRadio);
		
		HorizontalPanel hPanelSend = new HorizontalPanel();
		Button sendButton = new Button("Send email");
		sendButton.addClickHandler(new SendingButtonClickHandler());
		hPanelSend.add(sendButton);
		sendingResult.setText("Click to send your email");
		hPanelSend.add(sendingResult);
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
	
	private class SendingButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			int correctDataAmount = 0;
			String name = nameBox.getText();
			String surname = surnameBox.getText();
			String phone = phoneBox.getText();
			String email = emailBox.getText();
			boolean newsletter = false;

			if (!validation.validateNameOrSurname(name)) {
				updateNameResult("Invalid input");
			} else {
				++correctDataAmount;
				updateNameResult("Name saved");
			}
			
			if (!validation.validateNameOrSurname(surname)) {
				updateSurnameResult("Invalid input");
			} else {
				++correctDataAmount;
				updateSurnameResult("Surname saved");
			}
			
			if (!validation.validatePhone(phone)) {
				updatePhoneResult("Invalid input");
			} else {
				++correctDataAmount;
				updatePhoneResult("Phone saved");
			}
			
			if (!validation.validateEmail(email)) {
				updateEmailResult("Invalid input");
			} else {
				++correctDataAmount;
				updateEmailResult("Email saved");
			}
			
			if (radioButton1.isChecked()) {
				newsletter = true;
			}
			
			if (correctDataAmount > 3) {
				clientImpl.sendEmail(name, surname, phone, email, newsletter);
			}
		}
	}
}
