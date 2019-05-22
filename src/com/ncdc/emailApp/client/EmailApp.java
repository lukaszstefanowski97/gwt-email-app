package com.ncdc.emailApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class EmailApp implements EntryPoint {

	@Override
	public void onModuleLoad() {
		ClientImpl client = new ClientImpl(GWT.getModuleBaseURL() + "service");
		RootPanel.get().add(client.getMainGUI());
	}
}
