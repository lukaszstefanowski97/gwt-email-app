package com.ncdc.emailApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UI extends Composite {

	private static UIUiBinder uiBinder = GWT.create(UIUiBinder.class);

	interface UIUiBinder extends UiBinder<Widget, UI> {
	}

	@UiField
	TextBox nameBox;
	
	@UiField
	TextBox surnameBox;
	
	@UiField
	TextBox phoneBox;
	
	@UiField
	TextBox emailBox;
	
	@UiField
	RadioButton radioButton1;
	
	@UiField
	RadioButton radioButton2;
	
	@UiField
	Button button;
	
	private Validation validation = new ValidationImpl();
	
	private ClientImpl clientImpl;
	
	public UI(ClientImpl client) {
		this.clientImpl = client;
		initWidget(uiBinder.createAndBindUi(this));
		button.addClickHandler(new SendingButtonClickHandler());
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
				nameBox.setText("Invalid input");
			} else {
				++correctDataAmount;
				nameBox.setText("Name saved");
			}
			
			if (!validation.validateNameOrSurname(surname)) {
				surnameBox.setText("Invalid input");
			} else {
				++correctDataAmount;
				surnameBox.setText("Surname saved");
			}
			
			if (!validation.validatePhone(phone)) {
				phoneBox.setText("Invalid input");
			} else {
				++correctDataAmount;
				phoneBox.setText("Phone number saved");
			}
			
			if (!validation.validateEmail(email)) {
				emailBox.setText("Invalid input");
			} else {
				++correctDataAmount;
				emailBox.setText("Email address saved");
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
