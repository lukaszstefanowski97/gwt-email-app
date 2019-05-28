package com.ncdc.emailApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
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
	
//	@UiField
//	Label newsletter = new Label();
//	
//	@UiField
//	Label notNewsletter = new Label();
	
	private Validation validation = new ValidationImpl();
	
	private ClientImpl clientImpl;
	
	public UI(ClientImpl client) {
		this.clientImpl = client;
		initWidget(uiBinder.createAndBindUi(this));
		button.addClickHandler(new SendingButtonClickHandler());
		this.radioButton1.setText(Messages.NEWSLETTER);
		this.radioButton2.setText(Messages.NOT_NEWSLETTER);
	}
	
	private class SendingButtonClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			final String name = nameBox.getText();
			final String surname = surnameBox.getText();
			final String phone = phoneBox.getText();
			final String email = emailBox.getText();
			final boolean newsletter = radioButton1.getValue();
			
			if (validation.validate(name, surname, phone, email)) {
				clientImpl.sendEmail(name, surname, phone, email, newsletter);
			}
		}
	}
}
