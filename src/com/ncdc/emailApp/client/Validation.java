package com.ncdc.emailApp.client;

public interface Validation {

	public boolean validateNameOrSurname(String nameOrSurname);
	public boolean validatePhone(String phone);
	public boolean validateEmail(String email);
}
