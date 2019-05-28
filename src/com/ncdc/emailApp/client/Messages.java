package com.ncdc.emailApp.client;


public class Messages {

	public static final String NEWSLETTER = "Subscribe to newsletter";
	public static final String NOT_NEWSLETTER = "Don't subscribe to newsletter";
	public static final String NAME = "Name";
	public static final String SURNAME = "Surname";
	public static final String PHONE = "Phone";
	public static final String EMAIL = "Email";
	public static final String SEND_EMAIL = "Send email";
	public static final String EMAIL_SENT = "Email sent";
	public static final String SENDING_ERROR = "An error has ocurred";
	public static final String RADIO_GROUP = "group";
	public static final String EMAIL_REGEX = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\."
			+ "([a-zA-Z]{2,5})$";
	
	public static final String NAME_REGEX = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";
	public static final String PHONE_REGEX = "\\d{9}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
;}
