package com.ncdc.emailApp.client;

import java.util.LinkedList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class MainGUI extends Composite {
	
	private TextBox nameBox = new TextBox();;
	private TextBox surnameBox = new TextBox();;
	private TextBox phoneBox = new TextBox();;
	private TextBox emailBox = new TextBox();;
	private LinkedList <HorizontalPanel> horizontalPanels = new LinkedList<>();
	private VerticalPanel vPanel = new VerticalPanel();
	private ClientImpl clientImpl;
	private Validation validation = new ValidationImpl();
	private RadioButton radioButton1;
	private RadioButton radioButton2;
	
	private HorizontalPanel createHPanelTextBox(TextBox textBox, String message) {
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(textBox);
		textBox.setText(message);
		return hPanel;
	}

	public MainGUI(ClientImpl client) {
		initWidget(this.vPanel);
		this.clientImpl = client;
		
		horizontalPanels.add(createHPanelTextBox(nameBox, Messages.NAME));
		horizontalPanels.add(createHPanelTextBox(surnameBox, Messages.SURNAME));
		horizontalPanels.add(createHPanelTextBox(phoneBox, Messages.PHONE));
		horizontalPanels.add(createHPanelTextBox(emailBox, Messages.EMAIL));
		
		HorizontalPanel hPanelRadio = new HorizontalPanel();
		radioButton1 = new RadioButton("radioGroup", "Subscribe to newsletter");
		radioButton1.setValue(true);
		radioButton2 = new RadioButton("radioGroup", "Don't subscribe to newsletter");
		radioButton2.setValue(false);
		hPanelRadio.add(radioButton1);
		hPanelRadio.add(radioButton2);
		horizontalPanels.add(hPanelRadio);
		
		HorizontalPanel hPanelSend = new HorizontalPanel();
		Button sendButton = new Button(Messages.SEND_EMAIL);
		sendButton.addClickHandler(new SendingButtonClickHandler());
		hPanelSend.add(sendButton);
		horizontalPanels.add(hPanelSend);
		
		for (HorizontalPanel hPanel : horizontalPanels) {
			vPanel.add(hPanel);
		}
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
